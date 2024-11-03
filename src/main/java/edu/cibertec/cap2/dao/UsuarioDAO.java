
package edu.cibertec.cap2.dao;

import edu.cibertec.cap2.model.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO {
    
    private List<UsuarioDTO> listaUsuarios;
    
    public UsuarioDAO(){
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new UsuarioDTO("jose", "12345","José Perez",null));
        listaUsuarios.add(new UsuarioDTO("maria", "12345","Maria Lujan",null));
        listaUsuarios.add(new UsuarioDTO("luis", "12345","Luis Soto",null));
        //comentario aqui.
    }
    
    public void insertarUsuario(UsuarioDTO usuario){
        listaUsuarios.add(usuario);
    }
    
    public List<UsuarioDTO> getListarUsuarios(){
        return listaUsuarios;
    }
    
    public UsuarioDTO validarLogin(UsuarioDTO usuario){
        
        if (usuario.getUsuario().equalsIgnoreCase("user") && usuario.getClave().equals("12345"))
            usuario.setNombreCompleto("Pepito Silva");
        else
            usuario = null;
        
        return usuario;
    }
    
    public UsuarioDTO getUsuario(String codigo){
        UsuarioDTO rpta = null;
        for (UsuarioDTO usuario : listaUsuarios){
            if(usuario.getUsuario().equalsIgnoreCase(codigo)){
                rpta = usuario;
                break;
            }
        }
        return rpta;
    }
    
}
