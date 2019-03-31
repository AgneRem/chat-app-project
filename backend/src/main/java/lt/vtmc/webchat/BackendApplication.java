package lt.vtmc.webchat;

import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lt.vtmc.webchat.model.Role;
import lt.vtmc.webchat.model.RoleName;
import lt.vtmc.webchat.model.User;
import lt.vtmc.webchat.repository.RoleRepository;
import lt.vtmc.webchat.repository.UserRepository;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan(basePackageClasses = { BackendApplication.class,
		Jsr310JpaConverters.class })
@EnableSwagger2
public class BackendApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner users(RoleRepository roleRepository,
			UserRepository userRepository) {
		return (args) -> {
			Role userRole = new Role(RoleName.ROLE_USER);
			Role adminRole = new Role(RoleName.ROLE_ADMIN);
			roleRepository.save(userRole);
			roleRepository.save(adminRole);

			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			User admin = new User("admin123", "Administrator",
					"admin@admin.com", passwordEncoder.encode("admin123"));
			Set<Role> adminRoles = new HashSet<>();
			adminRoles.add(adminRole);
			adminRoles.add(userRole);
			admin.setRoles(adminRoles);

			User user = new User("user123", "Test User", "user@user.com",
					passwordEncoder.encode("user123"));
			Set<Role> userRoles = new HashSet<>();
			userRoles.add(userRole);
			user.setRoles(userRoles);

			userRepository.save(admin);
			userRepository.save(user);
		};
	}

	@Bean
	public Docket swaggerDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("lt.vtmc.webchat"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Webchat App REST Documentation")
				.version("0.0.1- - SNAPSHOT")
				.build();
	}
}
