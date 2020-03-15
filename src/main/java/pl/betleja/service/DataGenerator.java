package pl.betleja.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.betleja.model.Car;
import pl.betleja.model.Color;
import pl.betleja.model.Driver;
import pl.betleja.repository.CarRepositoryDataJpaImpl;
import pl.betleja.repository.DriverRepositoryDataJpaImpl;
import pl.betleja.repository.RouterepositoryDataJpaImpl;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Service
public class DataGenerator {

    @Autowired
    private CarRepositoryDataJpaImpl dao;

    @Autowired
    private DriverRepositoryDataJpaImpl driverDao;

    @Autowired
    RouterepositoryDataJpaImpl routesDao;

    Driver driverOne = new Driver();
    Driver driverTwo = new Driver();


    @PostConstruct
    public void saveDrivers(){
        driverOne.setFirstName("Jan");
        driverOne.setLastName("Kowalski");
        driverDao.save(driverOne);
        driverTwo.setFirstName("John");
        driverTwo.setLastName("Smith");
        driverDao.save(driverTwo);
    }

    @PostConstruct
    public void createSomeData(){
        dao.save(new Car("Ferrari", "California", Color.RED, LocalDate.of(2002,5,1), "12345678987358253"));
        dao.save(new Car("Peugeot", "207", Color.BLACK, LocalDate.of(2019,8,27), "92650165825305725"));
        dao.save(new Car("Peugeot", "307", Color.SILVER, LocalDate.of(2011,1,20), "12321212195843286"));
        dao.save(new Car("Ferrari", "Testarossa", Color.YELLOW, LocalDate.of(2014,2,18), "92503619456124521"));
        dao.save(new Car("Ford", "Fiesta", Color.BLACK, LocalDate.of(2002,4,2), "99976283945128476"));
        dao.save(new Car("Ford", "Ka", Color.BLUE, LocalDate.of(1999,9,3), "82564894762374893"));
        dao.save(new Car("Volkswagen", "Golf", Color.SILVER, LocalDate.of(2001,6,1), "82362376486326736"));
        dao.save(new Car("Audi", "A4", Color.BLACK, LocalDate.of(2007,4,9), "65754754547676474"));
        dao.save(new Car("Skoda", "Fabia", Color.BLUE, LocalDate.of(2008,9,12), "28463786455647388"));
        dao.save(new Car("Seat", "Ibiza", Color.YELLOW, LocalDate.of(1995,1,19), "23462837528777733"));
        dao.save(new Car("Audi", "A6", Color.SILVER, LocalDate.of(2004,12,10), "72648473548590483"));
        dao.save(new Car("Ford", "Mustang", Color.GREEN, LocalDate.of(2019,10,3), "82564894762374893"));
        dao.save(new Car("Ford", "Everest", Color.SILVER, LocalDate.of(2005,9,8), "82564894762374893"));
        dao.save(new Car("Ford", "Focus", Color.BLUE, LocalDate.of(1990,1,10), "82564894762374893"));

    }



}
