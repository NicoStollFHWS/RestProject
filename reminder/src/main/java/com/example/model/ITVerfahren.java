package com.example.model;

public class ITVerfahren {

    private int id;
    private String name;
    private String itKuerzel;
    private String team;
    private String ansprechpartner;

    public ITVerfahren(int id, String name, String itKuerzel, String team, String ansprechpartner) {
        this.id = id;
        this.name = name;
        this.itKuerzel = itKuerzel;
        this.team = team;
        this.ansprechpartner = ansprechpartner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItKuerzel() {
        return itKuerzel;
    }

    public void setItKuerzel(String itKuerzel) {
        this.itKuerzel = itKuerzel;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }
}
