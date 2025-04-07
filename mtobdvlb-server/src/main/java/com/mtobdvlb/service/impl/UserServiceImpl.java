package com.mtobdvlb.service.impl;

import com.mtobdvlb.constant.MessageConstant;
import com.mtobdvlb.dto.UserLoginDTO;
import com.mtobdvlb.entity.User;
import com.mtobdvlb.exception.AccountNotFoundException;
import com.mtobdvlb.exception.PasswordErrorException;
import com.mtobdvlb.mapper.UserMapper;
import com.mtobdvlb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();
        User user = userMapper.getByUsername(username);
        if(ObjectUtils.isEmpty(user)) {
            throw new AccountNotFoundException(MessageConstant.USER_NOT_EXIST);
        }
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if(!password.equals(user.getPassword())) {
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        return user;
    }
}
