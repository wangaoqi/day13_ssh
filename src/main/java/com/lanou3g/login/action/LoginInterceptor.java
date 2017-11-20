package com.lanou3g.login.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by dllo on 17/11/16.
 */

//登录拦截器: 获取未维护记录的信息列表
public class LoginInterceptor extends MethodFilterInterceptor{
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object staff = ActionContext.getContext().getSession().get("sta");

        if (staff != null){
            return actionInvocation.invoke();
        }
        ActionContext.getContext().getSession().put("error","亲请登录!");
        return "login";
    }
}
