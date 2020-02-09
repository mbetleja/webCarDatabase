package pl.altkom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.altkom.model.Driver;
import pl.altkom.repository.DriverRepositoryDataJpaImpl;

import java.util.List;

@Controller
public class DriverController {

    @Autowired
    private DriverRepositoryDataJpaImpl dao;

    @GetMapping("/addDriver")
    public String addNewDriverForm(Driver driver){
        return "newDriverForm";
    }

    @PostMapping("/addDriver")
    public String addDriver(Driver driver, BindingResult bindingResult){
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
        model.addAttribute("driverList", driverList);
        return "ShowAllDrivers";
    }

}
