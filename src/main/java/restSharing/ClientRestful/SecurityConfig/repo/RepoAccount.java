package restSharing.ClientRestful.SecurityConfig.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import restSharing.ClientRestful.model.Account;

public interface RepoAccount extends JpaRepository<Account,Integer>{

}
