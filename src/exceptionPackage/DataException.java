package exceptionPackage;

public class DataException extends Exception{
    private String bug;

    public DataException(String bug){
        this.bug = bug;
    }

    public String getMessage(){
        return "Erreur : " + bug;
    }
}
