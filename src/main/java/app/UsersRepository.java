package app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface UsersRepository extends CrudRepository<UserS, Integer>{
    
    UserS findById(int id);

    //List<UserS> findByCargo(Cargo cargo);

}
