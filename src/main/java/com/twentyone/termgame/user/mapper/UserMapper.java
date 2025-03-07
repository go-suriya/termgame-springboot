package com.twentyone.termgame.user.mapper;

import com.twentyone.termgame.user.dto.request.UserCreateRequestDto;
import com.twentyone.termgame.user.dto.response.UserCreateResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.twentyone.termgame.user.model.entity.UserEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserMapper {

  @Mapping(source = "username", target = "username")
  @Mapping(source = "password", target = "password")
  @Mapping(source = "firstName", target = "firstName")
  @Mapping(source = "lastName", target = "lastName")
  @Mapping(source = "phoneNumber", target = "phoneNumber")
  @Mapping(source = "point", target = "point")
  UserEntity toUserEntity(UserCreateRequestDto userCreateRequestDto);

  // ใช้ @Mapping เพื่อระบุการแมปฟิลด์จาก UserEntity ไปเป็น UserCreateResponseDto
  @Mapping(source = "username", target = "username")
  @Mapping(source = "firstName", target = "firstName")
  @Mapping(source = "lastName", target = "lastName")
  @Mapping(source = "phoneNumber", target = "phoneNumber")
  @Mapping(source = "point", target = "point")
  UserCreateResponseDto userEntityToUserCreateResponseDto(UserEntity userEntity);

}
