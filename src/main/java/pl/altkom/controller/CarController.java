package pl.altkom.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.altkom.model.Car;
import pl.altkom.repository.CarRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarRepository carDao;

    @GetMapping("/addCar")
    public String showOptionsForm(Car car) {
        return "newCarForm";

    }

    @PostMapping("/addCar")
    public String addForm(@Valid Car car, BindingResult bindingResult) {
        carDao.addCar(car);
        System.out.printf("%s, %s, %s, %s %s%n", car.getBrand(), car.getModel(), car.getColour(), car.getYearOfProduction()
                , car.getVin());
        if (bindingResult.hasErrors()){
            return "newCarForm";
        }
        return "showNewCar";
    }

    @GetMapping(path = "/showAll")
    public String preapreAllCarView(final Model model) {
        List<Car> carList = carDao.showAll();
        model.addAttribute("cars", carList);
        return "showAllCars";
    }

    @GetMapping(path = "/deleteCar")
    public String deleteCar(@RequestParam(name = "carId") int carId) {
        System.out.printf("Usunięcie samochodu o ID = %d%n", carId);
        carDao.deleteCar(carId);
        return "showAllCars";
    }

    @GetMapping("/editCar")
    public String editOptionsForm(Car car,@RequestParam(name = "carId") int carId) {
        car.setId(carId);
        return "editCarForm";

    }

    @PostMapping("/editCar")
    public String editCar(@Valid Car car, BindingResult bindingResult){
        carDao.editCar(car);
        if (bindingResult.hasErrors()){
            return "editCarForm";
        }
        return "showNewCar";
    }




}