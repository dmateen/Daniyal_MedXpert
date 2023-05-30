package medxpert.main.daniyal_medxpert.PojoClass;

public class POJORoutineIntake {

    private String medicinename;
    private int quantity;
    public POJORoutineIntake(String Medicinename, int Quantity)
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
