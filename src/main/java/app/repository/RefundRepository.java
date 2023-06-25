package app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.RefundRequest;

@Repository
public interface RefundRepository extends CrudRepository<RefundRequest, Integer>{
    
    RefundRequest findById(int id);

    List<RefundRequest> findAll();
}

