package com.example.freteCheck.Controller;

import com.example.freteCheck.Dto.LoginRequestDTO;
import com.example.freteCheck.model.Usuario;
import com.example.freteCheck.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController implements UsuarioControllerDocs {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @PostMapping
    public Usuario cadastrar(@org.springframework.web.bind.annotation.RequestBody Usuario usuario) {
        return usuarioService.cadastrar(usuario);
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<?> login(@org.springframework.web.bind.annotation.RequestBody LoginRequestDTO loginRequest) {
        try {
            Usuario usuarioAutenticado = usuarioService.autenticar(loginRequest);
            return ResponseEntity.ok(Map.of("message", "Login bem-sucedido!"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(Map.of("message", e.getMessage()));
        }
    }
}