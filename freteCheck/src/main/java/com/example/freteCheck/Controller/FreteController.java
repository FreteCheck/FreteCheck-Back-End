package com.example.freteCheck.Controller;


import com.example.freteCheck.Service.FreteService;
import com.example.freteCheck.model.Frete;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fretes")
@RequiredArgsConstructor
public class FreteController {

    private final FreteService freteService;

    @GetMapping
    public ResponseEntity<List<Frete>> listarTodos() {
        return ResponseEntity.ok(freteService.listarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Frete> buscarPorId(@PathVariable String id) {
        return freteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Frete> criar(@RequestBody Frete frete) {
        Frete salvo = freteService.salvar(frete);
        return ResponseEntity.ok(salvo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Frete> atualizar(@PathVariable String id, @RequestBody Frete frete) {
        return freteService.buscarPorId(id)
                .map(existente -> {
                    frete.setId(id);
                    Frete atualizado = freteService.salvar(frete);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        freteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
