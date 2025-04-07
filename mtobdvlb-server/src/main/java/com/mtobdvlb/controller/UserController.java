package com.mtobdvlb.controller;

import com.mtobdvlb.constant.JwtClaimsConstant;
import com.mtobdvlb.dto.UserLoginDTO;
import com.mtobdvlb.entity.User;
import com.mtobdvlb.properties.JwtProperties;
import com.mtobdvlb.result.Result;
import com.mtobdvlb.service.UserService;
import com.mtobdvlb.utils.JwtUtils;
import com.mtobdvlb.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                .build();
        return Result.success(userLoginVO);
    }

}
