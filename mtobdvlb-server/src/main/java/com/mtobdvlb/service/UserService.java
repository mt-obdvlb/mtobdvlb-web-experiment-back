package com.mtobdvlb.service;


import com.mtobdvlb.dto.UserDTO;
import com.mtobdvlb.dto.UserEditPasswordDTO;
import com.mtobdvlb.dto.UserLoginDTO;
import com.mtobdvlb.dto.UserPageQueryDTO;
import com.mtobdvlb.entity.User;
import com.mtobdvlb.result.PageResult;

public interface UserService {
    User login(UserLoginDTO userLoginDTO);

    void save(User user);

    void update(UserDTO userDTO);

    void editPassword(UserEditPasswordDTO userEditPasswordDTO);

    User getById(Long id);

    PageResult pageQuery(UserPageQueryDTO userPageQueryDTO);
}
