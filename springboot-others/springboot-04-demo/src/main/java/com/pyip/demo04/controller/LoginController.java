package com.pyip.demo04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

/**
 * @ClassName: DemoController
 * @version: 1.0
 * @Author: pyipXt
 * @Description: controller登陆
 **/
@Controller
public class LoginController {
    @RequestMapping("/toLoginPage")
    public String toLoginPage(Model model){
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }
}
