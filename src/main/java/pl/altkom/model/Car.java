package pl.altkom.model;

public class Car {

    private int id;
    private String brand;
    private String model;
    private String colour;
    private String dateOfProduction;
    private String vin;

    public Car() {
    }

    public Car(String brand, String model, String colour, String dateOfProduction, String vin) {
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.dateOfProduction = dateOfProduction;
        this.vin = vin;
    }

    public Car(int id, String brand, String model, String colour, String dateOfProduction, String vin) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.dateOfProduction = dateOfProduction;
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

    public String getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(String dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
