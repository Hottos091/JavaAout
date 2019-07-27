package modelPackage;

public class City {
    private Integer zipCode;
    private String cityName;

    //GETTORS
    public Integer getZipCode() {
        return zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    //SETTORS
    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
