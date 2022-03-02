package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Verfahrensliste {

    private final String name = "Verfahrensliste GB0500";
    private List<Fachverfahren> fachverfahren;

    public Verfahrensliste() {
        this.fachverfahren = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Fachverfahren> getFachverfahren() {
        return fachverfahren;
    }

    public void addFachverfahren(Fachverfahren fachverfahren) {
        this.fachverfahren.add(fachverfahren);
    }

    public void setFachverfahren(List<Fachverfahren> fachverfahren) {
        this.fachverfahren = fachverfahren;
    }
}
