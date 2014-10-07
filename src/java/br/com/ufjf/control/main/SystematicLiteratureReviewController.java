/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufjf.control.main;

import br.com.ufjf.dao.UserDAO;
import br.com.ufjf.model.parsifal.Review;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author vitorfs
 */
public class SystematicLiteratureReviewController implements Serializable {

    private static final long serialVersionUID = 1L;
    private UserDAO userDao;
    private Review review;

    public SystematicLiteratureReviewController() {
        this.userDao = new UserDAO();
    }
    
    public static void main(String[] args) {
        SystematicLiteratureReviewController slrc = new SystematicLiteratureReviewController();
    }

    /**
     * @return the review
     */
    public Review getReview() {
        try {
            String uri = "http://127.0.0.1:8000/api/reviews/vitorfs/effort-estimation-in-global-software-development/";
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            InputStream json = connection.getInputStream();
            Gson gson = new Gson();
            BufferedReader reader = new BufferedReader(new InputStreamReader(json));
            review = gson.fromJson(reader, Review.class);
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();   
        }
        return review;
    }

    /**
     * @param review the review to set
     */
    public void setReview(Review review) {
        this.review = review;
    }
    
    
}