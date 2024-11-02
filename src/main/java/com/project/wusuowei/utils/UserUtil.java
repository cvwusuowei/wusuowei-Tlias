package com.project.wusuowei.utils;


import com.aliyuncs.ram.model.v20150501.CreateUserResponse;
import com.project.wusuowei.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class UserUtil {

    public static User getUserDetailsDTO() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
