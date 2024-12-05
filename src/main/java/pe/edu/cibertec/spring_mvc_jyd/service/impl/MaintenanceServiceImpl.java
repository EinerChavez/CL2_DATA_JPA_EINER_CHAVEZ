package pe.edu.cibertec.spring_mvc_jyd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmData;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDetailDto;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDto;
import pe.edu.cibertec.spring_mvc_jyd.entity.Film;
import pe.edu.cibertec.spring_mvc_jyd.entity.Language;
import pe.edu.cibertec.spring_mvc_jyd.repository.FilmRepository;
import pe.edu.cibertec.spring_mvc_jyd.repository.LanguageRepository;
import pe.edu.cibertec.spring_mvc_jyd.service.MaintenanceService;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Cacheable(value = "films")
    @Override
    public List<FilmDto> findAllFilms() {
        return ((List<Film>) filmRepository.findAll())
                .stream()
                .map(film -> new FilmDto(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getLanguage().getName(),
                        film.getRentalDuration(),
                        film.getRentalRate()))
                .collect(Collectors.toList());
    }

    @Override
    public FilmDetailDto findDetailById(Integer id) {
        return filmRepository.findById(id)
                .map(film -> new FilmDetailDto(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate()))
                .orElse(null);
    }

    @CacheEvict(value = "films", allEntries = true)
    @Override
    public void createFilm(FilmData filmData) {
        Language language = languageRepository.findById(filmData.languageId())
                .orElseThrow(() -> new IllegalArgumentException("El lenguaje con ID " + filmData.languageId() + " no existe"));

        Film film = new Film();
        film.setTitle(filmData.title());
        film.setDescription(filmData.description());
        film.setReleaseYear(filmData.releaseYear());
        film.setRentalDuration(filmData.rentalDuration());
        film.setRentalRate(filmData.rentalRate());
        film.setLength(filmData.length());
        film.setReplacementCost(filmData.replacementCost());
        film.setRating(filmData.rating());
        film.setSpecialFeatures(filmData.specialFeatures());
        film.setLanguage(language);
        film.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        filmRepository.save(film);
    }

    @CacheEvict(value = "films", allEntries = true)
    @Override
    public Boolean updateFilm(FilmDetailDto filmDetailDto) {
        return filmRepository.findById(filmDetailDto.filmId())
                .map(film -> {
                    film.setTitle(filmDetailDto.title());
                    film.setDescription(filmDetailDto.description());
                    film.setReleaseYear(filmDetailDto.releaseYear());
                    film.setRentalDuration(filmDetailDto.rentalDuration());
                    film.setRentalRate(filmDetailDto.rentalRate());
                    film.setLength(filmDetailDto.length());
                    film.setReplacementCost(filmDetailDto.replacementCost());
                    film.setRating(filmDetailDto.rating());
                    film.setSpecialFeatures(filmDetailDto.specialFeatures());
                    film.setLastUpdate(new Timestamp(System.currentTimeMillis()));
                    filmRepository.save(film);
                    return true;
                })
                .orElse(false);
    }

    @CacheEvict(value = "films", allEntries = true)
    @Override
    public Boolean deleteFilm(Integer id) {
        return filmRepository.findById(id)
                .map(film -> {
                    filmRepository.delete(film);
                    return true;
                })
                .orElse(false);
    }
}
