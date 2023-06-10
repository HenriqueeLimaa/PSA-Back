package app;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface UsersRepository extends CrudRepository<UserS, Integer>{
    
    UserS findById(int id);

    //List<UserS> findByCargo(Cargo cargo);

}
