package com.mtobdvlb.service;


import com.mtobdvlb.dto.UserUpdateDTO;
import com.mtobdvlb.dto.UserForgetPasswordDTO;
import com.mtobdvlb.dto.UserLoginDTO;
import com.mtobdvlb.dto.UserPageQueryDTO;
import com.mtobdvlb.entity.User;
import com.mtobdvlb.result.PageResult;

public interface UserService {
    User login(UserLoginDTO userLoginDTO);

    void save(User user);

    void update(UserUpdateDTO userUpdateDTO);

    void forgetPassword(UserForgetPasswordDTO userForgetPasswordDTO);

    User getById(Long id);

    PageResult pageQuery(UserPageQueryDTO userPageQueryDTO);
}
