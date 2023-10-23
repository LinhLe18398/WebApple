package com.example.laptopweb.dao;

import com.example.laptopweb.model.Phone;

import java.sql.SQLException;
import java.util.List;

public interface IPhoneDAO {
    void insertPhone(Phone phone) throws SQLException;
    Phone selectPhone(int id) throws SQLException;
    List<Phone> selectAllPhone() throws SQLException;
    boolean deletePhone(int id) throws SQLException;
    boolean updatePhone(Phone phone) throws SQLException;
    List<Phone> searchByName(String keyword) throws SQLException;
}
