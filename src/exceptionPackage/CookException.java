package exceptionPackage;

public class CookException extends Exception{
    private String bug;

    public CookException(String bug){
        this.bug = bug;
    }
    public String getMessage(){
        return "Erreur : " + bug;
    }
}
