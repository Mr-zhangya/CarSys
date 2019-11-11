package com.demo.carsys.controller;

import com.demo.carsys.entity.User;
import com.demo.carsys.service.UserService;
import com.demo.carsys.utils.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(User user) {
        if (user.getTel() != null && user.getTel() != "") {
            user.setTel(user.getTel());
            user.setPassword(user.getPassword());
            return "forward:loginSuccess";
        }
        return "login";
    }

    @ResponseBody
    @RequestMapping("/loginSuccess")
    public String loginSuccess(String tel,String password,HttpSession session) {

        logger.info(tel);
        User user = new User();
        user.setTel(tel);
        user.setPassword(password);

        boolean result = userService.selectUserByTelAndPassword(user);
        if (result) {
            session.setAttribute("Tel",user.getTel());
            return JsonUtils.objectToJson("success");
        }
        return JsonUtils.objectToJson("fail");
    }
    @RequestMapping("/index")
    public String loginSuccess() {
        return "loginsuccess";
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("Tel");
        return "forward:login";
    }
    @RequestMapping("/register")
    @ResponseBody
    public String register(User user) {
        logger.info(user);
        int count = userService.register(user);
        logger.info(count);
        if (count == 1) {
            return JsonUtils.objectToJson("success");
        }
        return JsonUtils.objectToJson("fail");
    }
}
