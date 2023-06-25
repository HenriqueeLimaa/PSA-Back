package app.controller;

import app.model.RefundRequest;
import app.repository.RefundRepository;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RequestMapping("/api")
@RestController
class RefundController {
    private final RefundRepository rr;

    RefundController(RefundRepository rr){
        this.rr = rr;
    }

    @GetMapping("/refundRequests")
    public List<RefundRequest> getAll(){
        return rr.findAll();
    }

    @PostMapping("/refundRequests")
    public RefundRequest addRefund(@RequestBody RefundRequest refund){
        RefundRequest r1 = new RefundRequest(refund.getDesc(), refund.getValue(), refund.getDate(), refund.getUserId(), refund.getStatus());
        System.out.println("Entrou controller" + refund.getUserId());
        return rr.save(r1);
    }

    @PutMapping("/refundRequests/{id}")
    public void update(@PathVariable int id, @RequestBody RefundRequest r){
        RefundRequest r1 = rr.findById(id);
        r1.setStatus(r.getStatus());
        rr.save(r1);
    }

}
