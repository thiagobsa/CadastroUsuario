package com.projeto.cadastro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.cadastro.CadastroRepository;
import com.projeto.cadastro.TelefoneRepository;
import com.projeto.cadastro.model.Cadastro;
import com.projeto.cadastro.model.Telefones;


@Component
@Controller
public class CadastroController {
	
	@Autowired
	private CadastroRepository cr;
	@Autowired
	private TelefoneRepository tr;
	
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.GET)
	public String form() {
		return "formCadastro";
	}
	
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.POST)
	public String form(Cadastro cadastro) {
		
		cr.save(cadastro);
		
		return "redirect:/cadastrarUsuario";
	}
	
	@RequestMapping("/cadastros")
	public ModelAndView listaCadastro() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Cadastro> cadastros = cr.findAll();
		mv.addObject("cadastros", cadastros);
		return mv;
	}
	
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesUsuario(@PathVariable("codigo") long codigo) {
		Cadastro cadastro = cr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("detalhesCadastro");
		mv.addObject("cadastros", cadastro);
		return mv;
	}
	
	@RequestMapping("/deletar")
	public String deletarUsuario(long codigo) {
		Cadastro cadastro = cr.findByCodigo(codigo);
		cr.delete(cadastro);
		return "redirect:/cadastros";
	}
	
	/*
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesUsuario(@PathVariable("codigo") long codigo, Telefones telefone) {
		Cadastro cadastro = cr.findByCodigo(codigo);
		telefone.setCadastro(cadastro);
		tr.save(telefone);
		
		return "Redirect:/{codigo}";
	}
	*/
}
