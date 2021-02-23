package com.renato.biblioteca.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renato.biblioteca.domain.Apostador;
import com.renato.biblioteca.dto.ApostadorDTO;
import com.renato.biblioteca.services.ApostadorService;

@RestController
@RequestMapping(value = "/apostadores")
public class ApostadorResource {

	@Autowired
	private ApostadorService apostadorService;
	
	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public ResponseEntity<Apostador> buscar(@PathVariable String email){
		Apostador apostador = apostadorService.buscar(email);
		return ResponseEntity.ok().body(apostador);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> cadastrarApostador(@RequestBody ApostadorDTO apostadorDto){
		Apostador apostador = apostadorService.fromDto(apostadorDto);
		apostadorService.salvar(apostador);
		return ResponseEntity.noContent().build();
	}
}
