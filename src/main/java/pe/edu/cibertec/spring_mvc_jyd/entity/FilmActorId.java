package pe.edu.cibertec.spring_mvc_jyd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class FilmActorId implements Serializable {
    @Column(name = "actor_id")
    private Integer actor;

    @Column(name = "film_id")
    private Integer film;

    public FilmActorId() {
    }

    public FilmActorId(Integer actor, Integer film) {
        this.actor = actor;
        this.film = film;
    }

    public Integer getActor() {
        return actor;
    }

    public void setActor(Integer actor) {
        this.actor = actor;
    }

    public Integer getFilm() {
        return film;
    }

    public void setFilm(Integer film) {
        this.film = film;
    }
}
