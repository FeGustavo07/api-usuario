package com.ecommerce.usuario.services;

import com.ecommerce.usuario.dto.UsuarioRequest;
import com.ecommerce.usuario.dto.UsuarioResponse;

import java.util.List;

public interface ServiceUsuario {

    UsuarioResponse criar(UsuarioRequest usuarioRequest);
    UsuarioResponse mostrar(Long id);
    List<UsuarioResponse> mostrarTodos();
    UsuarioResponse atualizar(Long id, UsuarioRequest usuarioRequest);
    void deletar(Long id);

}
