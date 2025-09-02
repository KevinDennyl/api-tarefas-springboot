package br.com.kevin.apitarefas.controller;

import br.com.kevin.apitarefas.model.Tarefa;
import br.com.kevin.apitarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
	
	@Autowired
	private TarefaRepository repository;
	
	// Criar tarefa
	@PostMapping
	public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
		return repository.save(tarefa);
	}
	
	//Listar todas as tarefas
	@GetMapping
	public List<Tarefa> listarTarefas() {
		return repository.findAll();
	}
	
	//Buscar tarefa por ID
	@GetMapping("id")
	public ResponseEntity<Tarefa> buscarTarefa(@PathVariable Long id) {
		Optional<Tarefa> tarefa = repository.findById(id);
		return tarefa.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Atualizar tarefa
	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
		return repository.findById(id)
				.map(tarefa -> {
					tarefa.setNome(tarefaAtualizada.getNome());
					tarefa.setDataEntrega(tarefaAtualizada.getDataEntrega());
					tarefa.setResponsavel(tarefaAtualizada.getResponsavel());
					Tarefa atualizada = repository.save(tarefa);
					return ResponseEntity.ok(atualizada);
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Deletar tarefa
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarTarefa(@PathVariable Long id) {
		return repository.findById(id)
				.map(tarefa ->{
					repository.delete(tarefa);
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
