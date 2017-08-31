package com.graphs.mappers;

import com.graphs.entities.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    @Select("SELECT * FROM `users` WHERE id = #{id}")
    UserEntity get(@Param("id") final Long id);

    @Insert("INSERT INTO `users` SET id = #{id}, email = #{email}, passwordhash = #{passwordhash}")
    Long create(final UserEntity entity);
}