package com.imooc.mall.interceptor;

public class ShopOperatationException extends RuntimeException{

    private static final long serialVersionUID=2361446884822298905L;
    public ShopOperatationException(String msg){
        super(msg);
    }
}
