package medxpert.main.daniyal_medxpert.AdapterMedicine;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import medxpert.main.daniyal_medxpert.ModelMedicine.MedicineModel;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import medxpert.main.daniyal_medxpert.R;
import java.util.ArrayList;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.viewHolder>{
    ArrayList<MedicineModel> list;
    Context context;

    public MedicineAdapter(ArrayList<MedicineModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.medicine_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        MedicineModel medicineModel = list.get(position);

        holder.medicineName.setText(medicineModel.getMedicineName());
        holder.morningQuantity.setText(medicineModel.getMorningQuantity());
        holder.eveningQuantity.setText(medicineModel.getEveningQuantity());
        holder.nightQuantity.setText(medicineModel.getNightQuantity());
        holder.duration.setText(medicineModel.getDuration());
        holder.direction.setText(medicineModel.getDirection());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView medicineName, morningQuantity, eveningQuantity, nightQuantity, duration, direction;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            medicineName = itemView.findViewById(R.id.nameofmedicine);
            morningQuantity = itemView.findViewById(R.id.quantitymorning);
            eveningQuantity = itemView.findViewById(R.id.quantityevening);
            nightQuantity = itemView.findViewById(R.id.quantitynight);
            duration = itemView.findViewById(R.id.duration);
            direction = itemView.findViewById(R.id.direction);
        }
    }

}
