package com.example.examen.Model;

public class Edicion {

    String authors,date_published,doi,publication_id,section,section_id,UrlViewGalley,nombres;


    public Edicion(String authors, String date_published, String doi, String publication_id, String section, String section_id, String urlViewGalley, String nombres) {
        this.authors = authors;
        this.date_published = date_published;
        this.doi = doi;
        this.publication_id = publication_id;
        this.section = section;
        this.section_id = section_id;
        UrlViewGalley = urlViewGalley;
        this.nombres = nombres;
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

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(String publication_id) {
        this.publication_id = publication_id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getUrlViewGalley() {
        return UrlViewGalley;
    }

    public void setUrlViewGalley(String urlViewGalley) {
        UrlViewGalley = urlViewGalley;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
