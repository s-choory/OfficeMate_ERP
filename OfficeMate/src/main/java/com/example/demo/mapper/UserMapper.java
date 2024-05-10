package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.UserDTO;
	
@Mapper
public interface UserMapper {
    
    @Select("SELECT * FROM users WHERE userId = #{userId}")
    UserDTO getUserById(@Param("userId") int userId);
    
    @Select("SELECT * FROM users WHERE username = #{username}")
    UserDTO findByUsername(@Param("username") String username);
    
    @Insert("INSERT INTO Users (username, email, password, departmentId, role) VALUES \n (#{username}, 'example@example.com', #{password}, 0, 'ROLE_ADMIN')")
    void JoinMember(@Param("username") String username, @Param("password") String password);

} 
