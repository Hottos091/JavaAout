package exceptionPackage;

public class CloseConnectionException extends Exception{
    public CloseConnectionException(){}

    public String getMessage(){return "Erreur lors de la fermeture de la connexion.\n";}
}
