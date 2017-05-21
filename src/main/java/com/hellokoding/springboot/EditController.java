package com.hellokoding.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hellokoding.springboot.DB.GetDB;

@Controller 
public class EditController {
	@RequestMapping("/edit")
    public String welcome(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	
    	GetDB get = new GetDB();
    	String Content = get.getDB();
        model.addAttribute("text",Content);
        return "edit";
    }
	@RequestMapping(value ="/upload")
    @ResponseBody 
    public String uploadck(Model model,@RequestParam("content") String Content) {
		GetDB set = new GetDB();
    	set.Update(Content);
    	return "Update Successfully";
        
    }
	
}