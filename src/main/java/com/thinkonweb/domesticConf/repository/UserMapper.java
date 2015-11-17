package com.thinkonweb.domesticConf.repository;

import com.thinkonweb.domesticConf.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    @Insert("INSERT INTO USERS (NAME, EMAIL, PASSWORD, AGE) VALUES (#{name}, #{email}, #{password}, #{age})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    void insert(User user);

    @Update("UPDATE USERS SET NAME = #{name}, EMAIL = #{email}, PASSWORD = #{password}, AGE = #{age} WHERE ID = #{id}")
    void update(User user);

    @Select("SELECT * FROM USERS WHERE ID = #{id}")
    User findOne(@Param("id") int id);

    @Select("SELECT * FROM USERS WHERE EMAIL = #{email}")
    User findByEmail(@Param("email") String email);

    @Delete("DELETE FROM USERS WHERE ID = #{id}")
    void delete(@Param("id") int id);
}
