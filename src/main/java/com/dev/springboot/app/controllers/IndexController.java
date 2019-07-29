package com.dev.springboot.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.springboot.app.models.Users;

@Controller
@RequestMapping("/app")
public class IndexController {
	/*
	 * @RequestMapping(value = "/index", method = RequestMethod.GET) Seen in view of
	 * Java public String index(ModelMap model) ó public String index(Map<String,
	 * Object> map) map.put("title", "Example the title") public ModelAndView
	 * index(ModelAndView model) model.addObject() model.setViewName() return model
	 */
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Users> listUsers = new ArrayList<>();
		List<Users> usuarios = Arrays.asList(new Users("José", "Son", "json@unbosque.edu.co"),
				new Users("Armando", "Rojas", "jason3@misena.edu.co"),
				new Users("Karina", "Agredo", "karito@hotmail.com"));
 		listUsers.add(new Users("José", "Son", "json@unbosque.edu.co"));
		listUsers.add(new Users("Armando", "Rojas", "jason3@misena.edu.co"));
		listUsers.add(new Users("Karina", "Agredo", "karito@hotmail.com"));
		model.addAttribute("title", "Listado de Usuarios: ");
		model.addAttribute("listUsers", listUsers);
		return "listar";
	}

	@GetMapping({ "/", "/home", "/index", "" })
	public String index(Model model) {
		model.addAttribute("title", "Hello Spring FrameWork!");
		return "index";
	}

	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public String perfil(Model model) {
		Users user = new Users();
		user.setNombre("Jose");
		user.setApellido("Son");
		user.setEmail("son-rj@hotmail.com");
		model.addAttribute("user", user);
		model.addAttribute("title", "Perfil de Usuario: ".concat(user.getNombre()));
		return "perfil";
	}

}
