package com.lanou3g.login.service.impl;

import com.lanou3g.login.dao.LoginDao;
import com.lanou3g.login.service.LoginService;
import com.lanou3g.staff.domain.Staff;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginDao loginDao;
    @Override
    public List<Staff> query(String loginName, String loginPwd) {
        return loginDao.query(loginName,loginPwd);
    }



    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
