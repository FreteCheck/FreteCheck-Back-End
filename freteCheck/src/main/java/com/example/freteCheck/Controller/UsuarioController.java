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
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.cadastrar(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        try {
            Usuario usuarioAutenticado = usuarioService.autenticar(loginRequest);
            return ResponseEntity.ok(Map.of("message", "Login bem-sucedido!"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(Map.of("message", e.getMessage()));
        }
    }
}
