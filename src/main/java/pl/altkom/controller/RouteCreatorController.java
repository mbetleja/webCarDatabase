package pl.altkom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.altkom.model.Car;
import pl.altkom.model.Driver;
import pl.altkom.model.Route;
import pl.altkom.repository.CarRepositoryDataJpaImpl;
import pl.altkom.repository.DriverRepositoryDataJpaImpl;
import pl.altkom.repository.RouterepositoryDataJpaImpl;

import java.util.List;

@Controller
public class RouteCreatorController {

    @Autowired
    private DriverRepositoryDataJpaImpl dao;

    @Autowired
    private CarRepositoryDataJpaImpl carDao;

    @Autowired
    private RouterepositoryDataJpaImpl routeDao;

    @GetMapping("/addRoute")
    public String newRouteForm(final Model model, Route route){

        List<Driver> allDrivers = dao.findAll();
        model.addAttribute("allDrivers", allDrivers);

        List<Car> allCars = carDao.findAll();
        model.addAttribute("allCars", allCars);
        return "newRouteForm";
    }

    @PostMapping("/addRoute")
    public String processNewRouteForm(final Route route){
        // 1. Pobieramy konkretnego kierowce - wg id z 'route'
        Long driverId = route.getDriverId();
        Driver driver = dao.getOne(driverId);
        // 2. Dla pobranego kierowcy dodajemy trase
        driver.addRoute(route);
        // 3. Zapisujemy trase, kierowce i pojazd
            //dodajemy car
        Long carId = route.getCarId();
        Car car = carDao.getOne(carId);
        car.addRoute(route);
            // zapis i update
        routeDao.save(route);
        dao.save(driver);
        carDao.save(car);

        return "redirect:/";
    }

    @GetMapping(path ="/showDriverRoutes")
    public String showRoutes(final Model model, @RequestParam(name = "driverId") Long driverId){
        Driver driver = dao.getOne(driverId);
        List<Route> routes =driver.getRoutes();
        model.addAttribute("allDriverRoutes", routes);
        return "allDriverRoutes";
    }



}
