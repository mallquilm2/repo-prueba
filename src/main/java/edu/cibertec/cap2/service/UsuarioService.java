/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.cap2.service;

import edu.cibertec.cap2.dao.UsuarioDAO;
import edu.cibertec.cap2.model.UsuarioDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    public void insertarUsuario(UsuarioDTO usuario){
        usuarioDAO.insertarUsuario(usuario);
    }
    
    public List<UsuarioDTO> getListaUsuarios(){
        return usuarioDAO.getListarUsuarios();
    }
    
    public UsuarioDTO validarLogin(UsuarioDTO usuario){
        return usuarioDAO.validarLogin(usuario);
    }
    
    public UsuarioDTO getUsuario(String codigo){
        return usuarioDAO.getUsuario(codigo);
    }
    
}
