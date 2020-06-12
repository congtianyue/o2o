package com.imooc.mall.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "shopadmin",method = RequestMethod.GET)
public class ShopAdminController {

    @RequestMapping(value = "/shopoperation")
    public String ShopOperation(){
        /**
         * 路径编写方式的原因为：spring-web.xml配置已经编写：
         *  <property name="prefix" value="/WEB-INF/html/"></property>
         *  <property name="suffix" value=".html"></property>
         */
        return "shop/shopoperation";

    }
}
