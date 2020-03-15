package pl.betleja.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 20, message = "{driverFormError.incorrectFirstNameLength}")
    @Column(name = "Imię")
    private String firstName;


    @Size(min = 2, max = 20, message = "{driverFormError.incorrectLastNameLength}")
    @Column(name = "Nazwisko")
    private String lastName;

    @Column(name = "distance_taken")
    private Long distanceTaken;

    public Driver(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "driver_id")
    private List<Route> routes = new ArrayList<>(0);

    public void addRoute(final Route route){
        this.routes.add(route);
    }

    public Driver() {
        setDistanceTaken(Long.valueOf(0));
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getDistanceTaken() {
        return distanceTaken;
    }

    public void setDistanceTaken(Long distanceTaken) {
        this.distanceTaken = distanceTaken;
    }
}
