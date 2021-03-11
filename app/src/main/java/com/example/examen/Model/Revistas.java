package com.example.examen.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revistas {

    String journal_id,portada,abbreviation,description,name;

    public Revistas(String journal_id, String portada, String abbreviation, String description, String name) {
        this.journal_id = journal_id;
        this.portada = portada;
        this.abbreviation = abbreviation;
        this.description = description;
        this.name = name;
    }

    public Revistas() {

    }
    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Revistas(JSONObject a) throws JSONException {

        journal_id =  "Journal_id :" + a.getString("journal_id").toString();
        portada =  a.getString("portada").toString() ;
        abbreviation =  "Abbreviation : "+a.getString("abbreviation").toString() ;
        description = "Description : " + a.getString("description").toString() ;
        name = a.getString("name").toString() ;
    }

    public static ArrayList<Revistas> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revistas> revista = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            revista.add(new Revistas(datos.getJSONObject(i)));
        }
        return revista;
    }

}
