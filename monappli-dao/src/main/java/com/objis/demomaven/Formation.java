package com.objis.demomaven;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Formation {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private Long id; // Identifiant formation (Clé primaire)

    private String theme; // Thème formation

    public Formation() {
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

    // Constructeur
    public Formation(String theme) {
        super();
        this.theme = theme;
    }
}
