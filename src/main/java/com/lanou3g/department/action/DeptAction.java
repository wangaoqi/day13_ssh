package com.lanou3g.department.action;

import com.lanou3g.base.BaseAction;
import com.lanou3g.department.domain.Department;
import com.lanou3g.department.service.DeptService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.stereotype.Controller;

import java.util.List;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/13.
 */
public class DeptAction extends BaseAction<Department,DeptService>{

    private List<Department> departments;

    public String query() {
        departments = service.query();
        return SUCCESS;
    }

    public String saveOrUpdate() {
        service.saveOrUpdate(getModel());
        return SUCCESS;
    }

    /**
     * 根据部门Id查询对应信息
     * @return
     */
    public String findByDepId(){
        List<Department> byDeptId = service.findByDeptId(getModel());
        //使用基类的方法,向session中存数据
        sessionPut("byDeptId",byDeptId.get(0));
        return SUCCESS;
    }



    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
