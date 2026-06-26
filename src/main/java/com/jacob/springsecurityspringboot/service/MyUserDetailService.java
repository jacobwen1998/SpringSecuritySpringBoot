package com.jacob.springsecurityspringboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jacob.springsecurityspringboot.entity.Users;
import com.jacob.springsecurityspringboot.mapper.UserInfoMapper;
import com.jacob.springsecurityspringboot.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Users> wrapper = new QueryWrapper();

        String pwd = "dummmy";
        return new User(username, pwd, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,"));
    }
}
