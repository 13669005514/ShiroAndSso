package com.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
/**
 * 创建一个简单的shiro认证
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //构建SecurityFactory工厂(注意手动导入securityManager)
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //创建securitManager实例
        SecurityManager manager = factory.getInstance();
        //将securityManager设置到运行环境中
        SecurityUtils.setSecurityManager(manager);
        //获取subject实例
        Subject subject = SecurityUtils.getSubject();
        //创建用户名密码验证token
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","123456");
        //登录
        subject.login(token);
        //判断用户是否通过验证
        if (subject.isAuthenticated()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }







    }
}
