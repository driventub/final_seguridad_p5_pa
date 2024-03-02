package uce.edu.final_seguridad_p5_pa.repository;

import uce.edu.final_seguridad_p5_pa.modelo.Usuario;

public interface IUsuarioRepo {
    public Usuario consultarPorNombre(String nombre);
    
}
