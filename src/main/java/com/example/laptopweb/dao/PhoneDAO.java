package com.example.laptopweb.dao;

import com.example.laptopweb.model.Phone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAO implements IPhoneDAO {
    public PhoneDAO() {
    }

    @Override
    public void insertPhone(Phone phone) throws SQLException {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.getConnection();

        String query = "insert into product (name,brand,color,price,urlImage) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connectJDBC.getConnection().prepareStatement(query);
        preparedStatement.setString(1, phone.getName());
        preparedStatement.setString(2, phone.getBrand());
        preparedStatement.setString(3, phone.getColor());
        preparedStatement.setDouble(4, phone.getPrice());
        preparedStatement.setString(5, phone.getUrlImage());
        preparedStatement.executeUpdate();
    }

    @Override
    public Phone selectPhone(int id) throws SQLException {
        Phone phone = null;
        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.getConnection();

        String query = "select id,name,brand,color,price,urlImage from product where id=?";
        PreparedStatement preparedStatement = connectJDBC.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String brand = resultSet.getString("brand");
            String color = resultSet.getString("color");
            double price = resultSet.getDouble("price");
            String urlImage = resultSet.getString("urlImage");
            phone = new Phone(id, name, brand, color, price, urlImage);
        }

        return phone;
    }

    @Override
    public List<Phone> selectAllPhone() throws SQLException {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.getConnection();

        String query = "select * from product";

        List<Phone> phoneList = new ArrayList<>();
        PreparedStatement preparedStatement = connectJDBC.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String brand = resultSet.getString("brand");
            String color = resultSet.getString("color");
            double price = resultSet.getDouble("price");
            String urlImage = resultSet.getString("urlImage");
            phoneList.add(new Phone(id, name, brand, color, price, urlImage));
        }

        return phoneList;
    }

    @Override
    public boolean deletePhone(int id) throws SQLException {
        boolean rowDelete;

        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.getConnection();

        String query = "delete from product where id = ?";
        PreparedStatement preparedStatement = connectJDBC.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);
        rowDelete = preparedStatement.executeUpdate() > 0 ;

        return rowDelete;
    }

    @Override
    public boolean updatePhone(Phone phone) {
        return false;
    }

    @Override
    public List<Phone> searchByName(String keyword) throws SQLException {
        List<Phone> phoneList = new ArrayList<>();
        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.getConnection();

        String query = "select * from product where name like ?";
        PreparedStatement preparedStatement = connectJDBC.getConnection().prepareStatement(query);
        preparedStatement.setString(1,'%' + keyword + '%');
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String brand = resultSet.getString("brand");
            String color = resultSet.getString("color");
            double price = resultSet.getDouble("price");
            String urlImage = resultSet.getString("urlImage");
            phoneList.add(new Phone(id,name,brand,color,price,urlImage));
        }
        return phoneList;
    }
}
