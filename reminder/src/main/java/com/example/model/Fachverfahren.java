package com.example.model;

import java.util.List;

public class Fachverfahren {

    private int id;
    private String name;
    private List<ITVerfahren> itVerfahren;

    public Fachverfahren(int id, String name, List<ITVerfahren> itVerfahren) {
        this.id = id;
        this.name = name;
        this.itVerfahren = itVerfahren;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ITVerfahren> getItVerfahren() {
        return itVerfahren;
    }

    public void setItVerfahren(List<ITVerfahren> itVerfahren) {
        this.itVerfahren = itVerfahren;
    }
}
