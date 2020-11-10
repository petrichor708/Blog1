package com.lala.blog.service;

import com.lala.blog.po.User;

public interface UserService {

    User checkUser(String username,String password);

}
