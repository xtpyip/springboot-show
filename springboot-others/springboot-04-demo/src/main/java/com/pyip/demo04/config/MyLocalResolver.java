package com.pyip.demo04.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @ClassName: MyLocalResolver
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 自定义本地解析器
 **/

public class MyLocalResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求参数
        String lang = request.getParameter("l");
        Locale locale = Locale.getDefault();//如果没有就用默认的
        //如果请求链接携带了国际化的参数
        if (!StringUtils.isEmpty(lang)){
            //zh_CN
            String[] split = lang.split("_");
            //国家，地区
            locale= new Locale(split[0], split[1]);
        }else{
            String header = request.getHeader("Accept-Language");
            String[] split = header.split(",");
            String[] split1 = split[0].split("-");
            locale = new Locale(split1[0],split1[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
