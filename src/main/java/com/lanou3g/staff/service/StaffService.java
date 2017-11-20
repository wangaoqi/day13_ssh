package com.lanou3g.staff.service;

import com.lanou3g.department.domain.Department;
import com.lanou3g.post.domain.Post;
import com.lanou3g.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface StaffService {

    List<Staff> findAll();

    void save(Staff staff);

    void update(Staff staff);

    List<Department> findDepartment();

    /**
     * 根据部门Id查询职务
     * @param depId
     * @return
     */
    List<Post> findPost(String depId);

    /**
     * 高级查询
     * @param postId
     * @param depId
     * @param staffName
     * @return
     */
    List<Staff> findPostIdAndDepId(String postId,String depId,String staffName);

    /**
     * 根据员工Id查询对应的员工信息
     * @param staff
     * @return
     */
    List<Staff> findByStaffId(Staff staff);

    /**
     * 模糊查询
     * @param
     * @return
     */
    List<Staff> findSome(Staff staff);
}
