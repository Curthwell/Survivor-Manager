package com.Survivor.app.Entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Robot {
    private String model;
    private String serialNumber;
    //private LocalDateTime manufacturedDate;
    private String category;

    public Robot() {
    }
//, LocalDateTime manufacturedDate
    public Robot(String model, String serialNumber, String category) {
        this.model = model;
        this.serialNumber = serialNumber;
        //this.manufacturedDate = manufacturedDate;
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

/*    public LocalDateTime getManufacturedDate() {
        return manufacturedDate;
    }*/

/*
    public void setManufacturedDate(LocalDateTime manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }
*/

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
