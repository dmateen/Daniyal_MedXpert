package medxpert.main.daniyal_medxpert.AdapterVitals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import medxpert.main.daniyal_medxpert.ModelVitals.VitalsModel;
import medxpert.main.daniyal_medxpert.R;


import java.util.ArrayList;

public class VitalsAdapter extends RecyclerView.Adapter<VitalsAdapter.ViewHolder> {
    private ArrayList<VitalsModel> vitalsList;
    private Context context;

    public VitalsAdapter(ArrayList<VitalsModel> vitalsList, Context context) {
        this.vitalsList = vitalsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vitals_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VitalsModel vitals = vitalsList.get(position);

        holder.nameOfVitals.setText(vitals.getNameOfVitals());
        holder.valueOfVitals.setText(vitals.getValueOfVitals());

    }

    @Override
    public int getItemCount() {
        return vitalsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameOfVitals, valueOfVitals;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOfVitals = itemView.findViewById(R.id.nameofvital);
            valueOfVitals = itemView.findViewById(R.id.valueofvital);
        }
    }
}