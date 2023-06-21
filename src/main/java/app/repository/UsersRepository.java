package app.repository;

import app.services.UserService;
import org.springframework.data.repository.CrudRepository;


public interface UsersRepository extends CrudRepository<UserService, Integer>{
    
    UserService findById(int id);

    UserService findByUsername(String username);

}
