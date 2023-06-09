package medxpert.main.daniyal_medxpert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import medxpert.main.daniyal_medxpert.Fragments.Medicines;
import medxpert.main.daniyal_medxpert.Fragments.Notes;
import medxpert.main.daniyal_medxpert.Fragments.Vitals;

public class medicalrecordLayout2 extends AppCompatActivity {

    Button medicine, vitals, notes;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicalrecord_layout2);

        //Showing back button on toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //End of Displaying Toolbar

        //Getting Data from previous screen
        Intent intent =getIntent();
        String name = intent.getStringExtra("Name");
        String designation = intent.getStringExtra("Designation");
        String date = intent.getStringExtra("Date");


        //Populating Details about Doctor
        TextView textView1 = findViewById(R.id.namelayout2);
        textView1.setText(name);
        TextView textView2 = findViewById(R.id.designationlayout2);
        textView2.setText(designation);
        TextView textView3 = findViewById(R.id.datelayout2);
        textView3.setText(date);



        //Getting Buttons
        medicine = findViewById(R.id.medicines);
        vitals = findViewById(R.id.vitals);
        notes = findViewById(R.id.notes);
        linearLayout = findViewById(R.id.linearforfragments);

        //Adding onClick Listener on Medicine Btn
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Medicines medicineFragment = new Medicines();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearforfragments, medicineFragment);
                transaction.commit();
            }
        });

        //Adding onClick Listener on Vitals Btn
        vitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vitals vitalsFragment = new Vitals();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearforfragments, vitalsFragment);
                transaction.commit();
            }
        });

        //Adding onClick Listener on Notes Btn
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notes notesFragment = new Notes();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearforfragments, notesFragment);
                transaction.commit();
            }
        });
    }
}