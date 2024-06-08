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
    
    @Insert("INSERT INTO Users (username, email, password, departmentId, userPosition, role) VALUES \n (#{username}, 'example@example.com', #{password}, 0, '없음','ROLE_USER')")
    int JoinMember(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM users WHERE departmentId = #{departmentId}"
    		+ "ORDER BY \n"
    		+ "    CASE \n"
    		+ "        WHEN userRank = '사장' THEN 1"
    		+ "        WHEN userRank = '부사장' THEN 2"
    		+ "        WHEN userRank = '상무' THEN 3"
    		+ "        WHEN userRank = '부장' THEN 4"
    		+ "        WHEN userRank = '차장' THEN 5"
    		+ "        WHEN userRank = '과장' THEN 6"
    		+ "        WHEN userRank = '대리' THEN 7"
    		+ "        ELSE 8 END, userId")
	List<UserDTO> getDeptUser(int departmentId);

    @Select("SELECT * FROM users WHERE username LIKE CONCAT('%', #{username}, '%')")
    List<UserDTO> findByUsernameIncluded(String userName);

    @Select("SELECT * FROM users\n"
    		+ "ORDER BY \n"
    		+ "    CASE \n"
    		+ "        WHEN userRank = '사장' THEN 1"
    		+ "        WHEN userRank = '부사장' THEN 2"
    		+ "        WHEN userRank = '상무' THEN 3"
    		+ "        WHEN userRank = '부장' THEN 4"
    		+ "        WHEN userRank = '차장' THEN 5"
    		+ "        WHEN userRank = '과장' THEN 6"
    		+ "        WHEN userRank = '대리' THEN 7"
    		+ "        ELSE 8"
    		+ "    END,"
    		+ "    userId")
	List<UserDTO> getUserAll();

    @Update("Update Users SET departmentId=#{departmentId}, userRank=#{userRank}, userPosition=#{userPosition}, email=#{email}, monthSalary=#{monthSalary}, gender=#{gender}, phone=#{phone}, hiredate=#{hiredate}, birth=#{birth} where userId = #{userId}")
	int updateUserDetail(UserDTO userDTO);

    @Delete("Delete from Users where userId=#{userId}")
	int deleteUser(int userId);

    @Select("SELECT SUM(monthSalary) AS TotalAmount FROM users;")
	BigDecimal getUserTotalAmount();

    @Update("Update Users set userImg=#{fileBytes} where userId=#{userId}")
	void updateUserImg(int userId, byte[] fileBytes);


} 
