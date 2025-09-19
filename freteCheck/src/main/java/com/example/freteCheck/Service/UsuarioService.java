package com.example.freteCheck.Service;

import com.example.freteCheck.Dto.LoginRequestDTO;
import com.example.freteCheck.model.Usuario;
import com.example.freteCheck.Repository.sql.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Usuario cadastrar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Usuario autenticar(LoginRequestDTO loginRequest) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(loginRequest.email());
        if (usuarioOpt.isPresent() && passwordEncoder.matches(loginRequest.senha(), usuarioOpt.get().getSenha())) {
            return usuarioOpt.get();
        }
        throw new RuntimeException("Email ou senha inválidos.");
    }
}
