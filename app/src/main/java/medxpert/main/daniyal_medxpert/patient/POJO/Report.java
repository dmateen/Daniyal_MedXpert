package medxpert.main.daniyal_medxpert.patient.POJO;

import android.graphics.Bitmap;

public class Report {
    private String name;
    private String date;
    private Bitmap image;

    @Override
    public String toString() {
        return "Report{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", image=" + image +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
