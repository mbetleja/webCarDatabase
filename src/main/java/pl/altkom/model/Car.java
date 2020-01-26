package pl.altkom.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Car {

    private int id;
    @NotNull
    @Size(min = 2, max = 20, message = "{name.correctlenght}")
    private String brand;
    @NotNull
    @Size(min = 2, max = 20, message ="{name.correctlenght}" )
    private String model;
    @NotNull
    @Size(min = 2, max = 20, message = "{name.correctlenght}")
    private String colour;
    @NotNull
    @Size(min = 4, max = 4, message = "{year.correctlenght}")
    private String yearOfProduction;
    @NotNull
    @Size(min = 17, max = 17, message = "{vin.correctlenght}")
    private String vin;


    public Car() {
    }

    public Car(String brand, String model, String colour, String yearOfProduction, String vin) {
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.yearOfProduction = yearOfProduction;
        this.vin = vin;
    }

    public Car(int id, String brand, String model, String colour, String yearOfProduction, String vin) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.yearOfProduction = yearOfProduction;
        this.vin = vin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(String yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
