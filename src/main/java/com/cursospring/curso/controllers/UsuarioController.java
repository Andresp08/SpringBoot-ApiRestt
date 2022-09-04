package com.cursospring.curso.controllers;

import com.cursospring.curso.dao.UsuarioDao;
import com.cursospring.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController //indicar que es un contralador
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    //para indicar la url que devuelve el contenido
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id) {

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Andrés");
        usuario.setApellido("Pardo");
        usuario.setEmail("Andresp@gmail.com");
        usuario.setTelefono("33330");
        usuario.setPassword("mypass");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        usuarioDao.registrar(usuario); //request body convierte el json que recibe a un Usuario
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminar(id);
    }

}
