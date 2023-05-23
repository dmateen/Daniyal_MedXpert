package medxpert.main.daniyal_medxpert.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import medxpert.main.daniyal_medxpert.MedicalRecord;
import medxpert.main.daniyal_medxpert.POJO.MedicalRecord_Pojo;
import medxpert.main.daniyal_medxpert.R;

public class RecyclerMedicalRecord_Adapter extends RecyclerView.Adapter<RecyclerMedicalRecord_Adapter.ViewHolder_MedicalRecord> {

    Context context;
    ArrayList <MedicalRecord_Pojo> prescriptions;

    public RecyclerMedicalRecord_Adapter(Context context, ArrayList<MedicalRecord_Pojo> prescriptions){
        this.context=context;
        this.prescriptions=prescriptions;

    }

    @NonNull
    @Override
    public ViewHolder_MedicalRecord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context ).inflate(R.layout.prescriptio_card,parent,false);  //Attach to root is false because recycle view is used and we dont want to attach the view to the screen rather want to reuse it
        ViewHolder_MedicalRecord vh=new ViewHolder_MedicalRecord(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_MedicalRecord holder, int position) {

        holder.name.setText(prescriptions.get(position).getName());
        holder.date.setText(prescriptions.get(position).getDate());
        holder.specialization.setText(prescriptions.get(position).getSpecialization());

    }

    @Override
    public int getItemCount() {
        return prescriptions.size();
    }


    // --------- View Holder Class
    public class ViewHolder_MedicalRecord extends RecyclerView.ViewHolder {

        TextView name, date,specialization;

        public ViewHolder_MedicalRecord(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.doctorName_prescription);
            specialization=itemView.findViewById(R.id.doctorSpecialization_prescription);
            date=itemView.findViewById(R.id.date_prescription);

        }
    }
}
