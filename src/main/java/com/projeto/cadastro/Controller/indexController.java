package com.projeto.cadastro.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.cadastro.CadastroRepository;

@Controller
public class indexController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
