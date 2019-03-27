package lt.vtmc.webchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.vtmc.webchat.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
