public class RefundRequest {
    private int id;
    private String desc;
    private double value;
    private String date;
    private UserS u;
    private Status s;

    public enum Status{
        ACEITO, RECUSADO, PENDENTE;
    }

    public RefundRequest(int id, String desc, double value, String date, UserS u,Status s ) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
