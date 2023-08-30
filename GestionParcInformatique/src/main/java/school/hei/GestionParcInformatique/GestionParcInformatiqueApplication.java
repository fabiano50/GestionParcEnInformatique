package school.hei.GestionParcInformatique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"school.hei.GestionParcInformatique.controller", "school.hei.GestionParcInformatique.service"})
public class GestionParcInformatiqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionParcInformatiqueApplication.class, args);
	}

}


