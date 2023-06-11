package medxpert.main.daniyal_medxpert.patient.POJO;

public class medBoxContents_Pojo {

    private String medicinename;
    private int quantity;
    public medBoxContents_Pojo(String Medicinename, int Quantity)
    {
        this.medicinename=Medicinename;
        this.quantity=Quantity;

    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename;
    }

    public String getMedicinename() {
        return medicinename;
    }


}
