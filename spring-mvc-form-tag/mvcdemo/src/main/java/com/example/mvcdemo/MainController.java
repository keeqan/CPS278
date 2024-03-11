package com.example.mvcdemo;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainController {@GetMapping("path")
	@RequestMapping("/showForm")
public String getMethodName(@RequestParam String param) {
    return "info-form";
}

@RequestMapping("/processForm")
public String processForm(HttpServletRequest request, Model model){
	String newPetName = request.getParameter("petName");
	newPetName = new StringBuilder(newPetName).reverse().toString();
	model.addAttribute("newPetName", newPetName);
	return "confirmation";
}
@RequestMapping("/processFormV2")
public String processFormV2(
	@RequestParam("petName") String allCapPetName,
	Model model
) {
	allCapPetName = allCapPetName.toUpperCase();
	model.addAttribute("allCapPetName", allCapPetName);
	return;
}
}



}