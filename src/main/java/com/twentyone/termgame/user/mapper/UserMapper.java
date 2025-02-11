package com.twentyone.termgame.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.twentyone.termgame.user.dto.UserCreateDto;
import com.twentyone.termgame.user.model.entity.UserEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserMapper {

  @Mapping(source = "username", target = "username")
  @Mapping(source = "password", target = "password")
  @Mapping(source = "firstName", target = "firstName")
  @Mapping(source = "lastName", target = "lastName")
  @Mapping(source = "phoneNumber", target = "phoneNumber")
  @Mapping(source = "point", target = "point")
  UserEntity toUserEntity(UserCreateDto userCreateDto);


  @Mapping(source = "username", target = "username")
  @Mapping(source = "firstName", target = "firstName")
  @Mapping(source = "lastName", target = "lastName")
  @Mapping(source = "phoneNumber", target = "phoneNumber")
  @Mapping(source = "point", target = "point")
  UserEntity prepareUserEntity(UserEntity userEntity);

}
