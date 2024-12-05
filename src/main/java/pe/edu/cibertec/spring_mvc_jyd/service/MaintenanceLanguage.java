package pe.edu.cibertec.spring_mvc_jyd.service;

import pe.edu.cibertec.spring_mvc_jyd.dto.LanguageDto;

import java.util.List;

public interface MaintenanceLanguage {
    List<LanguageDto> findAllLanguages();
}
