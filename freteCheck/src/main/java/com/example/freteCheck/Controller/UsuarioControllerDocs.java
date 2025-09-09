package com.example.freteCheck.Controller;

import com.example.freteCheck.Dto.LoginRequestDTO;
import com.example.freteCheck.model.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Usuários 👤", description = "Endpoints para gerenciamento de usuários e autenticação")
public interface UsuarioControllerDocs {

    @Operation(summary = "Cadastra um novo usuário 📝", description = "Cria um novo usuário no sistema com base nos dados fornecidos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário cadastrado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    Usuario cadastrar(Usuario usuario);

    @Operation(summary = "Autentica um usuário 🔑", description = "Valida as credenciais (email e senha) e retorna uma mensagem de sucesso ou falha.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login bem-sucedido"),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas ou não autorizadas")
    })
    ResponseEntity<?> login(LoginRequestDTO loginRequest);
}
