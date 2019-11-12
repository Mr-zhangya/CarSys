package com.demo.carsys.service.impl;

import com.demo.carsys.entity.User;
import com.demo.carsys.mapper.RegisterMapper;
import com.demo.carsys.service.RegisterService;
import com.demo.carsys.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterMapper registerMapper;

    @Transactional
    public int verifyTel(String tel) {
        return registerMapper.verifyTel(tel);
    }

    @Transactional
    public int validate(User user) {

        // 查看邮箱是否已被注册
        int count = registerMapper.selectUserByEmail(user.getEmail());
        if (count == 0) {
            // user 中包含 email
            // 获取四位随机验证码
            String InvitationCode = MailUtils.getInvitationCode(4);
            user.setInvitation(InvitationCode);

            //发送验证码
            MailUtils.sendMail(user.getEmail(), "尊敬的客户您好，您正在注册CSD车速递，您的验证码是："
                    + InvitationCode + "，请及时输入验证码，欢迎进入CSD车速递！", "车速递验证码");
            return 1;
        }

        return 0;
    }
}
