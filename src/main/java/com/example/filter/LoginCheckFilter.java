package com.example.filter;


import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.utils.StringUtils;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;

        //        请求url
        String url=req.getRequestURI().toString();
        log.info("请求的URL：{}",url);

        //判断请求url是否包含login，包含则放行
        if (url.contains("login")){
            log.info("登录操作，放行。。。");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

//        获取令牌（token）
        String jwt=req.getHeader("token");


//        判断令牌是否存在
        if (StringUtils.isEmpty(jwt)) {
            log.info("请求头token为空，返回未登录的信息");

            // 调用 Result.error 方法并获取返回值
            Result errorResult = Result.error("not_login");

            // 将 Result 对象序列化为 JSON 字符串
            String noLogin = JSONObject.toJSONString(errorResult);

            // 设置响应的 ContentType，确保返回 JSON 格式
            resp.setContentType("application/json;charset=UTF-8");

            // 将 JSON 数据写入响应
            resp.getWriter().write(noLogin);

            return;
        }

// 解析token，如果解析失败，返回未登录的信息
        try {
            // 使用工具类解析 JWT 令牌
            JwtUtils.parseJWT(jwt);
            // 放行请求

        } catch (Exception e) {
            log.info("请求头token为空，返回未登录的信息");
            Result errorResult = Result.error("not_login");
            String noLogin = JSONObject.toJSONString(errorResult);
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write(noLogin);

            return;
        }

//        放行
        log.info("放行");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
