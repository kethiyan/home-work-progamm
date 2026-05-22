package fibernet.model;


public class AttendanceModel {

    private int id;
    private int employeeId;
    private String employeeName;
    private String department;
    private String empCode;
    private String status;
    private String note;
    private String timeIn;
    private String date;

    public AttendanceModel() {}

    
    public AttendanceModel(int employeeId, String employeeName,
                            String department, String empCode,
                            String status, String note, String timeIn) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.empCode = empCode;
        this.status = status;
        this.note = note;
        this.timeIn = timeIn;
    }

   
    public int getId() { return id; }
    public int getEmployeeId() { return employeeId; }
    public String getEmployeeName() { return employeeName; }
    public String getDepartment() { return department; }
    public String getEmpCode() { return empCode; }
    public String getStatus() { return status; }
    public String getNote() { return note; }
    public String getTimeIn() { return timeIn; }
    public String getDate() { return date; }

    
    public void setId(int id) { this.id = id; }
    public void setEmployeeId(int i) { this.employeeId = i; }
    public void setEmployeeName(String n) { this.employeeName = n; }
    public void setDepartment(String d) { this.department = d; }
    public void setEmpCode(String e) { this.empCode = e; }
    public void setStatus(String s) { this.status = s; }
    public void setNote(String n) { this.note = n; }
    public void setTimeIn(String t) { this.timeIn = t; }
    public void setDate(String d) { this.date = d; }
}
