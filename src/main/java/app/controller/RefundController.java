package app.controller;

import app.RefundRequest;
import app.repository.RefundRepository;
import app.services.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        RefundRequest r1 = new RefundRequest(refund.getDesc(), refund.getValue(), refund.getDate(), refund.getUser(), refund.getStatus());
        System.out.println("Entrou controller" + r1.toString());
        return rr.save(r1);
    }


    public void Accept(@RequestBody RefundRequest r){
        r.setStatus("ACEITO");
    }

    public void Refuse(RefundRequest r){
        r.setStatus("RECUSADO");
    }
}
