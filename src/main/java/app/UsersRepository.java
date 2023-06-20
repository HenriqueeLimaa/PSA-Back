package app;

import org.springframework.data.repository.CrudRepository;


public interface UsersRepository extends CrudRepository<UserS, Integer>{
    
    UserS findById(int id);

    UserS findByUsername(String username);

    //List<UserS> findByCargo(Cargo cargo);

}
