package restSharing.ClientRestful.SecurityConfig.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import restSharing.ClientRestful.model.User;

public interface RepoUser extends JpaRepository<User, Integer>{
	
}
