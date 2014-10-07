package br.com.ufjf.control.main;

import br.com.ufjf.dao.ArtifactDAO;
import br.com.ufjf.dao.UserDAO;
import br.com.ufjf.model.main.Artifact;
import br.com.ufjf.p2p.Peer;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe UploadController
 *
 * @category control
 * @author vitor
 *
 */
public class NetworkController implements Serializable {

    private static final long serialVersionUID = 1L;
    private UserDAO userDao;

    public NetworkController() {
        this.userDao = new UserDAO();
    }

    public String network() {
        List<String> files = new ArrayList<String>();
        files.add("P1_1.txt");
        files.add("P1_2.txt");
        try {
            Peer.getInstance().connect();
            Peer.getInstance().addFiles(files);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "network";
    }
    
    public ArrayList<Artifact> getArtifactsList() {
        ArtifactDAO dao = new ArtifactDAO();
        ArrayList<Artifact> listaArtifacts = (ArrayList<Artifact>) dao.todosArtifact();
        return listaArtifacts;
    }

}
