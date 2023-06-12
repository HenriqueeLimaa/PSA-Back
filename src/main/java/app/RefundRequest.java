package app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RefundRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    private double value;
    private String date;
    private int uid;
    private String status;

    protected RefundRequest(){}

    public RefundRequest(String description, double value, String date, int uid,String status ) {
        this.description = description;
        this.value = value;
        this.date = date;
        this.uid = uid;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus(){
        return status;
    }

    public int getUser(){
        return uid;
    }

    public void setStatus(String st){
        if(st.equals("ACEITO"))
        status = "ACEITO";
        if(st.equals("RECUSADO"))
        status = "RECUSADO";
        if(st.equals("PENDENTE"))
        status = "PENDENTE";
    }
    
}
