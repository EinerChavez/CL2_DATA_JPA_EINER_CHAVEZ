package pe.edu.cibertec.spring_mvc_jyd.service;

import pe.edu.cibertec.spring_mvc_jyd.dto.FilmData;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDetailDto;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> findAllFilms();

    FilmDetailDto findDetailById(Integer id);

    void createFilm(FilmData filmData);

    Boolean updateFilm(FilmDetailDto filmDetailDto);

    Boolean deleteFilm(Integer id);
}
