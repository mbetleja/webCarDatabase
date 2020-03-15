package pl.betleja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.betleja.model.Car;
import pl.betleja.model.Driver;
import pl.betleja.model.Route;
import pl.betleja.repository.CarRepositoryDataJpaImpl;
import pl.betleja.repository.DriverRepositoryDataJpaImpl;
import pl.betleja.repository.RouterepositoryDataJpaImpl;
import pl.betleja.service.tomTomApi.TomTomApi;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class RouteCreatorController {

    @Autowired
    private DriverRepositoryDataJpaImpl dao;

    @Autowired
    private CarRepositoryDataJpaImpl carDao;

    @Autowired
    private RouterepositoryDataJpaImpl routeDao;

    private TomTomApi tomTomApi = new TomTomApi();

    @GetMapping("/my-map")
    public String map(){

        return "my-map";
    }


    @GetMapping("/submitNewRouteForm")
    public String submitRouteForm(@RequestParam(name = "routeId", required = false) Long routeId, Route route, final Model model) {
        List<Driver> allDrivers = dao.findAll();
        model.addAttribute("allDrivers", allDrivers);
        List<Car> allCars = carDao.findAll();
        model.addAttribute("allCars", allCars);
        if (routeId != null){
            route = routeDao.findById(routeId).get();
            route.setId(routeId);
            model.addAttribute(route);
        }
        return "newRouteForm";
    }

    @PostMapping("/addRoute")
    public String processNewRouteForm(@Valid Route route, BindingResult bindingResult, final Model model) throws IOException {
        if(bindingResult.hasErrors()){
            List<Driver> allDrivers = dao.findAll();
            model.addAttribute("allDrivers", allDrivers);
            List<Car> allCars = carDao.findAll();
            model.addAttribute("allCars", allCars);
            return "routeForm";
        }

        if (route.getId() != null) {
            Route routeFromDao = routeDao.findById(route.getId()).get();
            routeFromDao.setId(route.getId());
            routeFromDao.setRouteName(route.getRouteName());
            routeFromDao.setStartDateTime(route.getStartDateTime());
            routeFromDao.setStartAddress(route.getStartAddress());
            routeFromDao.setEndAddress(route.getEndAddress());

            tomTomApi.processRouteWithDataFromTomTom(route);

            routeFromDao.setDriverId(route.getDriverId());
            routeFromDao.setCarId(route.getCarId());

            Driver driver = dao.getOne(route.getDriverId());
            Car car = carDao.getOne(route.getCarId());

            driver.addRoute(routeFromDao);
            car.addRoute(routeFromDao);

            routeDao.save(routeFromDao);
            dao.save(driver);
            carDao.save(car);

        }else {

            Long driverId = route.getDriverId();
            Driver driver = dao.getOne(driverId);

            Long carId = route.getCarId();
            Car car = carDao.getOne(carId);

            driver.addRoute(route);
            car.addRoute(route);

            tomTomApi.processRouteWithDataFromTomTom(route);

            routeDao.save(route);
            dao.save(driver);
            carDao.save(car);
        }
        return "redirect:/";
    }


    @GetMapping(path ="/showDriverRoutes")
    public String showRoutes(final Model model, @RequestParam(name = "driverId") Long driverId){
        Driver driver = dao.getOne(driverId);
        List<Route> routes =driver.getRoutes();
        model.addAttribute("routeToDriver", routes);
        return "routeToDriver";
    }

    @GetMapping("/showAllRoutes")
    public String showAllRoutes(final Model model) {
        List<Route> allRoutes = routeDao.findAll();
        model.addAttribute("allRoutes", allRoutes);
        return "showAllRoutes";
    }

    @GetMapping("/deleteRoute")
    public String deleteRoute(@RequestParam Long routeId) {
        routeDao.deleteById(routeId);
        return "redirect:/showAllRoutes";
    }

    @GetMapping("/markAsDone")
    public String markAsDone(@RequestParam Long routeId){
        List<Driver> allDrivers = dao.findAll();
        List<Route> allRoutes;
        for (Driver driver : allDrivers){
            allRoutes = driver.getRoutes();
            for (Route route : allRoutes){
                if (route.getId() == routeId){
                    Long sum = Long.sum(driver.getDistanceTaken(), route.getDistance());
                    driver.setDistanceTaken(sum);
                    dao.save(driver);
                }
            }
        }
        return "redirect:/showAllRoutes";
    }



}
