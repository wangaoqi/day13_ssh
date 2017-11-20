package com.lanou3g.department.dao.impl;

import com.lanou3g.department.dao.DeptDao;
import com.lanou3g.department.domain.Department;
import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * Created by dllo on 17/11/13.
 */
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao{
    @Override
    public List<Department> query() {
        //spring容器中所配置的hibernate的操作对象
        List<Department> list = (List<Department>)
                getHibernateTemplate().find("from Department T_DEPT");
        return list;

    }

    @Override
    public void saveOrUpdate(Department department) {
        if (department.getDepId()==null){
            getHibernateTemplate().save(department);
        }else {
            getHibernateTemplate().saveOrUpdate(department);
        }

    }

    @Override
    public List<Department> findByDeptId(Department department) {
        return (List<Department>) getHibernateTemplate()
                .find("from Department where depId=?",department.getDepId());
    }


}
