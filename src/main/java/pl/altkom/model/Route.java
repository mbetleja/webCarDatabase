package pl.altkom.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Trasa")
    private String routeName;

    @Column(name = "Adres_początkowy")
    private String startAddress;

    @Column(name = "Adres_docelowy")
    private String endAddress;

    @Column(name = "Data_rozppoczęcia")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "Czas_rozpoczęcia")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime plannedStartTime;

    @Column(name = "Data_rozpoczęcia")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Column(name = "Data_zakończenia")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime plannedEndTime;

    @Transient
    private Long driverId;

    @Transient
    private Long carId;



    public Route(String routeName, String startAddress, String endAddress, LocalDate startDate,
                 LocalTime plannedStartTime, LocalDate endDate, LocalTime plannedEndTime) {
        this.routeName = routeName;
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.startDate = startDate;
        this.plannedStartTime = plannedStartTime;
        this.endDate = endDate;
        this.plannedEndTime = plannedEndTime;
    }

    public Route() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getPlannedStartTime() {
        return plannedStartTime;
    }

    public void setPlannedStartTime(LocalTime plannedStartTime) {
        this.plannedStartTime = plannedStartTime;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getPlannedEndTime() {
        return plannedEndTime;
    }

    public void setPlannedEndTime(LocalTime plannedEndTime) {
        this.plannedEndTime = plannedEndTime;
    }

    public Long getDriverId() {
        return driverId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;


    }
}

