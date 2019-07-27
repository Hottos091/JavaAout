package modelPackage;

public class Cook {
    private Integer idNumber;
    private String name;
    private String firstname;
    private Integer chiefIdNumber;



    //GETTORS
    public Integer getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public Integer getChiefIdNumber() {
        if(chiefIdNumber!=null) {
            return chiefIdNumber;
        } else { //dans ce cas on retourne simplement l'id du cuisinier ==> il est chef. On renvoie son propre id //TODO Pas très clean
            return idNumber;
        }
    }
    //SETTORS
    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setChiefIdNumber(Integer chiefIdNumber) {
        this.chiefIdNumber = chiefIdNumber;
    }
}
