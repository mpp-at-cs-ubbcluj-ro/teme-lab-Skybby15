package main;

import main.JdbcUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.*;

public class CarsDBRepository implements CarRepository{

    private JdbcUtils dbUtils;

    private static final Logger logger= LogManager.getLogger();

    public CarsDBRepository(Properties props) {
        logger.info("Initializing CarsDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }

    @Override
    public List<Car> findByManufacturer(String manufacturerN) {
        logger.traceEntry();
        Connection conn = dbUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try(PreparedStatement preStmt = conn.prepareStatement("select * from masini where manufacturer=?")){
            preStmt.setString(1, manufacturerN);
            try(ResultSet result = preStmt.executeQuery()){
                while (result.next()){
                    int id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    cars.add(car);
                }
            }
        }catch(SQLException e){
            logger.error(e);
            System.err.println("Error db" + e);
        }
        logger.traceExit();
        return cars;
    }

    @Override
    public List<Car> findBetweenYears(int min, int max) {
	//to do
        return null;
    }

    @Override
    public void add(Car elem){
        logger.traceEntry("saving task {}",elem);
        Connection conn = dbUtils.getConnection();
        try(PreparedStatement preStmt = conn.prepareStatement("insert into masini (manufacturer, model, year) values (?,?,?)")){
            preStmt.setString(1, elem.getManufacturer());
            preStmt.setString(2, elem.getModel());
            preStmt.setInt(3, elem.getYear());
            int result = preStmt.executeUpdate();
            logger.trace("Saved {} instances",result);
        }catch(SQLException e){
            logger.error(e);
            System.err.println("Error db" + e);
        }
        logger.traceExit();
    }

    @Override
    public void update(Integer integer, Car elem) {
      //to do
    }

    @Override
    public Iterable<Car> findAll() {
         logger.traceEntry();
         Connection conn = dbUtils.getConnection();
         List<Car> cars = new ArrayList<>();
         try(PreparedStatement preStmt = conn.prepareStatement("select * from masini")){
             try(ResultSet result = preStmt.executeQuery()){
                 while (result.next()){
                     int id = result.getInt("id");
                     String manufacturer = result.getString("manufacturer");
                     String model = result.getString("model");
                     int year = result.getInt("year");
                     Car car = new Car(manufacturer, model, year);
                     car.setId(id);
                     cars.add(car);
                 }
             }
         }catch(SQLException e){
             logger.error(e);
             System.err.println("Error db" + e);
         }
         logger.traceExit();
         return cars;

    }
}
