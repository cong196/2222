package com.hellokoding.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hellokoding.springboot.database.adapter;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
    @RequestMapping("/icsse2017")
    public String icsse2017(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	return "mainicsse17";
    }
    @RequestMapping("/editor")
    public String editor(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	adapter get = new adapter();
    	String noidung = get.layNoidung();
        model.addAttribute("text",noidung);
    	//model.addAttribute("message", "hello");
        return "ED";
    }
    /**
     * @param model
     * @param noidung
     * @return
     */
    @RequestMapping(value ="/upload")
    @ResponseBody 
    public String uploadck(Model model,@RequestParam("noidung") String noidung) {
    	try{
    		System.out.println("f56456464567876GGGGGGGGGGGGGGGGGGGGGGfff");
	    	adapter set = new adapter();
	    	set.CapNhat(noidung);
	    	//System.out.println(noidung);
	    	return "thanhcong";
    	}
    	catch (Exception e) {
    		return "thatbai";
		}
        
    }
    
    @RequestMapping(value ="/thatbai")
    public String thatbai() {
        return "thatbai";
    }
   /* @RequestMapping(value ="/thanhcong")
    public String thanhcong() {
    	
    	
        return "thanhcong";
    }*/
    @RequestMapping("/thanhcong")
    public String thanhcong(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	return "thanhcong";
    }
}
