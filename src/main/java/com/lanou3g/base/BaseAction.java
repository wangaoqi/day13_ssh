package com.lanou3g.base;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;

import java.lang.reflect.ParameterizedType;

/**
 * Created by dllo on 17/11/13.
 */

//泛型也可以称之为类的参数,参数的类型是某个类,而不是对象
public class BaseAction<T,S> extends ActionSupport implements ModelDriven<T>{
    private T model;
    protected  S service;


    public BaseAction(){
        //获取当前类
        Class<? extends BaseAction> clazz = getClass();
        //获取父类的泛型参数
        ParameterizedType type = (java.lang.reflect.ParameterizedType) clazz.getGenericSuperclass();
        //获取所有泛型的集合
        Type[] typeArguments = type.getActualTypeArguments();
        //因为当前类只有一个泛型参数取第0个
        Class modelClass = (Class) typeArguments[0];
        //根据反射创建出泛型的对象
        try {
            model = (T) modelClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    @Override
    public T getModel() {
        return model;
    }

    //向session中存放数据
    public void sessionPut(String key, Object value){
        ActionContext.getContext().getSession().put(key, value);
    }

    // 向application中存放数据
    public void applicationPut(String key, Object value){
        ActionContext.getContext().getApplication().put(key, value);
    }

    // 向Context中存放数据
    public void contextPut(String key, Object value){
        ActionContext.getContext().getContextMap().put(key, value);
    }

    public HttpServletRequest getRequest(){
        return ServletActionContext.getRequest();
    }

    public HttpServletResponse getResponse(){
        return  ServletActionContext.getResponse();
    }

    public void setService(S service) {
        this.service = service;
    }
}
