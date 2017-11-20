package com.lanou3g.post.domain;

import com.lanou3g.department.domain.Department;
import com.lanou3g.staff.domain.Staff;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/13.
 */
public class Post {

    private String postId;
    private String postName;

    private Department department;
    private Set<Staff> staffSet = new HashSet<>();

    public Post(String postId, Department department) {
    }


    public Post(String postId) {
        this.postId = postId;
    }

    public Post(String postName, Department department, Set<Staff> staffSet) {
        this.postName = postName;
        this.department = department;
        this.staffSet = staffSet;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                '}';
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Staff> getStaffSet() {
        return staffSet;
    }

    public void setStaffSet(Set<Staff> staffSet) {
        this.staffSet = staffSet;
    }
}
