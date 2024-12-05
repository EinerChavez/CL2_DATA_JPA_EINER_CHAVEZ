package pe.edu.cibertec.spring_mvc_jyd.repository;

import jakarta.persistence.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.spring_mvc_jyd.entity.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {

}
