package com.lanou3g.department.service;

import com.lanou3g.department.domain.Department;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface DeptService {

    List<Department> query();

    void saveOrUpdate(Department department);

    List<Department> findByDeptId(Department department);

}
