package fibernet.model;

import java.sql.Timestamp;


public class RequestModel {

    private int id;
    private String requestId;
    private String customerName;
    private String companyName;
    private String email;
    private String phone;
    private String plan;
    private String status;
    private String priority;
    private String address;
    private String notes;
    private Timestamp submittedAt;

   
    public RequestModel() {}

    public RequestModel(String customerName, String companyName,
                        String email, String phone, String plan,
                        String priority, String address, String notes) {
        this.customerName = customerName;
        this.companyName = companyName;
        this.email = email;
        this.phone = phone;
        this.plan = plan;
        this.priority = priority;
        this.address = address;
        this.notes = notes;
    }

   
    public int getId() { return id; }
    public String getRequestId() { return requestId; }
    public String getCustomerName() { return customerName; }
    public String getCompanyName() { return companyName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPlan() { return plan; }
    public String getStatus() { return status; }
    public String getPriority() { return priority; }
    public String getAddress() { return address; }
    public String getNotes() { return notes; }
    public Timestamp getSubmittedAt() { return submittedAt; }

    
    public void setId(int id) { this.id = id; }
    public void setRequestId(String r) { this.requestId = r; }
    public void setCustomerName(String n) { this.customerName = n; }
    public void setCompanyName(String c) { this.companyName = c; }
    public void setEmail(String e) { this.email = e; }
    public void setPhone(String p) { this.phone = p; }
    public void setPlan(String p) { this.plan = p; }
    public void setStatus(String s) { this.status = s; }
    public void setPriority(String p) { this.priority = p; }
    public void setAddress(String a) { this.address = a; }
    public void setNotes(String n) { this.notes = n; }
    public void setSubmittedAt(Timestamp t) { this.submittedAt = t; }
}
