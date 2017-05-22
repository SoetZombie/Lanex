package ControlLayer;

import DBLayer.DBContractor;
import ModelLayer.Contractor;
import ModelLayer.Person;
import ValidatorLayer.Validator;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Admin on 4/28/2017.
 */
public class ContractorController extends Controller{
    private DBContractor dbContractor;
    ArrayList<String> errors = new ArrayList<>();
    private String validateName, validateAddress, validateEmail, validatePhone, validateCity;
    private int validateCVR;

    public ContractorController() {
        dbContractor = new DBContractor();
    }

    public ArrayList<String> getErrors(){
        return errors;
    }

    public void removeErrorMessages() {
        this.errors.clear();
    }

    public boolean create(String firstLastName, String address, String email, String phone, String city, int cvr) {
        ///TODO Try catch statement need to refactor because it has duplicated too often !!
        try {
            this.validateName = Validator.validateName(firstLastName);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        try {
            this.validateAddress = Validator.validateAddress(address);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        try {
            this.validateEmail = Validator.validateEmail(email);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        try {
            this.validatePhone = Validator.validatePhone(phone);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        try {
            this.validateCity = Validator.validateCity(city);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        try {
            this.validateCVR = Validator.validateCVR(cvr);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }

        if(errors.size() == 0) {
            try{
                dbContractor.create(validateName, validateAddress, validateEmail, validatePhone, validateCity, validateCVR);
                return true;
            } catch(SQLException e) {
                return false;
            }
        }
        else {
            throw new IllegalArgumentException(String.join("\n", errors));
        }

    }

    public String read(int cvr) {
        try {
           return dbContractor.read(cvr).toString();
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean update(Contractor contractor, int cvr) {
        try {
            dbContractor.update(contractor, cvr);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean delete(int cvr) {
        try {
            dbContractor.delete(cvr);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public ArrayList<Person> readAll() {
        try {
            return dbContractor.readAll();
        } catch (SQLException e) {
            return null;
        }
    }
}
