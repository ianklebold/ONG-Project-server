package com.alkemy.ong.service;

import com.alkemy.ong.auth.dto.AuthenticationRequest;
import com.alkemy.ong.dto.UserBasicDto;
import com.alkemy.ong.dto.UserDto;
import com.alkemy.ong.dto.UserProfileDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IUserService {

    UserBasicDto signup(UserDto userDto) ;

    UserProfileDto getUserProfile(HttpServletRequest request);

    String generateToken(AuthenticationRequest authRequest) throws Exception;

    List<UserBasicDto> returnList();
}
