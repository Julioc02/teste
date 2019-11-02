package com.clj.monitoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.clj.monitoria.model.Aluno;
import com.clj.monitoria.model.Monitores;
import com.clj.monitoria.repository.Alunos;
import com.clj.monitoria.repository.Monitor;

@Controller
public class MonitoriaController {
	@Autowired
	Alunos alunos;
	@Autowired
	Monitor monitor;
		
    @GetMapping("/")
    public ModelAndView ListarHome() {
   	 ModelAndView modelAndView = new ModelAndView("index");
   	 modelAndView.addObject("Monitores", monitor.findAll());
   	 modelAndView.addObject(new Monitores());
   	 return modelAndView;
    }
    @PostMapping("/monitores")
    public String salvar(Monitores monitores) {
   	  monitor.save(monitores);
   	  return "redirect:/";
    }
    
    
    
   @GetMapping("/deletar/{id}")
   public String deletar(@PathVariable("id") Long id) {
   	monitor.deleteById(id);
   	return "redirect:/";
    }
   
   @GetMapping("/editarMonitor/{id}")
   public String editarMonitor(@PathVariable("id") Long id,  Model model) {
   	model.addAttribute("dados", monitor.findById(id));
   	return "editarMonitores";
    }

   
   
  
   
   
   
   
   @GetMapping("/alunos")
   public ModelAndView Listar() {
	   ModelAndView modelAndView = new ModelAndView("monitoria");
	   
	   modelAndView.addObject("Alunos", alunos.findAll());
	   modelAndView.addObject(new Aluno());
	   return modelAndView;
   }
   
   
   @PostMapping("/aluno")
   public String Salvar(Aluno aluno) {
	   this.alunos.save(aluno);
	   return "redirect:/alunos";
   }
   
   @GetMapping("/delete/{id}")
   public String delete(@PathVariable("id") Long id) {
  	alunos.deleteById(id);
  	return "redirect:/alunos";
   }
   
   @GetMapping("/editarAlunos/{id}")
   public String editarAlunos(@PathVariable("id") Long id,  Model model) {
   	model.addAttribute("dados", alunos.findById(id));
   	return "editarAlunos";
    }
}
