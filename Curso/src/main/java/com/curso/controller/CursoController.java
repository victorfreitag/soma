package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.entities.Curso;
import com.curso.service.CursoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name= "Curso",description = "API REST DE GERENCIAMENTO DE USUÁRIOS")
@RestController
@RequestMapping("/curso")
public class CursoController {
	
private final CursoService cursoService;
	
	@Autowired
	public CursoController(CursoService cursooService) {
		this.cursoService = cursooService;
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Localiza usuario por ID")
	public ResponseEntity<Curso> buscarId(@PathVariable Long id){
		Curso curso = cursoService.buscarId(id);
		if(curso != null) {
			return ResponseEntity.ok(curso);
		}
		else {
			return ResponseEntity.notFound().build();
		}}
	
		@GetMapping("/")
		@Operation(summary = "Apresenta todos os usuarios")
		public ResponseEntity <List<Curso>> buscartodos(){
		List<Curso> curso = cursoService.buscarTodos();
		return ResponseEntity.ok(curso);
	}
		@PostMapping("/")
		@Operation(summary = "Inserindo Dados")
		public ResponseEntity<Curso>salvar(@RequestBody @Valid Curso curso){
			Curso salvar = cursoService.salvar(curso);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
		}
		@PutMapping("/")
		@Operation(summary = "Aterando Dados")
		public ResponseEntity<Curso> alterar(@PathVariable Long id, @RequestBody @Valid Curso curso){
			Curso alterar = cursoService.alterar(id, curso);
			if(alterar !=null) {
				return ResponseEntity.ok(curso);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
			@DeleteMapping("/{id}")
			@Operation(summary = "Deletando Dados")
			public ResponseEntity<Curso> apagar(@PathVariable Long id){
				boolean apagar = cursoService.apagar(id);
				if(apagar) {
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				}
				else {
					return ResponseEntity.notFound().build();
				}
			}
		}
	


