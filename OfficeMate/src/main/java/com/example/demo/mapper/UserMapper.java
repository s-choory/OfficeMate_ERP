package com.example.demo.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.UserDTO;
	
@Mapper
public interface UserMapper {
    
    @Select("SELECT * FROM users WHERE userId = #{userId}")
    UserDTO getUserById(@Param("userId") int userId);
    
    @Select("SELECT * FROM users WHERE username = #{username}")
    UserDTO findByUsername(@Param("username") String username);
    
    @Insert("INSERT INTO Users (username, email, password, departmentId, role) VALUES \n (#{username}, 'example@example.com', #{password}, 0, 'ROLE_USER')")
    int JoinMember(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM users WHERE departmentId = #{departmentId} order by case when userRank = '사장' then 1 when userRank = '팀장' then 2 when userRank = '사원' then 3 ELSE 4 END" )
	List<UserDTO> getDeptUser(int departmentId);

    @Select("SELECT * FROM users WHERE username LIKE CONCAT('%', #{username}, '%')")
    List<UserDTO> findByUsernameIncluded(String userName);

    @Select("SELECT * FROM users order by case when userRank = '사장' then 1 when userRank = '팀장' then 2 when userRank = '사원' then 3 ELSE 4 END")
	List<UserDTO> getUserAll();

    @Update("Update Users SET departmentId=#{departmentId}, userRank=#{userRank}, email=#{email}, monthSalary=#{monthSalary} where userId = #{userId}")
	int updateUserDetail(UserDTO userDTO);

    @Delete("Delete from Users where userId=#{userId}")
	int deleteUser(int userId);

    @Select("SELECT SUM(monthSalary) AS TotalAmount FROM users;")
	BigDecimal getUserTotalAmount();

} 
