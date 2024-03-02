package uce.edu.final_seguridad_p5_pa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.final_seguridad_p5_pa.security.JwtUtils;
import uce.edu.final_seguridad_p5_pa.service.to.UsuarioTO;


@RestController
@RequestMapping("autorizaciones")
@CrossOrigin
public class AuthorizationControllerRestful {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtils utils;
  
     
    @PostMapping(path = "jwt", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String consultarToken(@RequestBody UsuarioTO user){
        this.autenticacion(user.getNombre(),user.getPassword());
        return this.utils.buildTokenJwt(user.getNombre(), user.getSemilla(), user.getTiempoExp());
    }

    private void autenticacion(String usuario, String password){
        UsernamePasswordAuthenticationToken usuarioToken = new UsernamePasswordAuthenticationToken(usuario, password);
        Authentication auth = this.authManager.authenticate(usuarioToken);
        SecurityContextHolder.getContext().setAuthentication(auth); 
    }


    
}
