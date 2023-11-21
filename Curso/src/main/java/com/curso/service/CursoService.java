package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.entities.Curso;
import com.curso.repository.CursoRepository;

@Service
public class CursoService {
	private CursoRepository cursoRepository;
	
	@Autowired
	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	public List<Curso> buscarTodos(){
	return cursoRepository.findAll();
	}
	public Curso buscarId(Long id) {
		Optional <Curso> curso = cursoRepository.findById(id);
		return curso.orElse(null);
	}
	public Curso salvar(Curso curso) {
		return cursoRepository.save(curso);
	}
	public Curso alterar(Long id, Curso alterarprod) {
		Optional <Curso> existe  = cursoRepository.findById(id);
		if(existe.isPresent()) {
			alterarprod.setId(id);
			return cursoRepository.save(alterarprod);
		}
		return null;
	}
	public boolean apagar(Long id) {
		Optional <Curso> existe = cursoRepository.findById(id);
		if(existe.isPresent()) {
			cursoRepository.deleteById(id);
			return true;
		}
				
		return false;
	}

}


