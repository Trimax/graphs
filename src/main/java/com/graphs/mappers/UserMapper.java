package com.graphs.mappers;

import com.graphs.entities.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    @Select("SELECT * FROM `users` WHERE id = #{id}")
    UserEntity findByID(@Param("id") Long id);

}