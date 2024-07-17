package com.example.thymeleafformdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SimpleController {

		@GetMapping("/displayCss")
		public String showForm(){
			System.out.println("Show the Form!!");
			return("HelloCss");
		}
	@GetMapping("/getproducts")
	public String showForm2(){
		System.out.println("Show the Form!!");
		return("getprodBS");
	}
	@GetMapping("/addproducts")
	public String showForm3(){
		System.out.println("Show create-product Form!!");
		return("create-product");
	}
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

	@GetMapping("/greeting")
	public String greeting(Model model) {
		//model.addAttribute("greetingMessage", "Hello from Spring and Thymeleaf!");
		return "greeting";
	}

	@RequestMapping(value = "/greeting/message", method = RequestMethod.GET)
	public String getGreetingMessage(Model model) {
		model.addAttribute("greetingMessage", "Hello from Spring and Thymeleaf!");
		return "greetingMessage"; // Return a simple template with only the message
	}


}
