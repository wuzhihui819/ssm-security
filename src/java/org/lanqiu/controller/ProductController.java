package org.lanqiu.controller;


import org.lanqiu.entity.Product;
import org.lanqiu.entity.Security;
import org.lanqiu.service.ProductService;
import org.lanqiu.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping("/doSerach")
    public String doSerach(Integer id, Model model) {
        Product product = productService.queryProductByNo(id);
        model.addAttribute("product", product);
        return "result";
    }

    @RequestMapping("/doCheck")
    public ModelAndView doCheck(String identify) {
        Security security = securityService.queryBySecurityId(identify);
        ModelAndView modelAndView = new ModelAndView();
        if (security == null) {
            String msg1 = "验证失败，此验证码不存在！";
            String msg2 = "该产品码验证不成功，可能是假冒产品，请注意购买渠道，联系商家，也可在该公众号举报！";
            modelAndView.addObject("msg1", msg1);
            modelAndView.addObject("msg2", msg2);
            modelAndView.setViewName("result");
        } else {
            securityService.updateById(security.getId());
            modelAndView.addObject("security", security);
            modelAndView.setViewName("result");
        }
        return modelAndView;
    }




    @RequestMapping(value = "/CheckCode",method = RequestMethod.POST)
    public void CheckCodeServlet (HttpServletRequest request,HttpServletResponse response) throws IOException {
        String resultTip = "imgs/wrong.jpg";
        String checkcodeClient = request.getParameter("checkcode");
        String checkcodeServer = (String)request.getSession().getAttribute("CHECKCODE");
        if(checkcodeClient.equals(checkcodeServer)){
            resultTip = "imgs/right.jpg";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter(); //输出流
        writer.write(resultTip);
        writer.flush();
        writer.close();

    }
}
