//package com.example.demo.dto;
//import java.util.ArrayList;
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class CustomUserDetails implements UserDetails {
//
//	@Autowired
//    private final UserDTO userDTO;
//
//    public CustomUserDetails(UserDTO userDTO) {
//        this.userDTO = userDTO;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // 사용자의 권한을 설정합니다. 여기서는 단순히 "ROLE_USER"만 반환합니다.
//    	Collection<GrantedAuthority> collection = new ArrayList<>();
//    	collection.add(new GrantedAuthority() {
//    	
//			@Override
//			public String getAuthority() {
//				
//				return userDTO.getRole();
//			}
//			
//		});
//    	
//        return collection;
//    }
//
//    @Override
//    public String getPassword() {
//        return userDTO.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return userDTO.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true; // 계정 만료 여부를 설정합니다.
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true; // 계정 잠금 여부를 설정합니다.
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true; // 비밀번호 만료 여부를 설정합니다.
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true; // 계정 활성화 여부를 설정합니다.
//    }
//}