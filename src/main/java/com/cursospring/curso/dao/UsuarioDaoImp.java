package com.cursospring.curso.dao;

import com.cursospring.curso.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //hace referencia a la conexión con la BD
@Transactional //poder armar consultas sql a la bd
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager; //hacer conexión con la bd

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }
}
