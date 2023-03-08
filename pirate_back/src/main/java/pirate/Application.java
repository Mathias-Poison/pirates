package pirate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pirate.config.AppConfig;



public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	}
}
