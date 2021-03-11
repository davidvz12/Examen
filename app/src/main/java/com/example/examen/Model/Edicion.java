package com.example.examen.Model;

public class Edicion {

    String authors,date_published,section,UrlViewGalley;

    public Edicion(String authors, String date_published, String section, String urlViewGalley) {
        this.authors = authors;
        this.date_published = date_published;
        this.section = section;
        UrlViewGalley = urlViewGalley;
    }

    public Edicion() {

    }
    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }


    public String getUrlViewGalley() {
        return UrlViewGalley;
    }

    public void setUrlViewGalley(String urlViewGalley) {
        UrlViewGalley = urlViewGalley;
    }

}
