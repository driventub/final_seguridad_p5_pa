package uce.edu.final_seguridad_p5_pa.service.to;


import java.io.Serializable;

public class UsuarioTO implements Serializable {
    private String nombre,password, semilla;
    private Integer tiempoExp;

    

    public String getSemilla() {
        return semilla;
    }

    public void setSemilla(String semilla) {
        this.semilla = semilla;
    }

    public Integer getTiempoExp() {
        return tiempoExp;
    }

    public void setTiempoExp(Integer tiempoExp) {
        this.tiempoExp = tiempoExp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
