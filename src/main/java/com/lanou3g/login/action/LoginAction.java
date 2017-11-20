package com.lanou3g.login.action;

import com.lanou3g.base.BaseAction;
import com.lanou3g.login.service.LoginService;
import com.lanou3g.staff.domain.Staff;
import com.lanou3g.utils.MD5Util;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;



/**
 * Created by dllo on 17/11/13.
 */
public class LoginAction extends BaseAction<Staff,LoginService>{


    private List<Staff> staffs;

    /**
     * 登录查询
     * @return
     */
    public String login(){

        //用户登录的密码是加密之后通过互联网传输的，然后跟数据库匹配
        //因为我数据密码传输的时候就已经加密处理了
        //虽说你密码输入123，但是经过加密后就不是123了，这个跟数据库匹配不同
        getModel().setLoginPwd(MD5Util.MD5(getModel().getLoginPwd()));


        staffs = service.query(getModel().getLoginName(), getModel().getLoginPwd());
        if(staffs.isEmpty()){
            addFieldError("","用户名或密码输入错误!!");
            return ERROR;
        }
        //向session中存数据
        sessionPut("username", staffs.get(0).getLoginName());
        sessionPut("sta",staffs.get(0));
        return SUCCESS;

    }

    /**
     * 退出登录
     * @return
     */
    public String exitLogin(){
        ActionContext.getContext().getSession().clear();
        return SUCCESS;
    }


    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }


}

