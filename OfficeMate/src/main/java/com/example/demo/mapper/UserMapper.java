package com.example.demo.mapper;

import java.util.List;

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
    
    @Insert("INSERT INTO Users (username, email, password, departmentId, role) VALUES \n (#{username}, 'example@example.com', #{password}, 0, 'ROLE_USER')")
    int JoinMember(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM users WHERE departmentId = #{departmentId}")
	List<UserDTO> getDeptUser(int departmentId);

    @Select("SELECT * FROM users WHERE username LIKE CONCAT('%', #{username}, '%')")
    List<UserDTO> findByUsernameIncluded(String userName);

    @Select("SELECT * FROM users order by userID")
	List<UserDTO> getUserAll();

} 
