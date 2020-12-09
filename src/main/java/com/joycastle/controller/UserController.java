package com.joycastle.controller;

import com.joycastle.config.CaffeineCache;
import com.joycastle.generator.UIdGen;
import com.joycastle.model.Response;
import com.joycastle.model.User;
import com.joycastle.utils.DigestUtils;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;
import java.util.Objects;

/**
 * 用户注册登录
 *
 * @author wencai.xu
 * @version V1.0
 * @date 2020/12/8,0008
 **/
@Controller
@Api
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 用户随机名称生成器
     */
    private final UIdGen idGen;

    @Autowired
    public UserController(UIdGen idGen) {
        this.idGen = idGen;
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = {"/login.do"}, method = RequestMethod.POST)
    @ResponseBody
    public Response login(User user) {
        if (checkUser(user)) {
            return Response.error();
        }
        try {
            String cachePass = CaffeineCache.LOADING_CACHE.get(user.getUsername());
            String digest = DigestUtils.encode(user.getPassword());
            if (StringUtils.isNotEmpty(digest)) {
                if (digest.equals(cachePass)) {
                    return Response.success("登录成功");
                }
            }
        } catch (Exception ex) {
            return Response.error("登录失败");
        }
        return Response.error("登录失败");
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = {"/register.do"}, method = RequestMethod.GET)
    @ResponseBody
    public Response register(User user) {
        if (checkUser(user)) {
            return Response.error();
        }
        String username;
        try {
            username = String.valueOf(idGen.create(System.currentTimeMillis()));
            String digest = DigestUtils.encode(user.getPassword());
            if (StringUtils.isNotEmpty(digest)) {
                CaffeineCache.LOADING_CACHE.put(username, digest);
                // 线上不允许打印该类日志，请设置日志打印级别
                logger.debug("日志打印，用户名：{}，密码：{}",username, digest);
                return Response.success("注册成功，您的登录唯一id为" + username);
            }
        } catch (Exception ex) {
            return Response.error();
        }
        return Response.error("注册失败,请排查问题");
    }

    private boolean checkUser(User user) {
        return Objects.isNull(user) || StringUtils.isAnyEmpty(user.getPassword(), user.getUsername());
    }
}
