package br.com.ufjf.p2p;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class Peer {
    
    private static final Peer INSTANCE = new Peer();

    private String master;
    private String ip;
    private int port;

    public static int SERVER_PORT = 5000;

    private Server server;
   
    private Peer(String master) {
        port = 5500 + (int) (Math.random() * ((6000 - 5500) + 1));
        System.out.println("Working at " + port);
        this.master = master;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    server = new Server();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    private Peer() {
        this("localhost");
        this.ip = "192.168.0.3";
    }
    
    public static Peer getInstance(){
        return INSTANCE;
    }

    public void connect() throws UnknownHostException, IOException {
        Socket socket = new Socket(master, SERVER_PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        if (ip == null) {
            ip = InetAddress.getLocalHost().getHostAddress();
        }
        out.println("connect=" + ip + ":" + port);
        out.flush();
        socket.close();

        System.out.println("Connected to: " + master);
    }

    public void addFiles(List<String> files) throws UnknownHostException,
            IOException {
        Socket socket = new Socket(master, SERVER_PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        if (ip == null) {
            ip = InetAddress.getLocalHost().getHostAddress();
        }
        String data = "";
        for (String file : files) {
            data += file + ",";
        }
        data = data.substring(0, data.length() - 1);
        out.println("add_files=" + ip + "{" + data + "}");
        out.flush();
        socket.close();

        System.out.println("Sent files: " + data);
    }

    public List<String> searchFile(String file) throws UnknownHostException,
            IOException, ClassNotFoundException {
        Socket socket = new Socket(master, SERVER_PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        if (ip == null) {
            ip = InetAddress.getLocalHost().getHostAddress();
        }

        out.println("search_file=" + file);
        out.flush();

        BufferedReader in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        String msn = in.readLine();
        socket.close();

        String ips = msn.substring(msn.indexOf("{") + 1, msn.indexOf("}"));
        if (!"empty".equals(ips)) {
            return Arrays.asList(ips.split(","));
        }
        return null;
    }

    public byte[] downloadFile(String peer, String file)
            throws UnknownHostException, IOException {
        String[] addr = peer.split(":");
        String ip = addr[0];
        //para rodar local
        ip = "localhost";
        int port = Integer.parseInt(addr[1]);

        Socket socket = new Socket(ip, port);

        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("upload_file=" + file);
        out.flush();

        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        int len = dis.readInt();
        byte[] data = new byte[len];
        if (len > 0) {
            dis.readFully(data);
        }
        return data;
    }

    private class Server {

        public static final String UPLOAD_FILE_ACTION = "upload_file";

        private Server() throws IOException {
            start();
        }

        private void start() throws IOException {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                final Socket client = server.accept();
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(client
                                            .getInputStream()));
                            String line = in.readLine();
                            String[] data = line.split("=");
                            String action = data[0];
                            String msn = data[1];

                            if (UPLOAD_FILE_ACTION.equals(action)) {
                                byte[] file = uploadFile(msn);
                                int len = file.length;

                                OutputStream os = client.getOutputStream();
                                DataOutputStream dos = new DataOutputStream(os);

                                dos.writeInt(len);
                                if (len > 0) {
                                    dos.write(file, 0, len);
                                }
                                dos.flush();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }

        public byte[] uploadFile(String file) throws FileNotFoundException,
                IOException {
			// reads the file
            // File f = new File("~/FreitasP2P_repository/"+file);
            File f = new File("data/file.txt");
            return IOUtils.toByteArray(new FileInputStream(f));
        }
    }
}
