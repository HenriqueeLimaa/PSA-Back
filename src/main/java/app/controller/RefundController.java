package app.controller;

import app.model.RefundRequest;
import app.repository.RefundRepository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
                System.out.println("Entrou controller" + refund.getUserId());
        RefundRequest r1 = new RefundRequest(refund.getDesc(), refund.getValue(), refund.getDate(), refund.getUserId(), refund.getStatus());
        return rr.save(r1);
    }

    @PutMapping("/refundRequests/{id}")
    public void update(@PathVariable int id, @RequestBody RefundRequest r){
        RefundRequest r1 = rr.findById(id);
        r1.setStatus(r.getStatus());
        rr.save(r1);
    }

    @GetMapping(value="/refundReport")
    public String getReport() {
       // OutputStream os = new FileOutputStream("src\\main\\resources\\report.txt");
        //Writer wr = new OutputStreamWriter(os);
        //BufferedWriter br = new BufferedWriter(wr);

        List<RefundRequest> req =  rr.findByStatus("ACEITO");
        double total = 0;
        String teste = "<p>Aceitos:</p><br>";
 ;
        for(RefundRequest refund: req){
            teste += "<p>" + refund.getId() + " - " + refund.getDesc() + " - " + refund.getValue() + "</p><br>";
            total += refund.getValue();
        }
        if(total != 0)
       teste += "<p>Total: " + total + "</p><br><br>";
        
        List<RefundRequest> req2 =  rr.findByStatus("RECUSADO");
        double total2 = 0;
        teste += "<p>Recusados: </p><br>";

        for(RefundRequest refund: req2){
            teste += "<p>" + refund.getId() + " - " + refund.getDesc() + " - " + refund.getValue() + "</p><br>";
            total2 += refund.getValue();
        }
        if(total2 != 0)
        teste += "<p>Total: " + total2 + "</p><br>";


    return teste;
    }

}
