package com.hkk.springsecurity.controller;
import com.hkk.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hankunkun
 * @version 1.0
 * @date 2021/8/14 8:39
 */
@RestController
@RequestMapping( "/springseurity" )
public class SpringsecurityController{
    @Autowired
    private UserService userService;

    @RequestMapping("getHellloword")
    public UserDetails getHellloword(String userName){
     return  userService.loadUserByUsername(userName);
    }
}
