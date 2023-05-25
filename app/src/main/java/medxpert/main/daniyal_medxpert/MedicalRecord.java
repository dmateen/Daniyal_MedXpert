package medxpert.main.daniyal_medxpert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import medxpert.main.daniyal_medxpert.Adapters.RecyclerMedicalRecord_Adapter;
import medxpert.main.daniyal_medxpert.POJO.MedicalRecord_Pojo;

public class MedicalRecord extends AppCompatActivity {

    ArrayList<MedicalRecord_Pojo> prescriptions=new ArrayList<MedicalRecord_Pojo>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_record);

        //Showing back button on toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        RecyclerView recyclerView=findViewById(R.id.recyclerView_MedicalRecord);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //-------------Adding Dummy Data Set -----------------

        prescriptions.add(new MedicalRecord_Pojo("Daniyal","12/Apr/2023","General Physician"));
        prescriptions.add(new MedicalRecord_Pojo("Hamza","19/Apr/2023","MBBS"));
        prescriptions.add(new MedicalRecord_Pojo("Basiq","21/Nov/2023","Physician"));
        prescriptions.add(new MedicalRecord_Pojo("Daniyal","12/Apr/2023","General Physician"));
        prescriptions.add(new MedicalRecord_Pojo("Hamza","19/Apr/2023","MBBS"));
        prescriptions.add(new MedicalRecord_Pojo("Basiq","21/Nov/2023","Physician"));   

        //-------------Adding Dummy Data Set -----------------


        RecyclerMedicalRecord_Adapter adapter=new RecyclerMedicalRecord_Adapter(this,prescriptions);
        recyclerView.setAdapter(adapter);





    }
}