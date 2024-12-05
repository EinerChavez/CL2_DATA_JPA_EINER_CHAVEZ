package pe.edu.cibertec.spring_mvc_jyd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class FilmCategoryId implements Serializable {
    @Column(name = "film_id")
    private Integer film;

    @Column(name = "category_id")
    private Integer category;

    public FilmCategoryId() {
    }

    public FilmCategoryId(Integer film, Integer category) {
        this.film = film;
        this.category = category;
    }

    public Integer getFilm() {
        return film;
    }

    public void setFilm(Integer film) {
        this.film = film;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
