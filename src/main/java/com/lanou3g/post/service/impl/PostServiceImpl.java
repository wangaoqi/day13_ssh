package com.lanou3g.post.service.impl;

import com.lanou3g.department.domain.Department;
import com.lanou3g.post.dao.PostDao;
import com.lanou3g.post.domain.Post;
import com.lanou3g.post.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */

public class PostServiceImpl implements PostService {

    private PostDao postDao;


    @Override
    public List<Post> query(Post post) {
        return postDao.query(post);
    }

    @Override
    public void saveOrUpdate(Post post) {

        postDao.saveOrUpdate(post);
    }

    /**
     * 查询所有部门(下拉列表的内容)
     * @return
     */
    @Override
    public List<Department> findDepartment() {

        return postDao.findDepartment();
    }

    @Override
    public List<Post> findByPostId(Post post) {

        return postDao.findByPostId(post);
    }

    public void setPostDao(PostDao postDao) {

        this.postDao = postDao;
    }
}
