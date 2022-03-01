package com.example.core;

import com.example.model.Fachverfahren;
import com.example.model.ITVerfahren;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    Manager manager = new Manager();

    @GetMapping("/api/verfahrensliste")
    public String getVerfahrensliste() {
        return manager.getVerfahrensliste();
    }

    @GetMapping("/api/verfahrensliste/fachverfahren")
    public String getAllFachverfahren() {
        return manager.getAllFachverfahren();
    }

    @PostMapping("/api/verfahrensliste/fachverfahren")
    public String postFachverfahren(@RequestBody Fachverfahren neuesFachverfahren) {
        return manager.postFachverfahren(neuesFachverfahren);
    }

    @PutMapping("/api/verfahrensliste/fachverfahren")
    public String putFachverfahren(@RequestBody Fachverfahren updatedFachverfahren) {
        return manager.putFachverfahren(updatedFachverfahren);
    }

    @DeleteMapping("/api/verfahrensliste/fachverfahren/{id}")
    public void deleteFachverfahren(@PathVariable int id) {
        manager.deleteFachverfahren(id);
    }
    
    @GetMapping("/api/verfahrensliste/fachverfahren/{id}")
    public String getFachverfahren(@PathVariable int id) {
        return manager.getFachverfahren(id);
    }

    @GetMapping("/api/verfahrensliste/fachverfahren/{id}/itverfahren")
    public String getAllITVerfahren(@PathVariable int id) {
        return manager.getAllITVerfahren(id);
    }

    @GetMapping("/api/verfahrensliste/fachverfahren/{id}/itverfahren/{id2}")
    public String getITVerfahren(@PathVariable int id, @PathVariable int id2) {
        return manager.getITVerfahren(id, id2);
    }

    @PostMapping("/api/verfahrensliste/fachverfahren/{id}/itverfahren/")
    public String postItVerfahren(@PathVariable int id, @RequestBody ITVerfahren neuesItVerfahren) {
        return manager.postITVerfahren(id, neuesItVerfahren);
    }

    @PutMapping("/api/verfahrensliste/fachverfahren/{id}/itverfahren")
    public String putItVerfahren(@RequestBody int id, @RequestBody ITVerfahren updatedItVerfahren) {
        return manager.postITVerfahren(id, updatedItVerfahren);
    }

    @DeleteMapping("api/verfahrensliste/fachverfahren/{id}/itverfahren/{id2}")
    public void deleteItVerfahren(@PathVariable int id, @PathVariable int id2) {
        manager.deleteITVerfahren(id, id2);
    }




}
