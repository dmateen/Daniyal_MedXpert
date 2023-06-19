package medxpert.main.daniyal_medxpert.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import medxpert.main.daniyal_medxpert.R;
import medxpert.main.daniyal_medxpert.doctor.MedicineModel_doctor;
import medxpert.main.daniyal_medxpert.patient.ModelMedicine.MedicineModel;
import medxpert.main.daniyal_medxpert.patient.Adapters.Adapter_SendPharmacy;

public class SendPharmacy extends AppCompatActivity
{
    ArrayList<MedicineModel_doctor> SelectedItems;

    LinearLayoutManager linearLayout;
    RecyclerView SendPharmacyRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_send_pharmacy);

        Intent intent = getIntent();

        SelectedItems = (ArrayList<MedicineModel_doctor>) intent.getSerializableExtra("SelectedItems");

        SendPharmacyRecycler=findViewById(R.id.recyclersendpharmacy);


        Adapter_SendPharmacy sendpharmacyadapterobj = new Adapter_SendPharmacy(this, SelectedItems ); //passing array list "routine_Intake_List" inside it

        SendPharmacyRecycler.setAdapter(sendpharmacyadapterobj);
        linearLayout = new LinearLayoutManager(this);
        SendPharmacyRecycler.setLayoutManager(linearLayout);





    }
    public void SendPharmacyBtnClicked(View view){
        // Create a StringBuilder to build the text to be shared
        StringBuilder sharedText = new StringBuilder();

// Iterate through the SelectedItems ArrayList
        for (MedicineModel_doctor medicineModel : SelectedItems) {
            int morningQuantity = Integer.parseInt(medicineModel.getMorningQuantity());
            int afternoonQuantity = Integer.parseInt(medicineModel.getNightQuantity());
            int eveningQuantity = Integer.parseInt(medicineModel.getEveningQuantity());
            int duration = Integer.parseInt(medicineModel.getDuration().replaceAll("\\D+", ""));

            int totalQuantity = (morningQuantity + afternoonQuantity + eveningQuantity) * duration;

            // Append medicine name and total quantity to the sharedText StringBuilder
            sharedText.append("Medicine Name: ").append(medicineModel.getMedicineName()).append("\n");
            sharedText.append("Total Quantity: ").append(totalQuantity).append("\n\n");
        }

// Create the sharing Intent
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, sharedText.toString());

// Start the activity for sharing
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }
}