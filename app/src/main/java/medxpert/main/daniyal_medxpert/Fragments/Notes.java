package medxpert.main.daniyal_medxpert.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import medxpert.main.daniyal_medxpert.AdapterNotes.NotesAdapter;
import medxpert.main.daniyal_medxpert.AdapterVitals.VitalsAdapter;
import medxpert.main.daniyal_medxpert.ModelNotes.NotesModel;
import medxpert.main.daniyal_medxpert.ModelVitals.VitalsModel;
import medxpert.main.daniyal_medxpert.R;

import java.util.ArrayList;


public class Notes extends Fragment {

    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        recyclerView = view.findViewById(R.id.recyclerviewnotes);
        ArrayList<NotesModel> list = new ArrayList<>();

        list.add(new NotesModel("Patient:", "John Smith Black"));
        list.add(new NotesModel("Exam:", "Done blood examination in the children hospital lahore under various senior doctors"));


        NotesAdapter adapter = new NotesAdapter(list, getContext());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
}