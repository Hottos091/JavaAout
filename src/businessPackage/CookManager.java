package businessPackage;

import dataAccessPackage.CookDBAccess;
import dataAccessPackage.CookDBAccessDA;
import exceptionPackage.CookException;
import exceptionPackage.DataException;
import modelPackage.Cook;

import java.util.ArrayList;

public class CookManager {
    private CookDBAccessDA cookDBAccessDA;

    public CookManager(){
    this.cookDBAccessDA = new CookDBAccess();
    }

    public ArrayList<String> getAllCooks(){
        return cookDBAccessDA.getAllCooks();
    }
    public String getCookName(Integer cookId){
        return cookDBAccessDA.getCookName(cookId);
    }

    public Integer getCookId(String firstname, String lastname){ return cookDBAccessDA.getCookId(firstname, lastname); }
}


