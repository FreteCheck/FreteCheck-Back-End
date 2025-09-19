package com.example.freteCheck.Service;

import com.example.freteCheck.Repository.nosql.FreteRepository;
import com.example.freteCheck.model.Frete;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FreteService {

    private final FreteRepository freteRepository;

    public void salvar(Frete frete) {
        freteRepository.save(frete);
    }

    public Optional<Frete> buscarPorId(String id) {
        return freteRepository.findById(id);
    }

    public List<Frete> listarTodos() {
        return freteRepository.findAll();
    }

    public void deletar(String id) {
        freteRepository.deleteById(id);
    }
}


