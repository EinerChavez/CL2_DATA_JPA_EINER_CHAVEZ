package pe.edu.cibertec.spring_mvc_jyd.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.spring_mvc_jyd.entity.FilmActor;
import pe.edu.cibertec.spring_mvc_jyd.entity.FilmActorId;

public interface FilmActorRepository extends CrudRepository<FilmActor, FilmActorId> {
}
