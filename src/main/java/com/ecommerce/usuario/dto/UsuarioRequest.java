package com.ecommerce.usuario.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioRequest {
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private int telefone;
}