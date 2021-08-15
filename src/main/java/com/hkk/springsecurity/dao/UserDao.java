package com.hkk.springsecurity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hkk.springsecurity.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends BaseMapper<UserEntity> {
}
