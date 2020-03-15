package pl.betleja.model;

import org.springframework.format.annotation.DateTimeFormat;
import pl.betleja.model.validators.CannotBeEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "baza_samochodow")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "MARKA")
    @Size(min = 2, max = 20, message = "{carFormError.incorrectCarBrandLength}")
    private String brand;

    @NotNull
    @Column(name = "MODEL")
    @Size(min = 2, max = 20, message = "{carFormError.incorrectCarModelLength}")
    private String model;

    @CannotBeEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "KOLOR")
    private Color color;

    @CannotBeEmpty
    @PastOrPresent(message = "Data produkcji nie moze byc w przyszlosci!")
    @Column(name = "DATA_PRODUKCJI")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate yearOfProduction;

    @NotNull
    @Column(name = "NUMER_VIN")
    @Size(min = 17, max = 17, message = "{carFormError.incorrectVinLength}")
    private String vin;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "car_id")
    private List<Route> routes = new ArrayList<>(0);

    public void addRoute(final Route route){
        this.routes.add(route);
    }
    

    public Car() {
    }

    public Car(String brand, String model, Color color, LocalDate yearOfProduction, String vin) {
        this.brand = brand;
        this.model = model;
        this.color = color;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public List<Route> getRoutes() {
        return routes;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", VIN='" + vin + '\'' +
                '}';
    }

}
