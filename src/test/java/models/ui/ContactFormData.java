package models.ui;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContactFormData {
    // Getters & Setters
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String jobTitle;
    private String message;
    private String country;

}
