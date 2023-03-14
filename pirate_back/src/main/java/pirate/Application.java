package pirate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pirate.config.AppConfig;
import pirate.dao.IDAOCompte;
import pirate.model.Capitaine;
import pirate.model.Client;



public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		IDAOCompte daoCompte = context.getBean(IDAOCompte.class);
		
		Client client1 = new Client(20,"Elordi","Elordi","Elordinator","ventdéverzzen");
		
		Capitaine capitaine1 = new Capitaine(30,"momo","asticot","Mô",10);
		daoCompte.save(client1);
		daoCompte.save(capitaine1);
		
		//test push Mohammed
	}
}
