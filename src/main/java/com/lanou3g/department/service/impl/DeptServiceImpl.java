package com.lanou3g.department.service.impl;

import com.lanou3g.department.dao.DeptDao;
import com.lanou3g.department.domain.Department;
import com.lanou3g.department.service.DeptService;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class DeptServiceImpl  implements DeptService{
    private  DeptDao deptDao;


    @Override
    public List<Department> query() {
        return deptDao.query();
    }

    @Override
    public void saveOrUpdate(Department department) {
        if (department!=null&&department.getDepId().equals("")){
            department.setDepId(null);
        }
       deptDao.saveOrUpdate(department);
    }

    @Override
    public List<Department> findByDeptId(Department department) {
        return deptDao.findByDeptId(department);
    }


    //spring给其赋值
    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }
}
