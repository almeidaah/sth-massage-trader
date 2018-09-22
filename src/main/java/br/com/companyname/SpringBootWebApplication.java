package br.com.companyname;

import br.com.companyname.model.Login;
import br.com.companyname.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
@EnableScheduling
public class SpringBootWebApplication implements CommandLineRunner {

	@Autowired
	LoginRepository loginRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION,
			proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Login login() {
		return new Login();
	}

	@Override
	public void run(String... strings){
		Login defaultLogin = new Login();
		defaultLogin.setEmail("almeidascvn@gmail.com");
		defaultLogin.setPassword("123");

		Login byEmailAndPassword = loginRepository.findByEmailAndPassword(defaultLogin.getEmail(), defaultLogin.getPassword());

		if(byEmailAndPassword == null){
			loginRepository.save(defaultLogin);
		}
	}
}