package com.jacob.springsecurityspringboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jacob.springsecurityspringboot.entity.Users;
import com.jacob.springsecurityspringboot.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<Users>();
        queryWrapper.eq("username", s);
        Users users = (Users) usersMapper.selectOne(queryWrapper);
        if (users == null) {
            throw new UsernameNotFoundException("username not found");
        }
        System.out.println("username : " + users.getUsername());
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User(users.getUsername(), users.getPassword(), auths);
        //return new User(s, pwd, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,"));
    }
}
