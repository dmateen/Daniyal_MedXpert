package medxpert.main.daniyal_medxpert.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import medxpert.main.daniyal_medxpert.AdapterMedicine.MedicineAdapter;
import medxpert.main.daniyal_medxpert.AdapterVitals.VitalsAdapter;
import medxpert.main.daniyal_medxpert.ModelMedicine.MedicineModel;
import medxpert.main.daniyal_medxpert.ModelVitals.VitalsModel;
import medxpert.main.daniyal_medxpert.R;

import java.util.ArrayList;


public class Vitals extends Fragment {

    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vitals, container, false);

        recyclerView = view.findViewById(R.id.recyclerviewVitals);
        ArrayList<VitalsModel> list = new ArrayList<>();

        list.add(new VitalsModel("Heart Rate", "125"));
        list.add(new VitalsModel("Blood Pressure", "78"));
        list.add(new VitalsModel("Blood Sugar Level checking system", "51"));
        list.add(new VitalsModel("Temperature", "23"));

        VitalsAdapter adapter = new VitalsAdapter(list, getContext());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
}