package pl.betleja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.betleja.model.CarReport;
import pl.betleja.repository.CarRepositoryDataJpaImpl;
import java.time.LocalDate;

@Service
public class CarReportFactory {

    @Autowired
    private CarRepositoryDataJpaImpl dao;

    public CarReport createReport(final  Integer reportType){
        CarReport result = null;

        switch (reportType){
            case 1:
                result = new CarReport("Pojazd określonej marki",
                        dao.getAllByBrand("Audi"));

            break;

            case 2:
                result = new CarReport("Samochody starsze niż 10 lat",
                        dao.getAllByYearOfProductionBefore(LocalDate.of(2010,1,1)));

                break;

            case 3:
                result = new CarReport("Pojazdy innej marki niż Volkswagen, Audi, Skoda, Seat",
                        dao.getAllByBrandIsNotAndBrandIsNotAndBrandIsNotAndBrandIsNot("Volkswagen", "Audi", "Skoda", "Seat"));

                break;

            case 4:
                result = new CarReport("Pojazdy marki Ferrari w kolorze czerwonym",
                        dao.getAllByBrandAndColor("Ferrari", "Czerwony"));

                break;

            case 5:
                result = new CarReport("Pojazdy marki Ford posortowane od najnowszego",
                        dao.getAllByBrandOrderByYearOfProductionDesc("Ford"));

                break;

            case 6:
                result = new CarReport("Pojazdy marki Peugeot w kolorze innym niż srebrny",
                        dao.getAllByBrandAndColorIsNot("Peugeot", "Srebrny"));

                break;


            default:{
                throw new UnsupportedOperationException("Nieznany rodzaj raportu!");
            }

        }
        return result;
    }

    public CarReport carReportByUser(String brand, String model, String colour){

        CarReport carReport = new CarReport("Pojazdy o określonej marce, modelu i kolorze - wybór przez formularz",
                dao.getAllByBrandAndModelAndColor(brand, model, colour));
        return carReport;
    }
}
