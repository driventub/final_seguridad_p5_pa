package uce.edu.final_seguridad_p5_pa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import uce.edu.final_seguridad_p5_pa.modelo.Usuario;
import uce.edu.final_seguridad_p5_pa.repository.IUsuarioRepo;


import static java.util.Collections.emptyList;
@Service
public class UsuarioServiceImpl implements UserDetailsService{

    @Autowired
    private IUsuarioRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = this.userRepo.consultarPorNombre(username);
        return new User(u.getNombre(), u.getPassword(), emptyList());
    }

}
