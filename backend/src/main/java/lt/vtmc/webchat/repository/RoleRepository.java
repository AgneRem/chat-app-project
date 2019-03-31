package lt.vtmc.webchat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.vtmc.webchat.model.Role;
import lt.vtmc.webchat.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(RoleName roleName);
}
