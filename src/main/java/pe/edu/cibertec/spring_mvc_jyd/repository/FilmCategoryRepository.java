package pe.edu.cibertec.spring_mvc_jyd.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.spring_mvc_jyd.entity.FilmCategory;
import pe.edu.cibertec.spring_mvc_jyd.entity.FilmCategoryId;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory, FilmCategoryId> {
}
