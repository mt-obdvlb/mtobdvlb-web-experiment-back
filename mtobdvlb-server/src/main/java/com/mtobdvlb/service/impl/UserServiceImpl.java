package com.mtobdvlb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mtobdvlb.constant.MessageConstant;
import com.mtobdvlb.dto.UserDTO;
import com.mtobdvlb.dto.UserEditPasswordDTO;
import com.mtobdvlb.dto.UserLoginDTO;
import com.mtobdvlb.dto.UserPageQueryDTO;
import com.mtobdvlb.entity.User;
import com.mtobdvlb.exception.AccountNotFoundException;
import com.mtobdvlb.exception.PasswordErrorException;
import com.mtobdvlb.mapper.UserMapper;
import com.mtobdvlb.result.PageResult;
import com.mtobdvlb.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

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

    @Override
    public void save(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userMapper.insert(user);
    }

    @Override
    public void update(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userMapper.update(user);
    }

    @Override
    public void editPassword(UserEditPasswordDTO userEditPasswordDTO) {
        User user = new User();
        BeanUtils.copyProperties(userEditPasswordDTO, user);
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userMapper.update(user);
    }

    @Override
    public User getById(Long id) {
        User user = userMapper.getById(id);
        if(user == null) {
            throw new AccountNotFoundException(MessageConstant.USER_NOT_EXIST);
        }
        return user;
    }

    @Override
    public PageResult pageQuery(UserPageQueryDTO userPageQueryDTO) {
        PageHelper.startPage(userPageQueryDTO.getPage(), userPageQueryDTO.getPageSize());
        Page<User> page = userMapper.pageQuery(userPageQueryDTO);
        long total = page.getTotal();
        List<User> records = page.getResult();
        return new PageResult(total, records);
    }
}
