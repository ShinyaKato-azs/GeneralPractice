package com.example.Vegetables.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Vegetables.Form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SignupController {

	@GetMapping("/signup")

	public String getSignup(@ModelAttribute SignupForm form) {

		return ("user/signup");
	}

	@PostMapping("/signup")

	public String postSignup(@ModelAttribute SignupForm form) {

		//登録処理

		//ログ出力
		log.info(form.toString());

		return "redirect:/signup";
	}

}