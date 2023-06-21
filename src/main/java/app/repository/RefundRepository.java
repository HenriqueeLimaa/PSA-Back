package app.repository;

import app.RefundRequest;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface RefundRepository extends CrudRepository<RefundRequest, Integer>{
    
    RefundRequest findById(int id);

    List<RefundRequest> findAll();
}

