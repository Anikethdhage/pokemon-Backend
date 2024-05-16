package com.hivel.pokemon.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "pokemon_details")
@Entity
@NoArgsConstructor
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private List<String> abilities;
    private String type;
    private int hitPoints;
    private List<String> evolution;
    private String imageUrl;

    public Pokemon(int id, String name, List<String> abilities, String type, int hitPoints, List<String> evolution, String imageUrl) {
        this.id = id;
        this.name = name;
        this.abilities = abilities;
        this.type = type;
        this.hitPoints = hitPoints;
        this.evolution = evolution;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        if(hitPoints > 100){
            throw new RuntimeException("Hit points should not be greater than 100");
        }
        this.hitPoints = hitPoints;
    }

    public List<String> getEvolution() {
        return evolution;
    }

    public void setEvolution(List<String> evolution) {
        this.evolution = evolution;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // toString method
    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abilities=" + abilities +
                ", type='" + type + '\'' +
                ", hitPoints=" + hitPoints +
                ", evolution=" + evolution +
                ", ImageUrl='" + imageUrl + '\'' +
                '}';
    }
}
