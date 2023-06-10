package medxpert.main.daniyal_medxpert.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;

import medxpert.main.daniyal_medxpert.patient.Adapters.Adapter_medicalrecordlayout1;
import medxpert.main.daniyal_medxpert.R;

public class PrescriptionList extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescriptionlist);

        //Showing back button on toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<medicalrecordlayout1model> list = new ArrayList<>();
        list.add(new medicalrecordlayout1model("20/April/2023","view the prescription", "Dr.Hussain Attique","Heart Surgeon"));
        list.add(new medicalrecordlayout1model("16/May/2023","view the prescription", "Dr.Osama Bhatti","Heart Player"));
        list.add(new medicalrecordlayout1model("16/May/2023","view the prescription", "Dr.Osama Bhatti","Heart Player"));
        list.add(new medicalrecordlayout1model("16/May/2023","view the prescription", "Dr.Osama Bhatti","Heart Player"));
        list.add(new medicalrecordlayout1model("16/May/2023","view the prescription", "Dr.Osama Bhatti","Heart Player"));
        list.add(new medicalrecordlayout1model("16/May/2023","view the prescription", "Dr.Osama Bhatti","Heart Player"));

        Adapter_medicalrecordlayout1 adapter = new Adapter_medicalrecordlayout1(list, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}


