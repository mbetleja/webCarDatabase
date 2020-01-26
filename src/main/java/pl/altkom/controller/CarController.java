package pl.altkom.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.altkom.model.Car;
import pl.altkom.repository.CarRepositoryDataJpaImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarRepositoryDataJpaImpl carDao;

    @GetMapping("/addCar")
    public String showOptionsForm(Car car) {
        return "newCarForm";

    }

    @PostMapping("/addCar")
    public String addForm(@Valid Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "newCarForm";
        }
        carDao.save(car);
        System.out.printf("%s, %s, %s, %s %s%n", car.getBrand(), car.getModel(), car.getColour(), car.getYearOfProduction()
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




}