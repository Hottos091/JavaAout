package modelPackage;

public class Supplier {
    private String phoneNumber;
    private String name;
    private String firstname;
    private String email;
    private Integer streetNumber;
    private City city;

    //GETTORS
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public City getCity() {
        return city;
    }

    //SETTORS
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
