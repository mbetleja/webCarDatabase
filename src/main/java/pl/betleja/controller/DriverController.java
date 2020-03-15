package pl.betleja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.betleja.model.Driver;
import pl.betleja.model.Route;
import pl.betleja.repository.DriverRepositoryDataJpaImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DriverController {

    @Autowired
    private DriverRepositoryDataJpaImpl dao;

    @GetMapping("/submitDriverForm")
    public String submitRouteForm(@RequestParam(name = "driverId", required = false) Long driverId, final Model model, Driver driver){
        if (driverId != null){
            driver = dao.getOne(driverId);
            model.addAttribute(driver);
        }
        return "newDriverForm";
    }

    @PostMapping("/addDriver")
    public String addDriver(@Valid Driver driver, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "newDriverForm";
        }
        dao.save(driver);
        System.out.printf("%s,%s%n", driver.getFirstName(), driver.getLastName());
        return "showNewDriver";
    }

    @GetMapping("showAllDrivers")
    public String prepareAllDriversView(final Model model){
        List<Driver> driverList = dao.findAll();
        model.addAttribute("driversList", driverList);
        return "ShowAllDrivers";
    }
    @GetMapping("/showDriverAssignedRoutes")
    public String showAssignedRoutes(final Model model, @RequestParam(name = "driverId") Long driverId) {
        Driver driver = dao.getOne(driverId);
        List<Route> routes = driver.getRoutes();
        model.addAttribute("allRoutes", routes);
        return "routeToDriver";
    }

    @GetMapping("/deleteDriver")
    public String deleteDriver(@RequestParam(name = "driverId") Long driverId){
        dao.deleteById(driverId);
        return "redirect:showAllDrivers";
    }

}
