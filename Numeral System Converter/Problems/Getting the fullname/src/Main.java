class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName != null ? firstName : "";
    }

    public void setLastName(String lastName) {
        this.lastName = lastName != null ? lastName : "";
    }

    public String getFullName() {
        if (this.firstName.length() > 0) {
            if (this.lastName.length() > 0) {
                return this.firstName + " " + this.lastName;
            } else {
                return this.firstName;
            }
        } else {
            if (this.lastName.length() > 0) {
                return this.lastName;
            } else {
                return "Unknown";
            }
        }
    }
}