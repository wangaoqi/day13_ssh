package com.lanou3g.post.dao.impl;

import com.lanou3g.department.domain.Department;
import com.lanou3g.post.dao.PostDao;
import com.lanou3g.post.domain.Post;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {


    @Override
    public List<Post> query(Post post) {
        List<Post> list = (List<Post>) getHibernateTemplate().find("from Post T_POST");
        return list;
    }

    /**
     * 对职务进行添加或修改操作
     * @param post
     */
    @Override
    public void saveOrUpdate(Post post) {
        if ("".equals(post.getPostId())){
            getHibernateTemplate().save(post);
        }else {
            getHibernateTemplate().saveOrUpdate(post);
        }
    }

    @Override
    public List<Department> findDepartment() {
        return (List<Department>) getHibernateTemplate().find("from Department dept");
    }

    /**
     * 根据职务Id查询对应职位返回到修改界面
     * @param post
     * @return
     */
    @Override
    public List<Post> findByPostId(Post post) {
        return (List<Post>) getHibernateTemplate()
                .find("from Post where postId=?",post.getPostId());
    }
}


