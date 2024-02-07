package com.ipartek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Mascota;
import com.ipartek.repository.MascotaRepository;



@Controller
public class MainController {
	
	@Autowired
	private MascotaRepository mascotaRepo;
	
	@RequestMapping("/")
	public String cargarInicio(Model model) {
		List<Mascota> listaMascotas = mascotaRepo.findAll();
		
		//COMPROBACION
		for (Mascota mascota : listaMascotas) {
			System.out.println(mascota);
		}
		
		model.addAttribute("atr_lista_mascotas", listaMascotas);
		return "home";
	}

}
