package br.com.DataCanuto.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String name;
    private LocalDate birthdate;

    
    public UserDTO(int id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public UserDTO() {
    }

}
