package lt.vtmc.webchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lt.vtmc.webchat.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

}
