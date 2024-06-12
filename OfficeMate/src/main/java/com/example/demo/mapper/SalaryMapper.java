package com.example.demo.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.SalaryDTO;

@Mapper
public interface SalaryMapper {

	@Insert("INSERT INTO Salary (userId, salaryDate, amount, paymentMethod, description) VALUES (#{userId}, #{salaryDate}, #{amount}, #{paymentMethod}, #{description})")
	void userSalaryPayment(SalaryDTO salaryDTO);

	@Select("Select * from Salary where userId = #{userId}")
	List<SalaryDTO> getSalaryUser(int userId);

	@Select("SELECT * FROM Salary WHERE EXTRACT(YEAR FROM salaryDate) = EXTRACT(YEAR FROM #{paymentMonth}) AND EXTRACT(MONTH FROM salaryDate) = EXTRACT(MONTH FROM #{paymentMonth})")
	List<SalaryDTO> getSalary(LocalDate paymentMonth);

	@Select("SELECT * FROM Salary WHERE salaryId = #{salaryId}")
	SalaryDTO getSalaryOne(int salaryId);

	@Select("Select userId from Salary where salarydate = #{paymentMonth}")
	List<Integer> getSalaryList(LocalDate paymentMonth);

	@Select("SELECT * FROM Salary WHERE userId = #{userId} AND salarydate = #{paymentMonth}")
	SalaryDTO getSalaryOne2(int userId, LocalDate paymentMonth);

	@Update("Update Salary SET bonus=#{bonus} where salaryId = #{salaryId}")
	boolean payBouns(int salaryId, int bonus);

}
