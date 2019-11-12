package ru.mlg.probe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.mlg.probe.entity.Address;
import ru.mlg.probe.entity.User;
import ru.mlg.probe.service.UserService;

@SpringBootApplication
public class ProbeApplication {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ProbeApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	private void testJpaMethods() {
		Address address = new Address();
		address.setCity("Kiev");
		address.setHomeNumber("4");
		address.setStreet("Main Street");
		Address address1 = new Address();
		address1.setCity("Lviv");
		User users = new User();
		users.setAddress(address);
		users.setEmail("someEmail@gmail.com");
		users.setName("Smith");
		userService.createUser(users);
		User users1 = new User();
		users1.setName("Jon Dorian");
		users1.setEmail("gmailEmail@gmail.com");
		users1.setAddress(address1);
		userService.createUser(users1);

		userService.findAll().forEach(it -> System.out.println(it));

		userService.findAllByName("Smith").forEach(it -> System.out.println(it));

		userService.findWhereEmailIsGmail().forEach(it -> System.out.println(it));

		userService.findWhereNameStartsFromSmith().forEach(it -> System.out.println(it));
	}
}
