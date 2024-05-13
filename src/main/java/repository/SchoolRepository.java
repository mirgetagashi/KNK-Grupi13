package repository;

import model.Address;
import model.Major;
import model.Period;
import model.School;
import service.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SchoolRepository {

   public static ArrayList<String> getSchoolByCity(String city) {
       ArrayList<String> schools = new ArrayList<>();

       String query = "SELECT s.school_name FROM School s " +
               "INNER JOIN address_school cs ON cs.school_id = s.school_id " +
               "INNER JOIN Address a ON a.address_id = cs.address_id " +
               "WHERE a.city = ?";
       Connection conn = DBConnector.getConnection();
       try{
           PreparedStatement pst = conn.prepareStatement(query);
           pst.setString(1, city);
           ResultSet rs = pst.executeQuery();
           while (rs.next()) {
               String school_name = rs.getString("school_name");
               schools.add(school_name);
           }
       } catch (SQLException e) {
           System.out.println("Diçka ka shkuar gabim: " + e.getMessage());
       }
       return schools;
   }

    public static ArrayList<School> getAllSchools(){
        ArrayList<School> schools = new ArrayList<>();
        String query = "SELECT * FROM School;";
        Connection connection = DBConnector.getConnection();
        try{
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            while (result.next()){
                School school= getFromResultSet(result);
                schools.add(school);
            }
        }catch (Exception e){
            return null;
        }
        return schools;
    }



    public static School getSchoolByName(String school){
        String query = "SELECT * FROM SCHOOL WHERE school_name = ? LIMIT 1;";
        Connection connection = DBConnector.getConnection();
        try{
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, school);
            ResultSet result = pst.executeQuery();
            if(result.next()){
                return getFromResultSet(result);
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }
    public static School getById(int school_id){
        String query = "SELECT * FROM School WHERE school_id = ? LIMIT 1;";
        Connection connection = DBConnector.getConnection();
        try{
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, school_id);
            ResultSet result = pst.executeQuery();
            if(result.next()){
                return getFromResultSet(result);
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }

    private static School getFromResultSet(ResultSet result){
        try{
            int id = result.getInt("school_id");
            String name = result.getString("school_name");
            return new School(
                    id, name
            );
        }catch (Exception e){
            return null;
        }
    }



}