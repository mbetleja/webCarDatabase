package pl.betleja.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.betleja.model.Car;
import pl.betleja.model.Color;
import pl.betleja.model.Route;
import pl.betleja.repository.CarRepositoryDataJpaImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarRepositoryDataJpaImpl carDao;

    @GetMapping("/submitNewCarForm")
    public String showOptionsForm(@RequestParam(name = "carId", required = false) Long carId, final Model model, Car car) {
        if(carId != null){
            car = carDao.getOne(carId);
            model.addAttribute(car);
        }
        model.addAttribute("colors", Color.values());
        return "newCarForm";

    }

    @PostMapping("/addCar")
    public String addForm(@Valid Car car, BindingResult bindingResult, final Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("colors", Color.values());
            return "newCarForm";
        }
        carDao.save(car);
        System.out.printf("%s, %s, %s, %s %s%n", car.getBrand(), car.getModel(), car.getColor(), car.getYearOfProduction()
                , car.getVin());
        return "showNewCar";
    }

    @GetMapping(path = "/showAll")
    public String preapreAllCarView(final Model model) {
        List<Car> carList = carDao.findAll();
        model.addAttribute("cars", carList);
        return "showAllCars";
    }

    @GetMapping(path = "/deleteCar")
    public String deleteCar(@RequestParam(name = "carId") Long carId) {
        System.out.printf("Usunięcie samochodu o ID = %d%n", carId);
        carDao.deleteById(carId);
        return "redirect:/showAll";
    }

    @GetMapping("/editCar")
    public String editOptionsForm(Car car,@RequestParam(name = "carId") Long carId) {
        car.setId(carId);
        return "editCarForm";

    }

    @PostMapping("/editCar")
    public String editCar(@Valid Car car, BindingResult bindingResult){
        carDao.save(car);
        if (bindingResult.hasErrors()){
            return "editCarForm";
        }
        return "showNewCar";
    }
    @GetMapping("/showCarAssignedRoutes")
    public String showAssignedRoutes(@RequestParam(name = "carId") Long carId, final Model model){
        Car car = carDao.getOne(carId);
        List<Route> routes = car.getRoutes();
        model.addAttribute("routes", routes);
        return "routeToCar";
    }




}