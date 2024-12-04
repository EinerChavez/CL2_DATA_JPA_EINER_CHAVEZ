package pe.edu.cibertec.spring_mvc_jyd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDetailDto;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDto;
import pe.edu.cibertec.spring_mvc_jyd.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    // Mostrar todos los films
    @GetMapping("/start")
    public String start(Model model) {
        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance"; // Vista donde se muestra el listado de películas
    }

    // Mostrar detalles de un film específico
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance-detail"; // Vista con los detalles del film
    }

    // Editar un film
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance-edit"; // Vista para editar la película
    }

    // Confirmar la edición de un film
    @PostMapping("/edit-confirm")
    public String editConfirm(@ModelAttribute FilmDetailDto film) {
        maintenanceService.updateFilm(film);
        return "redirect:/maintenance/start"; // Redirigir al listado después de la edición
    }

    // Eliminar un film
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        boolean success = maintenanceService.deleteFilm(id);
        if (success) {
            return "redirect:/maintenance/start"; // Redirigir al listado después de la eliminación
        } else {
            model.addAttribute("error", "No se pudo eliminar el film.");
            List<FilmDto> films = maintenanceService.findAllFilms();
            model.addAttribute("films", films);
            return "maintenance"; // Volver al listado si falla la eliminación
        }
    }
}
