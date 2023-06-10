package medxpert.main.daniyal_medxpert.patient.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import medxpert.main.daniyal_medxpert.R;
import medxpert.main.daniyal_medxpert.patient.medicalrecordLayout2;
import medxpert.main.daniyal_medxpert.patient.medicalrecordlayout1model;

public class Adapter_medicalrecordlayout1 extends RecyclerView.Adapter<Adapter_medicalrecordlayout1.viewHolder> {

    ArrayList<medicalrecordlayout1model> list;
    Context context;

    public Adapter_medicalrecordlayout1(ArrayList<medicalrecordlayout1model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.medicalrecordlayout1, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        medicalrecordlayout1model model = list.get(position);

//        holder.description.setText(model.getDescription());
        holder.name.setText(model.getName());
        holder.designation.setText(model.getDesignation());
        holder.date.setText(model.getDate());

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, medicalrecordLayout2.class);
                intent.putExtra("Name", model.getName());
                intent.putExtra("Designation", model.getDesignation());
                intent.putExtra("Date", model.getDate());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
         TextView description, name, designation, date;
        Button btn;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
//            description = itemView.findViewById(R.id.description);
            name = itemView.findViewById(R.id.doctorName_prescription);
            designation = itemView.findViewById(R.id.doctorSpecialization_prescription);
            date = itemView.findViewById(R.id.date_prescription);
            btn = itemView.findViewById(R.id.button); // Update the ID here to match your layout
        }
    }
}