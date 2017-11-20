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


    /**
     * 高级查询的判断条件
     * @param postId
     * @param depId
     * @param staffName
     * @return
     */
    @Override
    public List<Staff> findPostIdAndDepId(String postId, String depId, String staffName) {

        if (postId==null && depId==null && staffName==null){
            return (List<Staff>) getHibernateTemplate().find("from Staff staff");
        }
        //条件全部为空
        if ("".equals(postId) && "".equals(depId) && "".equals(staffName)) {
            return (List<Staff>) getHibernateTemplate().find("from Staff staff");
        }
        //部门depID和职务postId不为空且staffName为空
        else if (!"".equals(postId) && !"".equals(depId) && "".equals(staffName)) {
            return (List<Staff>) getHibernateTemplate().find("from Staff staff where post.postId=? and post.department.depId=?", postId, depId);
        }
        //部门depID不为空且职务postId为空且staffName为空
        else if ("".equals(postId) && !"".equals(depId) && "".equals(staffName)) {
            return (List<Staff>) getHibernateTemplate().find("from Staff staff where post.department.depId=?", depId);
        }
        //部门depID和职务postId为空staffName不为空
        else if ("".equals(postId) && "".equals(depId) && !"".equals(staffName)){
            return (List<Staff>) getHibernateTemplate().find("from Staff staff where staffName=?",staffName);
        }
        //条件全有
        return (List<Staff>) getHibernateTemplate().find("from Staff staff ");
    }

    @Override
    public List<Staff> findByStaffId(Staff staff) {
        return (List<Staff>) getHibernateTemplate()
                .find("from Staff where staffId=?",staff.getStaffId());
    }

    /**
     * 模糊查询
     * @param ss 判断之后的拼接sql语句
     * @return
     */
    @Override
    public List<Staff> findSome(String ss) {
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
