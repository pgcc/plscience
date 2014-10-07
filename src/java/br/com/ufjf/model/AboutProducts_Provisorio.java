/*
 * Copyright 2009 Prime Technology.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.ufjf.model;

import java.io.Serializable;

/**
 * Class AboutProducts_Provisorio
 *
 * @category
 * @author magnus, anrafel, jonathan
 *
 */
public class AboutProducts_Provisorio implements Serializable{

    private static final long serialVersionUID = 1L;
    private String name;
    private String institution;
    private String date;
    private String time;
    private String activity;
    private String productName;
    private String purpose;
    private String how;
    private String notes;
    private String interations;

    public AboutProducts_Provisorio(String name, String institution,
            String date, String time, String activity, String productName,
            String purpose, String how, String notes, String interations) {
        this.name = name;
        this.institution = institution;
        this.date = date;
        this.time = time;
        this.activity = activity;
        this.productName = productName;
        this.purpose = purpose;
        this.how = how;
        this.notes = notes;
        this.interations = interations;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String activity) {
        this.institution = activity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getHow() {
        return how;
    }

    public void setHow(String how) {
        this.how = how;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getInterations() {
        return interations;
    }

    public void setInterations(String interations) {
        this.interations = interations;
    }

}
