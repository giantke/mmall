package com.mmall.service.impl;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import com.mmall.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by apple on 2017/12/23.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUserNameCount(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("用户名不存在");
        }

        //todo md5密码
        String MD5password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username, MD5password);
        if (user == null) {
            return ServerResponse.createByErrorMsg("密码错误");
        }

        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功", user);
    }

    @Override
    public ServerResponse<String> register(User user) {
        int resultCount = userMapper.checkUserNameCount(user.getUsername());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMsg("用户名已存在");
        }
        resultCount = userMapper.checkEmailCount(user.getEmail());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMsg("邮箱已存在");
        }
        user.setRole(Const.Role.ROLE_CUSTOMER);
        //密码用MD5加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        resultCount = userMapper.insert(user);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("注册失败");
        }
        return ServerResponse.createBySuccess("注册成功");
    }
}
