package pe.edu.cibertec.spring_mvc_jyd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import pe.edu.cibertec.spring_mvc_jyd.entity.Film;
import pe.edu.cibertec.spring_mvc_jyd.repository.FilmRepository;

@SpringBootApplication
@EnableCaching
public class SpringMvcJydApplication  implements CommandLineRunner {

	@Autowired
	FilmRepository filmRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcJydApplication.class, args);
	}


	public void run(String... args) throws Exception {
	System.out.println("------------------------------------------------------");
		System.out.println("findAll() -> 1ra consulta a  MySQL");
		System.out.println("------------------------------------------------------");
		Iterable<Film> iterable = filmRepository.findAll();
		iterable.forEach((film) -> {
			String message = String.format("%s:%s;", film.getFilmId(), film.getTitle());
			System.out.print(message);
		});


	}
}
