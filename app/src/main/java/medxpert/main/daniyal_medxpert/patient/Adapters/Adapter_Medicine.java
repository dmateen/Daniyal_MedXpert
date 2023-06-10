package medxpert.main.daniyal_medxpert.patient.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import medxpert.main.daniyal_medxpert.patient.ModelMedicine.MedicineModel;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import medxpert.main.daniyal_medxpert.R;
import java.util.ArrayList;

public class Adapter_Medicine extends RecyclerView.Adapter<Adapter_Medicine.viewHolder>{
    ArrayList<MedicineModel> list;
    Context context;
    ArrayList<MedicineModel> selectedItems;  // ArrayList to store selected items


    public Adapter_Medicine(ArrayList<MedicineModel> list, Context context) {
        this.list = list;
        this.context = context;
        selectedItems = new ArrayList<>();  // Initialize the selectedItems ArrayList
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

        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(medicineModel.isSelected());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                medicineModel.setSelected(isChecked);
                if (isChecked)
                {
                    selectedItems.add(medicineModel);
                }
                else
                {
                    selectedItems.remove(medicineModel);
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public ArrayList<MedicineModel> getSelectedItems() {
        return selectedItems;
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView medicineName, morningQuantity, eveningQuantity, nightQuantity, duration, direction;
        CheckBox checkBox;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            medicineName = itemView.findViewById(R.id.nameofmedicine);
            morningQuantity = itemView.findViewById(R.id.quantitymorning);
            eveningQuantity = itemView.findViewById(R.id.quantityevening);
            nightQuantity = itemView.findViewById(R.id.quantitynight);
            duration = itemView.findViewById(R.id.duration);
            direction = itemView.findViewById(R.id.direction);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }

}
