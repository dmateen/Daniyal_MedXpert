package medxpert.main.daniyal_medxpert.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import medxpert.main.daniyal_medxpert.AdapterMedicine.MedicineAdapter;
import medxpert.main.daniyal_medxpert.ModelMedicine.MedicineModel;
import medxpert.main.daniyal_medxpert.R;

import medxpert.main.daniyal_medxpert.SendPharmacy;
import medxpert.main.daniyal_medxpert.medicalrecordLayout2;
import medxpert.main.daniyal_medxpert.medicalrecordlayout1Adapter;
import medxpert.main.daniyal_medxpert.medicalrecordlayout1model;

import java.util.ArrayList;


public class Medicines extends Fragment {

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_medicines, container, false);

        recyclerView = view.findViewById(R.id.recyclerview1);

        ArrayList<MedicineModel> list = new ArrayList<>();
        list.add(new MedicineModel("Panadol (10mg)", "1","1", "1", "4 days", "2 hours after meal"));
        list.add(new MedicineModel("Amoxil", "1","1", "1", "4 days", "2 hours after meal"));
        list.add(new MedicineModel("Amoxil", "1","1", "1", "4 days", "2 hours after meal"));
        list.add(new MedicineModel("Amoxil", "1","1", "1", "4 days", "2 hours after meal"));
        list.add(new MedicineModel("Amoxil", "1","1", "1", "4 days", "2 hours after meal"));
        list.add(new MedicineModel("Amoxil", "1","1", "1", "4 days", "2 hours after meal"));
        list.add(new MedicineModel("Amoxil", "1","1", "1", "4 days", "2 hours after meal"));

        //Setting up recycle view
        MedicineAdapter adapter = new MedicineAdapter(list, getContext());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        Button btn = view.findViewById(R.id.sendpharmacy);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SendPharmacy.class);
                startActivity(intent);
            }
        });

        return view;
    }
}