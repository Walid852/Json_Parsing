package org.example;

public class Building {
    private String blName;
    private String city;
    private String foundationYear;

    public Building(String blName, String city, String foundationYear) {
        this.blName = blName;
        this.city = city;
        this.foundationYear = foundationYear;
    }

    public String getBlName() {
        return blName;
    }

    public void setBlName(String blName) {
        this.blName = blName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(String foundationYear) {
        this.foundationYear = foundationYear;
    }


}
