package pl.altkom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.altkom.model.CarReport;
import pl.altkom.service.CarReportFactory;



@Controller
public class CarReportController {

    @Autowired
    private CarReportFactory reportFactory;


    @GetMapping(path = "/carReport")
    public String processReportRequest(final Model model, @RequestParam(name = "reportId") Integer reportId){

        CarReport report = reportFactory.createReport(reportId);
        model.addAttribute("reportData", report);

        return "report";
    }

    @GetMapping(path = "/search")
    public String searchingForm(){
        return "userInputForm";
    }

    @GetMapping(path = "/userParams")
    public String userInputParams(final Model model, @RequestParam(name = "brand") String brand,
                                  @RequestParam(name = "model") String carModel,
                                  @RequestParam(name = "colour") String colour){

        CarReport report = reportFactory.carReportByUser(brand, carModel, colour);
        model.addAttribute("reportData", report);

        return "report";


    }





}
