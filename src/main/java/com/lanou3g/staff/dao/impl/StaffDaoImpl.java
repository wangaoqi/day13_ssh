package com.lanou3g.staff.dao.impl;

import com.lanou3g.department.domain.Department;
import com.lanou3g.post.domain.Post;
import com.lanou3g.staff.dao.StaffDao;
import com.lanou3g.staff.domain.Staff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao{

    @Override
    public List<Staff> findAll() {

        return (List<Staff>) getHibernateTemplate().find("from Staff T_STAFF");
    }

    @Override
    public void save(Staff staff) {

        getHibernateTemplate().save(staff);
    }

    @Override
    public void update(Staff staff) {

        getHibernateTemplate().saveOrUpdate(staff);
    }



    @Override
    public List<Staff> findByStaffId(Staff staff) {
        return (List<Staff>) getHibernateTemplate()
                .find("from Staff where staffId=?",staff.getStaffId());
    }

    /**
     * 高级查询
     * @param ss 判断之后的拼接sql语句
     * @return
     */
    @Override
    public List<Staff> findSome(String ss) {
        //按照想要的方式去拼接sql语句
        String sql = "from Staff where 1=1 " + ss;
        return (List<Staff>) getHibernateTemplate().find(sql);
    }

    @Override
    public List<Department> findDepartment() {
        return (List<Department>) getHibernateTemplate().find("from Department dept");
    }

    @Override
    public List<Post> findPost(String depId) {
        return (List<Post>) getHibernateTemplate().find("from Post post where post.department.depId= ?",depId);
    }




}
