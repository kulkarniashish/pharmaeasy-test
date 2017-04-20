package in.pharmeasy.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pharmeasy.user.domain.User;
import in.pharmeasy.user.value.UserType;

public interface UserRepo extends JpaRepository<User, Long>{

	List<User> findByUserType(UserType type);

	User findByUsername(String name);

}
