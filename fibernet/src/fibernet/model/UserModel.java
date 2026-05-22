package fibernet.model;

// Banking Pattern: BankingModel → UserModel
public class UserModel {

    private int id;
    private String fullName;
    private String email;
    private String mobile;
    private String password;
    private String role;

    // Default Constructor (Banking pattern போல்)
    public UserModel() {}

    // Parameterized Constructor
    public UserModel(String fullName, String email,
                     String mobile, String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.role = role;
    }

    // Getters
    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
}
