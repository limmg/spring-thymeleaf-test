package com.offcn.controller;

import com.offcn.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

/**
 * Created by LM on 2020/9/27 19:03
 * 我在这里的网页上进行了一些修改！
 *  注意：
 *  *      千万不能使用@RestController
 *  *          @Controller
 *  *          @ResponseBody
 *  *
 *  *    ThymeleafController:
 *  *             作用：
 *  *                  设置模型数据
 *  *                  跳转到页面显示，不是直接写入responsebody 响应到浏览器
 */
@Controller
public class FirstThymeleafController {


    @GetMapping("/first")
    public String indexPage(Model model) {
        String message = "测试---Thymeleaf!";
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping("/two")
    public String indexPage1(Model model) {
        User user = new User();
        user.setId(1);
        user.setName("成龙");
        model.addAttribute("user",user);

        Map map=new HashMap();
        map.put("id",2);
        map.put("name","tom");
        model.addAttribute("map",map);
        return "index1";
    }
    @GetMapping("/third")
    public String indexPage2(Model model) {
        List<User> list  =new ArrayList<>();
        User user=new User(3,"甄子丹");
        User user1=new User(4,"zhans");
        User user2=new User(5,"lilianjie");
        User user3=new User(6,"天蝎座");
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        model.addAttribute("list",list);


        return "index2";
    }

    @GetMapping("/four")
    public String indexpage4(Model model) {
        //字符串
        model.addAttribute("msg", "这首歌真好听啊！");
        //链接
        model.addAttribute("href", "http://www.baidu.com");
        //图片
        model.addAttribute("img", "1.jpg");
        return "index3";
    }
    @GetMapping("/five")
    public String indexpage5(Model model) {
        //测试条件判断
        model.addAttribute("flag", false);
        model.addAttribute("num",1);
        model.addAttribute("manager","manager");

        return "index5";
    }
    @GetMapping("/six")
    public String indexpage6(Model model) {
        //静态资源加载footer
        return "index6";
    }
    @GetMapping("/eleven")
    public String indexpage7(Model model) {
        //日期加载
        model.addAttribute("date",new Date());
        //小数
        model.addAttribute("price",2.657281);
        //大量文本
        String str="会话:用户打开浏览器，浏览页面，直到关闭浏览器的过程称为一次会话。\n" +
                "为什么要学习会话技术？\n" +
                "http协议是一个无状态协议，服务器端无法记录客户端浏览器身份信息。\n" +
                "例如：购物网站，购物车（需要记录用户购买商品的信息）。\n" +
                "如何做到？ request？ 无法实现，会发现结账时，没有任何商品信息。\n" +
                "ServletContext？ 无法实现，结账时会发现，所有人的商品\n" +
                "信息都在购物车中。";
        model.addAttribute("str", str);
        //字符串剪切
        model.addAttribute("sub", "JAVATHYMELEAF");
        return "index7";
    }
}
