package com.rs.mybatis.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rs.mybatis.pojo.User;
import com.rs.mybatis.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/queryUser")
    public String toIndex(HttpServletRequest request, Model model, User user) {
        User userDb = this.userService.findById(user);
        model.addAttribute("user", userDb);
        return "queryUser";
    }
}
