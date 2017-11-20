package com.lanou3g.department.dao;

import com.lanou3g.department.domain.Department;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface DeptDao {
    List<Department> query();

    void saveOrUpdate(Department department);

    //根据部门Id查询对应部门显示到编辑页面
    List<Department> findByDeptId(Department department);

}
