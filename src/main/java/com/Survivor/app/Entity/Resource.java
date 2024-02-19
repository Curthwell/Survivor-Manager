package com.Survivor.app.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Resource {
    private String water;
    private String medication;
    private String ammunition;
    private String food;

    public Resource() {
    }

    public Resource(String water, String medication, String ammunition, String food) {
        this.water = water;
        this.medication = medication;
        this.ammunition = ammunition;
        this.food = food;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(String ammunition) {
        this.ammunition = ammunition;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
