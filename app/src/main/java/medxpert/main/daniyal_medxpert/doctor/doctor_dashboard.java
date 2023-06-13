package medxpert.main.daniyal_medxpert.doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import medxpert.main.daniyal_medxpert.R;
import medxpert.main.daniyal_medxpert.doctor.Validations.Validation;

public class doctor_dashboard extends AppCompatActivity {

    private TextInputLayout cnicEditText;
    String cnic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dashboard);

        //Showing back button on toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(0);


        cnicEditText=findViewById(R.id.cnic_EditText);
        Button addPrescriptionBtn= findViewById(R.id.addPrescriotionBtn);

        addPrescriptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnic=cnicEditText.getEditText().getText().toString();
                if(Validation.validateCNIC(cnic,cnicEditText))
                {
                    Intent intent=new Intent(doctor_dashboard.this,Layout1.class);
                    intent.putExtra("patientCNIC",cnic);
                    Toast.makeText(doctor_dashboard.this, cnic, Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }

            }
        });

    }


}