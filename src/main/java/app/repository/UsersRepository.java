package app.repository;

import app.model.UserDto;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UserDto, Integer>{
    
    UserDto findById(int id);
    
    Optional<UserDto> findByUsername(String username);

    boolean existsByUsername(String username);

    List<UserDto> findAll();

}
