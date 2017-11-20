package com.lanou3g.post.service;

import com.lanou3g.department.domain.Department;
import com.lanou3g.post.domain.Post;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface PostService {

    List<Post> query(Post post);

    void saveOrUpdate(Post post);

    List<Department> findDepartment();


    /**
     * 根据职务Id查询对应职位返回到修改页面
     * @param post
     * @return
     */
    List<Post> findByPostId(Post post);

}
