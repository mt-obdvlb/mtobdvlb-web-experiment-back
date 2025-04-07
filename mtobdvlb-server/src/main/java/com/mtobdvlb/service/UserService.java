package com.mtobdvlb.service;


import com.mtobdvlb.dto.UserLoginDTO;
import com.mtobdvlb.entity.User;

public interface UserService {
    User login(UserLoginDTO userLoginDTO);
}
