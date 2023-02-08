package com.users.usersjava.dao;


import com.users.usersjava.model.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void registrarUsuario(Usuario usuario);

    void eliminarUsuario(Long id);

    Usuario getUsuario(Long id);
}
