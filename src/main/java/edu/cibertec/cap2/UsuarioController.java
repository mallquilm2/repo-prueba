/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.cap2;

import edu.cibertec.cap2.model.UsuarioDTO;
import edu.cibertec.cap2.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping("usuarioCrear")
    public ModelAndView crearUsuario(){
        return new ModelAndView("usuarioDatos", "usuarioBean", new UsuarioDTO());
    }
    
    @RequestMapping("usuarioGrabar")
    public ModelAndView grabarUsuario(@Valid @ModelAttribute("usuarioBean") UsuarioDTO usuario, BindingResult resulta){
        
        ModelAndView mv = null;
        if(resulta.hasErrors()){
            mv = new ModelAndView("usuario", "usuarioBean", usuario);
        }else{
            usuarioService.insertarUsuario(usuario);
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.getListaUsuarios());
        }
        return mv;
    }

    @RequestMapping("loginMostrar")
    public String loginMostrar() {
        return "login";
    }

    @RequestMapping("loginAccion")
    public ModelAndView loginAccion(UsuarioDTO usuariovalida) {
        ModelAndView mv = null;
        
        UsuarioDTO ue = usuarioService.validarLogin(usuariovalida);
        if (ue == null) {
            mv = new ModelAndView("login", "msgError", "Usuario y clave no existen. Vuelva a intentar!");
        } else {
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.getListaUsuarios());
        }
        return mv;
    }
    
    @RequestMapping("fotoMostrar")
    public String fotoMostrar(@RequestParam("codigoUsuario") String codigoUsuario, Model modelo){
        UsuarioDTO usuario = usuarioService.getUsuario(codigoUsuario);
        modelo.addAttribute("usuario", usuario);
        return "fotoUsuario";
    }
    
    @RequestMapping("fotoGrabar")
    public ModelAndView fotoGrabar(@RequestParam("archivo") CommonsMultipartFile archivo, @RequestParam("codigoUsuario") String codigoUsuario){
        UsuarioDTO usuario = usuarioService.getUsuario(codigoUsuario);
        usuario.setFoto(archivo.getBytes());
        return new ModelAndView("usuarioLista", "lista", usuarioService.getListaUsuarios());
    }

}
