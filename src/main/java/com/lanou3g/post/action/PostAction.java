package com.lanou3g.post.action;

import com.lanou3g.base.BaseAction;
import com.lanou3g.department.domain.Department;
import com.lanou3g.post.domain.Post;
import com.lanou3g.post.service.PostService;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */

public class PostAction extends BaseAction<Post,PostService> {

    private List<Post> query;

    private List<Department> departments;

    public String query() {
        query = service.query(getModel());
        return SUCCESS;
    }

    public String saveOrUpdate() {
        service.saveOrUpdate(getModel());
        return SUCCESS;
    }


    public String findDepartment(){
        departments = service.findDepartment();
        contextPut("deps",departments);
        return SUCCESS;
    }

    /**
     * 根据职位Id查询对应信息
     * @return
     */
    public String findByPostId(){
        List<Post> byPostId = service.findByPostId(getModel());
        //继承基类,将postId存在context中
        contextPut("byPostId",byPostId.get(0));
        return SUCCESS;
    }


    public List<Post> getQuery() {
        return query;
    }

    public void setQuery(List<Post> query) {
        this.query = query;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
