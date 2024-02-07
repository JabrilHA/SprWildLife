package com.ipartek.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Especie;
import com.ipartek.model.Mascota;
import com.ipartek.model.Provincia;
import com.ipartek.repository.EspecieRepository;
import com.ipartek.repository.MascotaRepository;
import com.ipartek.repository.ProvinciaRepository;


@Controller
public class AdminController {
	@Autowired
	private EspecieRepository especieRepo;
	
	@Autowired
	private ProvinciaRepository provinciaRepo;
	
	@Autowired
	private MascotaRepository mascotaRepo;
	
	@RequestMapping("/admin")
	public String cargarAdmin(Model model){
		List<Especie> listaEspecie = especieRepo.findAll();
		List<Provincia> listaProvincia = provinciaRepo.findAll();
		List<Mascota> listaMascotas = mascotaRepo.findAll();
		
		model.addAttribute("atr_lista_especies",listaEspecie);
		model.addAttribute("atr_lista_provincias",listaProvincia);
		model.addAttribute("atr_lista_mascotas",listaMascotas);
		
		model.addAttribute("objeto_entidad", new Mascota());
		
		
		return "administracion";
	}
	
	@RequestMapping("/guardarMascota")
	public String guardarMascota(@ModelAttribute Mascota objeto_entidad){
		mascotaRepo.save(objeto_entidad);
		return "redirect:/admin";
	}
	
	@RequestMapping("/modificacionMascotaCreada")
	public String modificacionMascotaCreada(@ModelAttribute Mascota objeto_entidad) {
		mascotaRepo.save(objeto_entidad);
		
		return "redirect:/admin";
	}
	
	
	@RequestMapping("/eliminarMascota/{id}")
	public String eliminarMascota(@PathVariable int id) {
		mascotaRepo.deleteById(id);
		
		return "redirect:/admin";
	}
	
	@RequestMapping("/modificarMascota/{id}")
	public String modificarMascota(Model model,@PathVariable int id) {
		Optional<Mascota> mascota = mascotaRepo.findById(id);
		
		List<Especie> listaEspecie = especieRepo.findAll();
		List<Provincia> listaProvincia = provinciaRepo.findAll();
		
		
		model.addAttribute("atr_lista_especies",listaEspecie);
		model.addAttribute("atr_lista_provincias",listaProvincia);
		model.addAttribute("mascota", mascota);
		
		
		return "modificar";
	}
	
	@RequestMapping("/backupCSV")
	public String realizarBackupCSV() {
		List<Especie> datosespecie = especieRepo.findAll();
		List<Provincia> datosProvincia =provinciaRepo.findAll();
		List<Mascota> datosMascota = mascotaRepo.findAll();
		
		try {
			FileWriter especies = new FileWriter("C:\\CopiaSeguridad\\Spr_especies.csv");	
			for (Especie especie : datosespecie) {
				especies.append(especie.toCSV()).append("\n");
			}
			
			especies.close();
			
			FileWriter provincias = new FileWriter("C:\\CopiaSeguridad\\Spr_provincias.csv");
			for (Provincia provincia : datosProvincia) {
				provincias.append(provincia.toCSV()).append("\n");
			}
			
			provincias.close();
			
			FileWriter mascotas = new FileWriter("C:\\CopiaSeguridad\\Spr_mascotas.csv");
			for (Mascota mascota : datosMascota) {
				mascotas.append(mascota.toCSV()).append("\n");
			}
			
			mascotas.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/admin";
	}
	
	@RequestMapping("/restaurarBackupCSV")
	public String restaurarBackupCSV() {
		
		return"redirect:/admin";
	}

}
