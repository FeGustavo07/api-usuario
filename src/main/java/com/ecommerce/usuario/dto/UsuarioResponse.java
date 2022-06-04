package com.ecommerce.usuario.dto;

import com.ecommerce.usuario.domains.Usuario;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UsuarioResponse {
    private Long id;
    private String nome;
    private String email;
    private int telefone;

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.nome = usuario.getNome();
        this.telefone = usuario.getTelefone();
    }

    public static List<UsuarioResponse> toResponse(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioResponse::new).collect(Collectors.toList());
    }
}
