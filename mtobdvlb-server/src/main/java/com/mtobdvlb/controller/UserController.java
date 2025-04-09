package com.mtobdvlb.controller;

import com.mtobdvlb.constant.JwtClaimsConstant;
import com.mtobdvlb.dto.UserUpdateDTO;
import com.mtobdvlb.dto.UserForgetPasswordDTO;
import com.mtobdvlb.dto.UserLoginDTO;
import com.mtobdvlb.dto.UserPageQueryDTO;
import com.mtobdvlb.entity.User;
import com.mtobdvlb.properties.JwtProperties;
import com.mtobdvlb.result.PageResult;
import com.mtobdvlb.result.Result;
import com.mtobdvlb.service.UserService;
import com.mtobdvlb.utils.JwtUtils;
import com.mtobdvlb.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录，用户名：{}", userLoginDTO.getUsername());
        User user = userService.login(userLoginDTO);
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        String token = JwtUtils.createJWT(
                jwtProperties.getSecret(),
                jwtProperties.getTtl(),
                claims
        );
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .token(token)
                .avatar(user.getAvatar())
                .email(user.getEmail())
                .email(user.getEmail())
                .build();
        return Result.success(userLoginVO);
    }

    @PostMapping("/save")
    public Result save(@RequestBody User user) {
        log.info("保存用户信息：{}", user);
        userService.save(user);
        return Result.success();
    }

    @PostMapping("/logout")
    public Result logout() {
        log.info("用户退出登录");
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody UserUpdateDTO userUpdateDTO) {
        log.info("修改用户信息：{}", userUpdateDTO);
        userService.update(userUpdateDTO);
        return Result.success();
    }

    @PutMapping("/forget-password")
    public Result forgetPassword(@RequestBody UserForgetPasswordDTO userForgetPasswordDTO) {
        log.info("修改用户密码：{}", userForgetPasswordDTO);
        userService.forgetPassword(userForgetPasswordDTO);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<User> getById(@PathVariable Long id) {
        log.info("根据id查询用户信息：{}", id);
        User user = userService.getById(id);
        log.info("查询结果：{}", user);
        return Result.success(user);
    }

    @GetMapping("/page")
    public Result<PageResult> page(UserPageQueryDTO userPageQueryDTO) {
        log.info("分页查询：{}", userPageQueryDTO);
        PageResult pageResult = userService.pageQuery(userPageQueryDTO);
        return Result.success(pageResult);
    }

}
