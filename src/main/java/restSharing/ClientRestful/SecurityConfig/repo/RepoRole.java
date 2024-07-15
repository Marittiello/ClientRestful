package restSharing.ClientRestful.SecurityConfig.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import restSharing.ClientRestful.model.Role;

public interface RepoRole extends JpaRepository<Role,Integer>{

}
