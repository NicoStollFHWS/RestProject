package com.example.core;

import com.example.model.Fachverfahren;
import com.example.model.ITVerfahren;
import org.springframework.stereotype.Component;

@Component
public class Manager {

    public String getVerfahrensliste() {
        return "NOT YET IMPLEMENTED";
    }

    public String getAllFachverfahren() {
        return "NOT YET IMPLEMENTED";
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
        return "NOT YET IMPLEMENTED";
    }

    public String getITVerfahren(int fachverfahrensId, int itVerfahrenId) {
        return "NOT YET IMPLEMENTED";
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
