package pl.altkom.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity(name = "baza_samochodow")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "MARKA")
    @Size(min = 2, max = 20, message = "{name.correctlenght}")
    private String brand;
    @NotNull
    @Column(name = "MODEL")
    @Size(min = 2, max = 20, message ="{name.correctlenght}" )
    private String model;
    @NotNull
    @Column(name = "KOLOR")
    @Size(min = 2, max = 20, message = "{name.correctlenght}")
    private String colour;
    @NotNull(message = "{date.info}")
    @Column(name = "DATA_PRODUKCJI")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate yearOfProduction;
    @NotNull
    @Column(name = "NUMER_VIN")
    @Size(min = 17, max = 17, message = "{vin.correctlenght}")
    private String vin;


    public Car() {
    }

    public Car(String brand, String model, String colour, LocalDate yearOfProduction, String vin) {
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.yearOfProduction = yearOfProduction;
        this.vin = vin;
    }

    public Car(Long id, String brand, String model, String colour, LocalDate yearOfProduction, String vin) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.yearOfProduction = yearOfProduction;
        this.vin = vin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDate getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(LocalDate yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
