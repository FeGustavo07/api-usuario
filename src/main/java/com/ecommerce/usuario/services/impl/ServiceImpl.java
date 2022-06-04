package com.ecommerce.usuario.services.impl;

import com.ecommerce.usuario.domains.Usuario;
import com.ecommerce.usuario.dto.UsuarioRequest;
import com.ecommerce.usuario.dto.UsuarioResponse;
import com.ecommerce.usuario.repositories.UsuarioRepository;
import com.ecommerce.usuario.services.ServiceUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements ServiceUsuario {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponse criar(UsuarioRequest usuarioRequest) {
        var usuario = new Usuario(usuarioRequest);
        usuarioRepository.save(usuario);
        return new UsuarioResponse(usuario);
    }

    @Override
    public UsuarioResponse mostrar(Long id) {
        var usuario = usuarioRepository.findById(id).orElseThrow();
        return new UsuarioResponse(usuario);
    }

    @Override
    public List<UsuarioResponse> mostrarTodos() {
        return UsuarioResponse.toResponse(
            usuarioRepository.findAll()
        );
    }

    @Override
    public UsuarioResponse atualizar(Long id, UsuarioRequest usuarioRequest) {
        var usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setSenha(usuarioRequest.getSenha());
        usuario.setTelefone(usuarioRequest.getTelefone());
        usuario.setEmail(usuarioRequest.getEmail());
        return new UsuarioResponse(usuario);
    }

    @Override
    public void deletar(Long id) {
        var usuario = usuarioRepository.findById(id).orElseThrow();
        usuarioRepository.delete(usuario);
    }
}
