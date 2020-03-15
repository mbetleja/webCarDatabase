package pl.betleja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.betleja.model.Driver;
import pl.betleja.repository.DriverRepositoryDataJpaImpl;

import java.util.List;

@RestController
public class DriveRestController {

    @Autowired
    private DriverRepositoryDataJpaImpl driverDao;

//    how to get responses in POSTMAN

//    Show all drivers
//    METHOD GET
//    Postman URL: http://localhost:8080/drivers


    @GetMapping(path = "/drivers")
    public List<Driver> allDrivers(){

        return driverDao.findAll();
    }

//    Show driver's by first name
//    METHOD GET
//    Postman URL: http://localhost:8080/driver/firstName/(here put firstName)

    @GetMapping(path = "/driver/firstName/{firstName}")
    public Driver searchDriverByFirstName(@PathVariable("firstName") String firstName){

        return driverDao.findDriverByFirstName(firstName);
    }

//    Show driver's by first name
//    METHOD GET
//    Postman URL: http://localhost:8080/driver/lastName/(here put lastName)

    @GetMapping(path = "/driver/lastName/{lastName}")
    public Driver searchDriverByLastName(@PathVariable("lastName") String lastName) {

        return driverDao.findDriverByLastName(lastName);
    }

//    Show driver by id
//    METHOD GET
//    Postman URL: http://localhost:8080/drivers/(here put id)

    @GetMapping(path = "/drivers/{id}")
    public Driver oneDriver(@PathVariable("id") Long id){

        return driverDao.getOne(id);
    }

//    Delete driver by id
//    METHOD DELETE
//    Postman URL: http://localhost:8080/drivers/(here put id)

    @DeleteMapping(path = "/drivers/{id}")
    public String removeDriver(@PathVariable("id") Long id){
        driverDao.deleteById(id);

        return "Driver with id = " + id + " was deleted";
    }

//    Create new driver
//    METHOD POST
//    Postman URL: http://localhost:8080/drivers
//    go to Body section
//    choose raw - JSON format
//    and put in window:
//    {
//    "firstName": "choosenFirstName",
//    "lastName": "choosenLastName",
//    "distanceTaken": null,
//    "routes": []
//    }

    @PostMapping("/drivers")
    public Driver addDriver(@RequestBody Driver driver)
    {
        driverDao.save(driver);

        return driver;
    }

//    Update driver
//    METHOD PUT
//    Postman URL: http://localhost:8080/drivers
//    go to Body section
//    choose raw - JSON format
//    and put in window:
//    {
//    "id":(id kierowcy którego chcemy zmienić)
//    "firstName": "choosenFirstName",
//    "lastName": "choosenLastName",
//    "distanceTaken": null,
//    "routes": []
//    }

    @PutMapping("/drivers")
    public Driver updateDriver(@RequestBody Driver driver)
    {
        driverDao.save(driver);

        return driver;
    }
}
