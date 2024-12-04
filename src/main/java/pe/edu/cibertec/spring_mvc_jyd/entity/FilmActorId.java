package pe.edu.cibertec.spring_mvc_jyd.entity;


import lombok.Data;

import java.io.Serializable;

// Clase auxiliar para la clave compuesta
@Data
public class FilmActorId implements Serializable {
    private Integer actor;
    private Integer film;
}
