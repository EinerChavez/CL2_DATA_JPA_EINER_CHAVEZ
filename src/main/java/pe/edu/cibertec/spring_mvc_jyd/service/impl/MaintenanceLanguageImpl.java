package pe.edu.cibertec.spring_mvc_jyd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring_mvc_jyd.dto.LanguageDto;
import pe.edu.cibertec.spring_mvc_jyd.entity.Language;
import pe.edu.cibertec.spring_mvc_jyd.repository.LanguageRepository;
import pe.edu.cibertec.spring_mvc_jyd.service.MaintenanceLanguage;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceLanguageImpl implements MaintenanceLanguage {
    @Autowired
    LanguageRepository languageRepository;

    @Cacheable(value = "languages")
    @Override
    public List<LanguageDto> findAllLanguages() {
        List<LanguageDto> languages = new ArrayList<LanguageDto>();
        Iterable<Language> iterable = languageRepository.findAll();

        iterable.forEach(language -> {
            LanguageDto languageDto = new LanguageDto(
                    language.getLanguageId(),
                    language.getName()
            );
            languages.add(languageDto);
        });

        return languages;
    }
}
