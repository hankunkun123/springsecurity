package com.hkk.springsecurity.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hkk.springsecurity.dao.UserDao;
import com.hkk.springsecurity.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        QueryWrapper<UserEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userName",userName);
        UserEntity userEntity = userDao.selectOne(queryWrapper);
        if(userEntity==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> role = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User(userEntity.getUserName(),new BCryptPasswordEncoder().encode(userEntity.getPassword()),role);
    }
}
