package pl.altkom.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.altkom.model.Car;
import pl.altkom.model.Driver;
import pl.altkom.repository.CarRepositoryDataJpaImpl;
import pl.altkom.repository.DriverRepositoryDataJpaImpl;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Service
public class DataGenerator {

    @Autowired
    private CarRepositoryDataJpaImpl dao;

    @Autowired
    private DriverRepositoryDataJpaImpl driverDao;

    @PostConstruct
    public void createSomeData(){

        dao.save(new Car("Ferrari", "California", "Czerwony", LocalDate.of(2002,5,1), "12345678987358253"));
        dao.save(new Car("Peugeot", "207", "Czarny", LocalDate.of(2019,8,27), "92650165825305725"));
        dao.save(new Car("Peugeot", "307", "Srebrny", LocalDate.of(2011,1,20), "12321212195843286"));
        dao.save(new Car("Ferrari", "Testarossa", "Żółty", LocalDate.of(2014,2,18), "92503619456124521"));
        dao.save(new Car("Ford", "Fiesta", "Czarny", LocalDate.of(2002,4,2), "99976283945128476"));
        dao.save(new Car("Ford", "Ka", "Niebieski", LocalDate.of(1999,9,3), "82564894762374893"));
        dao.save(new Car("Volkswagen", "Golf", "Srebrny", LocalDate.of(2001,6,1), "82362376486326736"));
        dao.save(new Car("Audi", "A4", "Czarny", LocalDate.of(2007,4,9), "65754754547676474"));
        dao.save(new Car("Skoda", "Fabia", "Niebieski", LocalDate.of(2008,9,12), "28463786455647388"));
        dao.save(new Car("Seat", "Ibiza", "Żółty", LocalDate.of(1995,1,19), "23462837528777733"));
        dao.save(new Car("Audi", "A6", "Srebrny", LocalDate.of(2004,12,10), "72648473548590483"));
        dao.save(new Car("Ford", "Mustang", "Zielony", LocalDate.of(2019,10,3), "82564894762374893"));
        dao.save(new Car("Ford", "Everest", "Srebrny", LocalDate.of(2005,9,8), "82564894762374893"));
        dao.save(new Car("Ford", "Focus", "Niebieski", LocalDate.of(1990,1,10), "82564894762374893"));

        driverDao.save(new Driver("Jan", "Kowalski"));
        driverDao.save(new Driver("Maciej", "Nowak"));
        driverDao.save(new Driver("John", "Smith"));
        driverDao.save(new Driver("Dawid", "Wiśniewski"));

    }



}
