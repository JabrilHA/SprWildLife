package com.ipartek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Mascota;
import com.ipartek.repository.MascotaRepository;

@Controller
public class MenuController {
	
	@Autowired
	private MascotaRepository mascotaRepo;
	
	@RequestMapping("/menu_inicio")
	public String menu_inicio() {
		
		return "redirect:/";
	}
	
	@RequestMapping("/menu_perros")
	public String menu_perros(Model model) {
		List<Mascota> listaMascotas = mascotaRepo.obtenerMascotaPorEspecie(1);
		
		model.addAttribute("atr_lista_mascotas", listaMascotas);
		
		
		return "perros";
	}
	
	@RequestMapping("/menu_gatos")
	public String menu_gatos(Model model) {
		List<Mascota> listaMascotas = mascotaRepo.obtenerMascotaPorEspecie(2);
		
		model.addAttribute("atr_lista_mascotas",listaMascotas);
		return"gatos";
	}
	
	@RequestMapping("/menu_conejos")
	public String menu_conejos(Model model) {
		List<Mascota> listaMascotas = mascotaRepo.obtenerMascotaPorEspecie(3);
		
		model.addAttribute("atr_lista_mascotas",listaMascotas);
		return"conejos";
	}
	
	@RequestMapping("/menu_pajaros")
	public String menu_pajaros(Model model) {
		List<Mascota> listaMascotas = mascotaRepo.obtenerMascotaPorEspecie(4);
		
		model.addAttribute("atr_lista_mascotas",listaMascotas);
		return"pajaros";
	}
	
	@RequestMapping("/menu_tortugas")
	public String menu_tortugas(Model model) {
		List<Mascota> listaMascotas = mascotaRepo.obtenerMascotaPorEspecie(5);
		
		model.addAttribute("atr_lista_mascotas",listaMascotas);
		return"tortugas";
	}

}
