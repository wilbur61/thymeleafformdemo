package com.example.thymeleafformdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleController {
	
	   @GetMapping("/login")
	    public String loginForm(Model model) {

	        model.addAttribute("mylogin", new LoginPOJO());
	        return "create-login";
	    }

	    @PostMapping("/save-login")
	    public String saveLoginSubmission(Model model, LoginPOJO mylogin) {
	    	System.out.println(">>>>>> IN saveLoginSubmission");
	    	System.out.println(">>>>>> uname="+mylogin.getUname());
	    	System.out.println(">>>>>> pass ="+mylogin.getPassword());
	        // TODO: 
	    	model.addAttribute("mylogin", mylogin);
	        return "login-result";
	    }
	@ModelAttribute
	public GenderSelection selection() {
		return new GenderSelection(); // Initialize with default gender (optional)
	}

	@GetMapping("/radio-buttons")
	public String radioButtons(Model model) {
		GenderSelection selection = new GenderSelection();
		selection.setGender("Male");
		model.addAttribute("selection", selection);
		return "radio-buttons";
	}
	@PostMapping("/radio-selection")
	public String radioSelection(@RequestParam String gender, Model model) {
		System.out.println("===>> Selected gender: " + gender);
		// ... Add any additional logic or form processing here
		model.addAttribute("selectedGender", gender);
		return "radio-selection"; // Redirect or return view name
	}
}
