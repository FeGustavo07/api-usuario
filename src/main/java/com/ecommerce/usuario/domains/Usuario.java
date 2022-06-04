package com.ecommerce.usuario.domains;

import com.ecommerce.usuario.dto.UsuarioRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private String cpf;

    @Column
    private int telefone;

    public Usuario(UsuarioRequest usuarioRequest) {
        this.nome = usuarioRequest.getNome();
        this.cpf = usuarioRequest.getCpf();
        this.senha = usuarioRequest.getSenha();
        this.telefone = usuarioRequest.getTelefone();
        this.email = usuarioRequest.getEmail();
    }
}
