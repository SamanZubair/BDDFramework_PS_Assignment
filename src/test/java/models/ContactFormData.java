package models;

public class ContactFormData {
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String jobTitle;
    private String message;
    private String country;

    // Getters & Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}
