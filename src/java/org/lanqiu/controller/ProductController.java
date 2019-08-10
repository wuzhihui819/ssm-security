package org.lanqiu.controller;


import org.lanqiu.entity.Msg;
import org.lanqiu.entity.Product;
import org.lanqiu.entity.Security;
import org.lanqiu.service.ProductService;
import org.lanqiu.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping("/doSerach")
    public  String doSerach(Integer id, Model model){
        Product product = productService.queryProductByNo(id);
        model.addAttribute("product",product);
        return "result";
    }

    @RequestMapping("/doCheck")
    public ModelAndView doCheck(String identify){
        Security security = securityService.queryBySecurityId(identify);
        ModelAndView modelAndView = new ModelAndView();
        if(security==null){
            String msg1 = "验证失败，此验证码不存在！" ;
            String msg2= "该产品码验证不成功，可能是假冒产品，请注意购买渠道，联系商家，也可在该公众号举报！";
            modelAndView.addObject("msg1",msg1);
            modelAndView.addObject("msg2",msg2);
            modelAndView.setViewName("result");
        }else{
            securityService.updateById(security.getId());
            modelAndView.addObject("security",security);
            modelAndView.setViewName("result");
        }
        return modelAndView;
    }

    @RequestMapping("/checkId")
    public Msg checkId(@RequestParam("securityId") String securityId){
        String regx = "(^[a-zA-Z0-9_-]{16}$)";
        if(!securityId.matches(regx)){
            return  Msg.fail();
        }else{
            return Msg.success();
        }
    }
}
