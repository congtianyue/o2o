package com.imooc.mall.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request){
        String verifyCodeExpected= (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String verifycodeActual= HttpServletRequestUtil.getString(request,"verifyCodeActual");
        if (verifycodeActual==null || !verifycodeActual.equals(verifyCodeExpected)){
            return false;
        }
        return true;

    }
}
