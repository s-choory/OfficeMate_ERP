package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.JoinDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;

@Service
public class JoinService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void joinProcess(JoinDTO joinDTO) {	
		//db에 동일한 username인 회원이 존재하는지 검증
		//!!!프론트에도 중복된 알림처리 해야함 -> 아직 안함
		UserDTO isUser = userMapper.findByUsername(joinDTO.getUsername());
		if(isUser != null) { 
			return;
		}
		
		userMapper.JoinMember(joinDTO.getUsername(), bCryptPasswordEncoder.encode(joinDTO.getPassword()));
	
	}
}
