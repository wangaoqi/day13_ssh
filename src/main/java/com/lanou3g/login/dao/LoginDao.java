package com.lanou3g.login.dao;

import com.lanou3g.staff.domain.Staff;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface LoginDao {
    /**
     * 登录查询
     * @param loginName
     * @param loginPwd
     * @return
     */
    List<Staff> query(String loginName, String loginPwd);

}
