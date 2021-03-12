package com.example.examen.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Edicion {

    String authors, date_published, section, UrlViewGalley, title;

    public Edicion(String authors, String date_published, String section, String urlViewGalley, String title) {
        this.authors = authors;
        this.date_published = date_published;
        this.section = section;
        UrlViewGalley = urlViewGalley;
        this.title = title;
    }

    public Edicion() {
    }



    public Edicion(JSONObject a) throws JSONException {

        date_published =  a.getString("date_published").toString() ;
        section =  a.getString("section").toString() ;
        title = a.getString("title").toString() ;

        authors =  "";
        JSONArray JSONlista =  new JSONArray(a.getString("authors"));

        for (int i = 0; i < JSONlista.length(); i++) {
            JSONObject object = JSONlista.getJSONObject(i);
            if(i==0)
                authors ="";
            else
                authors =authors+", ";
            authors = authors + object.getString("nombres");
        }

        UrlViewGalley = "";
        JSONArray JSONlistaUrl =  new JSONArray(a.getString("galeys"));
        JSONObject object = JSONlistaUrl.getJSONObject(0);
        UrlViewGalley = object.getString("UrlViewGalley");
    }

    public static ArrayList<Edicion> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Edicion> edicion = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            edicion.add(new Edicion(datos.getJSONObject(i)));
        }
        return edicion;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
