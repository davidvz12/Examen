package com.example.examen.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Volumenes {
    String cover,date_published,doi,issue_id,number,title,volume,year;

    public Volumenes(String cover, String date_published, String doi, String issue_id, String number, String title, String volume, String year) {
        this.cover = cover;
        this.date_published = date_published;
        this.doi = doi;
        this.issue_id = issue_id;
        this.number = number;
        this.title = title;
        this.volume = volume;
        this.year = year;
    }
    public Volumenes() {
    }

    public Volumenes(JSONObject a) throws JSONException {

        date_published =  "Date published :" + a.getString("date_published").toString();
        doi = "DOI : " + a.getString("doi").toString() ;
        issue_id =  "Issue id : "+a.getString("issue_id").toString() ;
        number = "Number : " + a.getString("number").toString() ;
        title = a.getString("title").toString() ;
        volume = "Volume : "+a.getString("volume").toString() ;
        year = "Year : "+ a.getString("year").toString() ;
        cover = a.getString("cover").toString() ;
    }

    public static ArrayList<Volumenes> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Volumenes> volumen = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            volumen.add(new Volumenes(datos.getJSONObject(i)));
        }
        return volumen;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
