package br.eti.tiagosousa.springjdbcjsp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.eti.tiagosousa.springjdbcjsp.model.Product;
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
	
	@RequestMapping("/adicionar")
	public ModelAndView exibirAdicionar(Product produto){
		return new ModelAndView("adicionar");
	}
	
	@RequestMapping(value = "/alterar", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
	    Integer id = Integer.parseInt(request.getParameter("id"));
	    Product produto = productRepository.buscarPorId(id);
	    ModelAndView model = new ModelAndView("adicionar");
	    model.addObject("product", produto);
	 
	    return model;
	}
	
	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
	public ModelAndView excluir(HttpServletRequest request) {
	    Integer id = Integer.parseInt(request.getParameter("id"));
	    productRepository.excluir(id);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Product produto) {
		productRepository.salvar(produto);
	    return new ModelAndView("redirect:/");
	}
}