package it.casaleo.auth.dto;

import it.casaleo.auth.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto (User user);
    User toEntity (UserDto dto);
}
