package com.mtobdvlb.service;


import com.mtobdvlb.dto.UserUpdateDTO;
import com.mtobdvlb.dto.UserForgetPasswordDTO;
import com.mtobdvlb.dto.UserLoginDTO;
import com.mtobdvlb.dto.UserPageQueryDTO;
import com.mtobdvlb.entity.User;
import com.mtobdvlb.result.PageResult;
import com.mtobdvlb.vo.UserLoginVO;

public interface UserService {
    UserLoginVO login(UserLoginDTO userLoginDTO);

    void save(User user);

    void update(UserUpdateDTO userUpdateDTO);

    void forgetPassword(UserForgetPasswordDTO userForgetPasswordDTO);

    User getById(Long id);

    PageResult pageQuery(UserPageQueryDTO userPageQueryDTO);

    void delete(Long id);
}
