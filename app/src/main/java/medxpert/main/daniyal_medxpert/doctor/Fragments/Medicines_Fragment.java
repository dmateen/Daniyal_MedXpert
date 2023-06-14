package medxpert.main.daniyal_medxpert.doctor.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import medxpert.main.daniyal_medxpert.doctor.MedicineModel_doctor;
import medxpert.main.daniyal_medxpert.doctor.Adapters.Adapter_Medicine;
import medxpert.main.daniyal_medxpert.patient.ModelMedicine.MedicineModel;
import medxpert.main.daniyal_medxpert.R;

import medxpert.main.daniyal_medxpert.patient.SendPharmacy;

import java.util.ArrayList;
import java.util.List;


public class Medicines_Fragment extends Fragment {

    RecyclerView recyclerView;
    List<MedicineModel_doctor> list ;

    public Medicines_Fragment(List<MedicineModel_doctor> incomingList){
        list=incomingList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<MedicineModel> selectedItems = new ArrayList<>(); //to detect checked medicines
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_medicines, container, false);

        recyclerView = view.findViewById(R.id.recyclerview1);

        Adapter_Medicine adapter = new Adapter_Medicine(list, getContext());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        Button btn = view.findViewById(R.id.sendpharmacy);
        btn.setVisibility(View.GONE);

        Button btn1 = view.findViewById(R.id.addtomed);
        btn1.setVisibility(View.GONE);





        return view;
    }
}