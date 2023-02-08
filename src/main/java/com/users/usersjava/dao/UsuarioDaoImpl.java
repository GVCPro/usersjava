package com.users.usersjava.dao;

import com.users.usersjava.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios(){
        List<Usuario> lista;
        String query = "FROM Usuario";
        lista = entityManager.createQuery(query).getResultList();
        return lista;
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public Usuario getUsuario(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        return usuario;
    }


}
