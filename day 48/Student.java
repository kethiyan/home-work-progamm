package builderpattern;

public class Student {

    private final int id;
    private final String name;
    private final String email;
    private final String phone;
    private final String address;

    private Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {

        private final int id;
        private final String name;

        private String email;
        private String phone;
        private String address;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nName: " + name +
                "\nEmail: " + email +
                "\nPhone: " + phone +
                "\nAddress: " + address;
    }
}