package com.demo.carsys.controller;

import com.demo.carsys.entity.User;
import com.demo.carsys.service.RegisterService;
import com.demo.carsys.utils.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private static final Logger logger = LogManager.getLogger(RegisterController.class);

    @Autowired
    RegisterService registerService;


    @RequestMapping("/")
    public String register() {
        return "register";
    }

    @RequestMapping("/verifyTel")
    @ResponseBody
    public String verifyTel(String tel) {
        logger.info("tel验证方法执行");
        logger.info(tel);
        int count = registerService.verifyTel(tel);
        if (count == 1) {
            return JsonUtils.objectToJson("fail") ;
        }
        return JsonUtils.objectToJson("success");
    }

    @RequestMapping("/validate")
    @ResponseBody
    public String validate(User user, HttpSession session) {
        int count = registerService.validate(user);
        if (count == 1) {
            session.setAttribute("validate", user.getInvitation());
            return JsonUtils.objectToJson("success");
        }
        return JsonUtils.objectToJson("fail");
    }
    @RequestMapping("/validateCode")
    @ResponseBody
    public String validateCode(String invitation,HttpSession session) {
        boolean result = invitation.equals(session.getAttribute("validate"));
        if (result) {
            return JsonUtils.objectToJson("success");
        }
        return JsonUtils.objectToJson("fail");
    }
}
