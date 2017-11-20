package com.lanou3g.staff.action;

import com.lanou3g.base.BaseAction;
import com.lanou3g.department.domain.Department;
import com.lanou3g.post.domain.Post;
import com.lanou3g.staff.domain.Staff;
import com.lanou3g.staff.service.StaffService;
import com.lanou3g.utils.MD5Util;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;



/**
 * Created by dllo on 17/11/13.
 */

public class StaffAction extends BaseAction<Staff,StaffService>{

    private String depId;
    private String postId;

    private List<Staff> staffs;
    private List<Department> departmentList;
    private List<Post> postList;

    //定义原始密码
    private String oldPassword;
    //新密码
    private String newPassword;
    //确认的新密码
    private String reNewPassword;
    private List<Staff> some;


    //查询所有
    public String findAll(){
        staffs = service.findAll();
        ActionContext.getContext().put("staffs",staffs);
        return SUCCESS;
    }

    public String save() {
        service.save(getModel());
        departmentList = service.findDepartment();
        return SUCCESS;
    }

    public String update(){

        service.update(getModel());
        departmentList = service.findDepartment();

        return SUCCESS;
    }

    /**
     * 高级查询
     * @return
     */
    public String findSome(){
        some = service.findSome(getModel());
        return SUCCESS;
    }


    /**
     * 查询部门
     * @return
     */
    public String findDepartment(){
        departmentList = service.findDepartment();
        contextPut("departmentL",departmentList);
        return SUCCESS;
    }

    /**
     * 根据传过来的部门Id查处职务信息
     * @return
     */
    public String findPosts() {
        postList = service.findPost(depId);
        departmentList = service.findDepartment();
        return SUCCESS;
    }

    /**
     * 根据员工Id查询对应的员工信息并显示出来
     * @return
     */
    public String findByStaffId(){
        List<Staff> byStaffId = service.findByStaffId(getModel());
        contextPut("byStaffId",byStaffId.get(0));
        // 把职务的值传到前端
        sessionPut("setPostId",byStaffId.get(0).getPost().getPostId());
        sessionPut("setPostName",byStaffId.get(0).getPost().getPostName());
        return SUCCESS;
    }

    /**
     * 更改密码
     * @return
     */
    public String updatePassword(){
        Staff list = (Staff) ActionContext.getContext().getSession().get("sta");
        if (!list.getLoginPwd().equals(MD5Util.MD5(oldPassword))||
                !newPassword.equals(reNewPassword) || newPassword.equals("")){
            addFieldError("","密码输入有问题!");
            return ERROR;
        }else {
            list.setLoginPwd(MD5Util.MD5(newPassword));
            service.update(list);
            ActionContext.getContext().getSession().clear();
            return SUCCESS;
        }
    }



    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    public List<Staff> getSome() {
        return some;
    }

    public void setSome(List<Staff> some) {
        this.some = some;
    }
}

