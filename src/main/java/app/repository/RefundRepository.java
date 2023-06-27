package app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.RefundRequest;

@Repository
public interface RefundRepository extends CrudRepository<RefundRequest, Integer>{
    
    RefundRequest findById(long id);

    List<RefundRequest> findByStatus(String status);

    List<RefundRequest> findAll();
}

