package com.lb.celebrity_server_user.controller;

import com.alibaba.fastjson.JSON;
import com.lb.celebrity_server_user.model.entity.User;
import com.lb.celebrity_server_user.param.LoginParam;
import com.lb.celebrity_server_user.service.AuthService;
import com.lb.celebrity_server_user.util.JwtTokenUtil;
import com.lb.server_common.bean.CurrentUser;
import com.lb.server_common.bean.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 授权
 *
 * @author ck
 * @date 2018-01-29
 */
@RestController
@RequestMapping(value = "/celebrity/auth")
public class AuthRestController extends BaseApiController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public ResponseData<String> login(@RequestBody @Valid LoginParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return errorMsg(bindingResult);
        }
        User user = authService.login(param);

        CurrentUser currentUser = new CurrentUser(user.getId(), user.getUserName(), user.getType());
        String token = jwtTokenUtil.generateToken(JSON.toJSONString(currentUser), jwtTokenUtil.getRandomKey());
        redisTemplate.opsForSet().add(String.format(currentUser.EMPLOYEE_LOGIN_TOKEN_REDIS_KEY_PREFIX + "%s:%s", user.getType(), user.getId(), token));
        return ResponseData.ok(token);
    }

    @GetMapping("/logout")
    public ResponseData logout() {
        //CurrentInfo info = getCurrentFromAuth();
        //if (!Objects.isNull(info)) {
        //    redisTemplate.opsForSet().remove(String.format(CurrentInfo.EMPLOYEE_LOGIN_TOKEN_REDIS_KEY_PREFIX + "%s:%s", info.getType(), info.getEmployeeId()),
        //            info.getToken());
        //}
        //return ResponseData.ok();
        return null;
    }
}
