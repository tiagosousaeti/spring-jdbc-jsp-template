package br.eti.tiagosousa.springjdbcjsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.eti.tiagosousa.springjdbcjsp.repository.ProductRepository;

@Controller
public class HomeController {
	
	@Autowired
    private ProductRepository productRepository;
	
	@RequestMapping("/")
	public ModelAndView exibirHome(){
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("produtos", productRepository.buscar());
		return mv;
	}
}