package com.lanou3g.login.dao.impl;

import com.lanou3g.login.dao.LoginDao;
import com.lanou3g.staff.domain.Staff;
import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * Created by dllo on 17/11/13.
 */
public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao {
    @Override
    public List<Staff> query(String loginName, String loginPwd) {
        Object[] value = {loginName,loginPwd};
        String sql = "from Staff T_STAFF where loginName = ? and loginPwd = ?";
        List<Staff> list = (List<Staff>) getHibernateTemplate()
                .find(sql, value);
        return list;
    }


}
