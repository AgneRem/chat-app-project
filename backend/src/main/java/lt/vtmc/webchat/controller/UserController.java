package lt.vtmc.webchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lt.vtmc.webchat.exception.ResourceNotFoundException;
import lt.vtmc.webchat.model.User;
import lt.vtmc.webchat.payload.UserIdentityAvailability;
import lt.vtmc.webchat.payload.UserProfile;
import lt.vtmc.webchat.payload.UserSummary;
import lt.vtmc.webchat.repository.UserRepository;
import lt.vtmc.webchat.security.CurrentUser;
import lt.vtmc.webchat.security.UserPrincipal;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserRepository userRepository;

//	private static final Logger logger = LoggerFactory
//			.getLogger(UserController.class);

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
		UserSummary userSummary = new UserSummary(currentUser.getId(),
				currentUser.getUsername(), currentUser.getNickname(), currentUser.getEmail(), currentUser.getJoinedAt());
		return userSummary;
	}

	@GetMapping("/user/checkUsernameAvailability")
	public UserIdentityAvailability checkUsernameAvailability(
			@RequestParam(value = "username") String username) {
		Boolean isAvailable = !userRepository.existsByUsername(username);
		return new UserIdentityAvailability(isAvailable);
	}

	@GetMapping("/user/checkEmailAvailability")
	public UserIdentityAvailability checkEmailAvailability(
			@RequestParam(value = "email") String email) {
		Boolean isAvailable = !userRepository.existsByEmail(email);
		return new UserIdentityAvailability(isAvailable);
	}

	@GetMapping("/users/{username}")
	public UserProfile getUserProfile(
			@PathVariable(value = "username") String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User",
						"username", username));

		UserProfile userProfile = new UserProfile(user.getId(),
				user.getUsername(), user.getNickname(), user.getCreatedAt());

		return userProfile;
	}

}
