package models.api;

import lombok.Getter;
import lombok.Setter;

public class UserData{
    // Getters and Setters
    @Setter
    @Getter
    private String name;
    @Getter
    @Setter
    private String gender;
    @Setter
    @Getter
    private String email;
    @Setter
    @Getter
    private String status;
    @Getter
    @Setter
    private Integer id;


}
