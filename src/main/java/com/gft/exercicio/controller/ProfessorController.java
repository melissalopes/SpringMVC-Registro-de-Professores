package com.gft.exercicio.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.exercicio.model.Professor;
import com.gft.exercicio.model.StatusProfessor;
import com.gft.exercicio.repository.ProfessorRepository;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
	
	private static final String CADASTRO_VIEW = "CadastroProfessor";
	
	@Autowired
	private ProfessorRepository todosProfessores;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Professor> professores = todosProfessores.findAll();
		ModelAndView mv = new ModelAndView("PesquisaProfessores");
		mv.addObject("professores", professores);
		return mv; 
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Professor());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Professor professor, Errors errors) {
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		todosProfessores.save(professor);
		return "redirect:/professores/novo";
	}
	
	@RequestMapping(value="{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Professor professor) {		
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(professor);                              
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo) {  
		todosProfessores.deleteById(codigo);	
		return "redirect:/professores";
	}
	
	@ModelAttribute("todosStatusProfessor")
	public List<StatusProfessor> todosStatusProfessor(){
		return Arrays.asList(StatusProfessor.values());
	}
}
