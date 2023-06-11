package medxpert.main.daniyal_medxpert.patient.POJO;

import android.util.Pair;

import java.io.Serializable;
import java.util.List;

public class MedBox implements Serializable {
    private String name;
    private List<medBoxContents_Pojo> medBoxList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToList(medBoxContents_Pojo p){
        medBoxList.add(p);
    }

    public void removeToList(medBoxContents_Pojo p){
        medBoxList.remove(p);
    }

    public int getListSize(){
        return medBoxList.size();
    }

    public List<medBoxContents_Pojo> getMedBoxList() {
        return medBoxList;
    }

    public void setMedBoxList(List<medBoxContents_Pojo> medBoxList) {
        this.medBoxList = medBoxList;
    }
}
