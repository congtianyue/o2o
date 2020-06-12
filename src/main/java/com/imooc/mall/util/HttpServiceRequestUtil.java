package com.imooc.mall.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 接受并响应HttpServletRequest转化的参数
 */
public class HttpServiceRequestUtil {
    public static int getInt(HttpServletRequest request,String key){
        try{
            return Integer.decode(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }
    public static Long getLong(HttpServletRequest request, String key){
        try{
            return Long.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1L;
        }
    }
    public static Double getDouble(HttpServletRequest request,String key){
        try{
            return Double.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1d;
        }
    }
    public static boolean getBoolen(HttpServletRequest request,String key){
        try{
            return Boolean.valueOf(request.getParameter(key));
        }catch (Exception e){
            return false;
        }
    }
    public static String getString(HttpServletRequest request,String key){
        try{
            String result=request.getParameter(key);
            if (request!=null){
                result=result.trim();
            }
            if ("".equals(result)){
                result=null;
            }
            return result;
        }catch (Exception e){
            return null;
        }
    }
}
