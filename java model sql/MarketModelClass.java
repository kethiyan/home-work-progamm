
package supermarket;


public class MarketModelClass 
{
    private int cusId;
    private String cusName;
    private String city;
    private String grade;
    private int salesmanId;

    public MarketModelClass() {
    }

    public MarketModelClass(int cusId, String cusName, String city, String grade, int salesmanId) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.city = city;
        this.grade = grade;
        this.salesmanId = salesmanId;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }
    
    

}
