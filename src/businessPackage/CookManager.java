package businessPackage;

import dataAccessPackage.CookDBAccess;
import modelPackage.Cook;

import java.util.ArrayList;

public class CookManager {
    private CookDBAccess cookDBAccess;

    public CookManager(){
    this.cookDBAccess = new CookDBAccess();
    }

    public ArrayList<String> getAllCooks(){
        return cookDBAccess.getAllCooks();
    }

    public Integer getCookId(String firstname, String lastname){ return cookDBAccess.getCookId(firstname, lastname); }
}


