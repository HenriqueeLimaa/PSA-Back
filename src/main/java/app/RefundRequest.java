package app;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RefundRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String desc;
    private double value;
    private Date date;
    private UserS u;
    private Status s;

    public enum Status{
        ACEITO, RECUSADO, PENDENTE;
    }

    public RefundRequest(String desc, double value, Date date, UserS u,Status s ) {
        this.desc = desc;
        this.value = value;
        this.date = date;
        this.u = u;
        s = Status.PENDENTE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus(){
        return s;
    }

    public UserS getUser(){
        return u;
    }

    public void setStatus(String st){
        if(st.equals("ACEITO"))
        s = Status.ACEITO;
        if(st.equals("RECUSADO"))
        s = Status.RECUSADO;
        if(st.equals("PENDENTE"))
        s = Status.PENDENTE;
    }
    
}
