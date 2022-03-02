package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Fachverfahren {

    private int id;
    private String name;
    private List<ITVerfahren> itVerfahren;

    public Fachverfahren(int id, String name) {
        this.id = id;
        this.name = name;
        this.itVerfahren = new ArrayList<>();
    }

    public int getId() {
        return this.id;
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

    public void addItVerfahren(ITVerfahren itVerfahren) {
        this.itVerfahren.add(itVerfahren);
    }

    public void setItVerfahren(List<ITVerfahren> itVerfahren) {
        this.itVerfahren = itVerfahren;
    }
}
