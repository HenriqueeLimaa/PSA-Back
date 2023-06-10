package app;

import java.util.ArrayList;

public class RefundControl {
    private ArrayList<RefundRequest> ref;

    public RefundControl(ArrayList<RefundRequest> ref){
        this.ref = ref;
    }

    public void Accept(RefundRequest r){
        r.setStatus("ACEITO");
    }

    public void Refuse(RefundRequest r){
        r.setStatus("RECUSADO");
    }

    public ArrayList<RefundRequest> getAllRequests(){
        return ref;
    }


}
