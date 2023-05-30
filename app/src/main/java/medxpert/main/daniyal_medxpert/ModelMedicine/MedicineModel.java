package medxpert.main.daniyal_medxpert.ModelMedicine;

public class MedicineModel {
    String medicineName, morningQuantity, eveningQuantity, nightQuantity, duration, direction;

    public MedicineModel(String medicineName, String morningQuantity, String eveningQuantity, String nightQuantity, String duration, String direction) {
        this.medicineName = medicineName;
        this.morningQuantity = morningQuantity;
        this.eveningQuantity = eveningQuantity;
        this.nightQuantity = nightQuantity;
        this.duration = duration;
        this.direction = direction;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMorningQuantity() {
        return morningQuantity;
    }

    public void setMorningQuantity(String morningQuantity) {
        this.morningQuantity = morningQuantity;
    }

    public String getEveningQuantity() {
        return eveningQuantity;
    }

    public void setEveningQuantity(String eveningQuantity) {
        this.eveningQuantity = eveningQuantity;
    }

    public String getNightQuantity() {
        return nightQuantity;
    }

    public void setNightQuantity(String nightQuantity) {
        this.nightQuantity = nightQuantity;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
