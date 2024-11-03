/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.cap2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author miguel
 */
@Controller
public class SaludoController {
    /*
    @RequestMapping("saludo")
    public String saludar(Model modelo){
        modelo.addAttribute("mensaje", "Bienvenido desde el Controlador");
        return "saludo";
    }
*/
    /*
    @RequestMapping("saludo")
    public ModelAndView saludar(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("mensaje", "Bienvenido desde el controlador MVC");
        return mv;
    }
*/
    @RequestMapping("saludo")
    public ModelAndView saludar(){
        return new ModelAndView("saludo","mensaje","Bienvenido desde el controlador MV");
    }
    
}
