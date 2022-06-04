package com.ecommerce.usuario.controllers;

import com.ecommerce.usuario.dto.UsuarioRequest;
import com.ecommerce.usuario.dto.UsuarioResponse;
import com.ecommerce.usuario.services.ServiceUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final ServiceUsuario serviceUsuario;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse criar(@RequestBody UsuarioRequest usuarioRequest) {
        return serviceUsuario.criar(usuarioRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse mostrar(@PathVariable Long id) {
        return serviceUsuario.mostrar(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioResponse> mostrarTodos() {
        return serviceUsuario.mostrarTodos();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse atualizar(@PathVariable Long id, @RequestBody UsuarioRequest usuarioRequest) {
        return serviceUsuario.atualizar(id, usuarioRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id) {
        serviceUsuario.deletar(id);
    }


}
