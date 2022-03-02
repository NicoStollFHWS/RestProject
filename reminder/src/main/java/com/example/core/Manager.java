package com.example.core;

import com.example.dao.Repository;
import com.example.model.Fachverfahren;
import com.example.model.ITVerfahren;
import com.google.gson.Gson;

public class Manager {

    Repository repos = new Repository();
    Gson gson = new Gson();

    public String getVerfahrensliste() {
        return gson.toJson(repos.getVerfahrensliste());
    }

    public String getAllFachverfahren() {
        return gson.toJson(repos.getAllFachverfahren());
    }

    public String getFachverfahren(int id) {
        return "NOT YET IMPLEMENTED";
    }

    public void deleteFachverfahren(int id) {
        System.err.println("NOT YET IMPLEMENTED");
    }

    public String postFachverfahren(Fachverfahren neuesFachverfahren) {
        return "NOT YET IMPLEMENTED";
    }

    public String putFachverfahren(Fachverfahren neuesFachverfahren) {
        return "NOT YET IMPLEMENTED";
    }

    public String getAllITVerfahren(int fachverfahrensId) {
        return gson.toJson(repos.getAllItVerfahren(fachverfahrensId));
    }

    public String getITVerfahren(int fachverfahrensId, int itVerfahrenId) {
        return gson.toJson(repos.getItVerfahren(fachverfahrensId, itVerfahrenId));
    }

    public String postITVerfahren(int fachverfahrensId, ITVerfahren itVerfahren) {
        return "NOT YET IMPLEMENTED";
    }

    public void deleteITVerfahren(int fachverfahrenId, int itVerfahrensId) {
        System.err.println("NOT YET IMPLEMENTED");
    }

    public String putITVerfahren(int fachverfahrensId, ITVerfahren itVerfahren) {
        return "NOT YET IMPLEMENTED";
    }
}
