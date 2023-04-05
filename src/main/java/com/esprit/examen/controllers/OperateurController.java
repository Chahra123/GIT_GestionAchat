package com.esprit.examen.controllers;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.services.IOperateurService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Gestion des opérateurs")
@RequestMapping("/operateur")
@RequiredArgsConstructor
public class OperateurController {


	private final IOperateurService operateurService;






	@PutMapping
	public Operateur modifyOperateur(@RequestBody Operateur operateur) {
		return operateurService.updateOperateur(operateur);
	}

	
}
