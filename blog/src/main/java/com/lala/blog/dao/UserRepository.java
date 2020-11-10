package com.lala.blog.dao;

import com.lala.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {//long是主键类型
    User findByUsernameAndPassword(String username,String password);
}
