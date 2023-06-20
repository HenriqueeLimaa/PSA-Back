package app.repository;

import app.RefundRequest;
import org.springframework.data.repository.CrudRepository;
//import java.util.List;


public interface RefundRepository extends CrudRepository<RefundRequest, Integer>{
    
    RefundRequest findById(int id);

    //List<UserS> findByCargo(Cargo cargo);

}

