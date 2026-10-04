package br.com.DataCanuto.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class UserModel {

    private int code;
    private String userName;
    private LocalDate birthdate;

}
