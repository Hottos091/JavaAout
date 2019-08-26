package dataAccessPackage;

import exceptionPackage.DataException;

import java.util.ArrayList;

public interface CookDBAccessDA {
    public ArrayList<String> getAllCooks();

    public String getCookName(Integer cookId);

    public Integer getCookId(String cook);
}
