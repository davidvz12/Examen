package com.example.examen.Model;

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
