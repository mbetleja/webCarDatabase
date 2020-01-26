package pl.altkom.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.altkom.model.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarRepositoryJdbcImpl implements CarRepository {

    @Autowired
    private JdbcTemplate jdbc;
    public static String tableName = "carDatabase";

    @Override
    public void addCar(Car car) {
        jdbc.update("INSERT INTO carDatabase (brand, model, colour, dateOfProduction, vin) VALUES (?,?,?,?,?)",
                car.getBrand(), car.getModel(), car.getColour(), car.getDateOfProduction(), car.getVin());

    }
    @Override
    public List<Car> showAll(){
        final String SHOW_ALL_CARS = String.format("SELECT * from %s",tableName);
        return jdbc.query(SHOW_ALL_CARS, new RowMapper<Car>() {
            @Override
            public Car mapRow(ResultSet resultSet, int i) throws SQLException {
                Car car = new Car();
                car.setId(resultSet.getInt(1));
                car.setBrand(resultSet.getString(2));
                car.setModel(resultSet.getString(3));
                car.setColour(resultSet.getString(4));
                car.setDateOfProduction(resultSet.getString(5));
                car.setVin(resultSet.getString(6));
                return car;
            }
        });
    }

    @Override
    public void deleteCar(int id) {
        final String DELETE_CAR =String.format("DELETE FROM carDatabase WHERE id=%d", id);
        jdbc.update(DELETE_CAR);

    }



    @Override
    public void editCar(Car newCar) {
        final String EDIT_CAR = String.format("UPDATE %s SET "+
                "brand = '%s' ," +
                "model = '%s' ," +
                "colour = '%s' ," +
                "dateOfProduction = '%s' ," +
                "vin = '%s' "+
                "WHERE id = %s",
                tableName,
                newCar.getBrand(),
                newCar.getModel(),
                newCar.getColour(),
                newCar.getDateOfProduction(),
                newCar.getVin(),
                newCar.getId());
        jdbc.update(EDIT_CAR);
    }


}
