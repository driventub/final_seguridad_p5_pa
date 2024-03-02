package uce.edu.final_seguridad_p5_pa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import uce.edu.final_seguridad_p5_pa.modelo.Usuario;

@Repository
@Transactional
public class UsuarioRepoImpl implements IUsuarioRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Usuario consultarPorNombre(String nombre) {

        TypedQuery<Usuario> myQuery = this.em
                .createQuery("SELECT u FROM Usuario u WHERE u.nombre = :nombre", Usuario.class)
                .setParameter("nombre", nombre);
        return myQuery.getSingleResult();
    }
    
}
