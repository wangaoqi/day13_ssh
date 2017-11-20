package com.lanou3g.staff.service.impl;

import com.lanou3g.department.domain.Department;
import com.lanou3g.post.domain.Post;
import com.lanou3g.staff.dao.StaffDao;
import com.lanou3g.staff.domain.Staff;
import com.lanou3g.staff.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */

public class StaffServiceImpl implements StaffService{

    private StaffDao staffDao;

    @Override
    public List<Staff> findAll() {

        return staffDao.findAll();
    }

    @Override
    public void save(Staff staff) {
        staffDao.save(staff);
    }

    @Override
    public void update(Staff staff) {

        staffDao.update(staff);
    }

    @Override
    public List<Department> findDepartment() {

        return staffDao.findDepartment();
    }

    @Override
    public List<Post> findPost(String depId) {

        return staffDao.findPost(depId);
    }

    @Override
    public List<Staff> findPostIdAndDepId(String postId, String depId, String staffName) {
        return staffDao.findPostIdAndDepId(depId,postId,staffName);
    }

    @Override
    public List<Staff> findByStaffId(Staff staff) {

        return staffDao.findByStaffId(staff);
    }

    @Override
    public List<Staff> findSome(Staff staff) {
        String depId = staff.getPost().getDepartment().getDepId();
        String postId = staff.getPost().getPostId();
        String staffName = staff.getStaffName();

        String ss = returnSql(depId,postId,staffName);
        return staffDao.findSome(ss);
    }


    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    /**
     * 高级查询的判断条件
     * @param depId  判断传来的部门Id是否为空
     * @param postId  职务Id是否为空
     * @param staffName 员工名字是否为空
     * @return
     */
    public String returnSql(String depId, String postId, String staffName){
        String sql;
        // 三个都空
        if (depId.equals("-1")&&postId.equals("-1")&&staffName.equals("")){
            sql = "";
            return sql;
        }
        // 前两个空
        if (depId.equals("-1")&&postId.equals("-1")){
            sql = "and staffName like '%" + staffName + "%'";
            return sql;
        }
        // 后两个空
        if (postId.equals("-1")&&staffName.equals("")){
            sql = "and post.department.depId='" + depId + "'";
            return sql;
        }
        // 后一个空
        if (staffName.equals("")){
            sql="and post.department.depId ='" + depId + "' and post.postId='" + postId + "'";
            return sql;
        }

        // 中间空
        if (postId.equals("-1")){
            sql = "and post.department.depId='" + depId + "' and staffName like '%" + staffName + "%'";
            return sql;
        }

        // 三个都不空
        sql = "and post.department.depId='" + depId + "' and post.postId='"
                + postId + "' and staffName like '%" + staffName + "%'";

        return sql;
    }
}
