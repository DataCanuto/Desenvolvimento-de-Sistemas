package br.com.DataCanuto;

import java.time.LocalDate;

import br.com.DataCanuto.dto.UserDTO;
import br.com.DataCanuto.mapper.UserMapper;
import br.com.DataCanuto.model.UserModel;
import org.mapstruct.factory.Mappers;


// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public static void main(String[] args) {

        var dto = new UserDTO();
        dto.setId(1);
        dto.setName("Maria");
        dto.setBirthdate(LocalDate.of(1900, 1, 1));

        
        
        var model = new UserModel();
        model.setCode(dto.getId());
        model.setUserName(dto.getName());
        model.setBirthdate(dto.getBirthdate());

        System.out.println(model.toString());
        System.out.println(mapper.toDTO(model));


        
    }
}