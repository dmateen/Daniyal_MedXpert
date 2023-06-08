package medxpert.main.daniyal_medxpert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dashboard extends AppCompatActivity {

    BottomNavigationView bottom_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);


        //Showing back button on toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


//        //TODO handling on click listener for each imagebutton:
//
//        ImageButton medicalrecord = findViewById(R.id.medicalRecordBtn);
//        medicalrecord.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle button click event
//                Toast.makeText(dashboard.this, "Medical Record clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        ImageButton Reminders = findViewById(R.id.RemindersBtn);
//        Reminders.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle button click event
//                Toast.makeText(dashboard.this, "Reminders clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        ImageButton Med_Box = findViewById(R.id.medBoxBtn);
//        Med_Box.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle button click event
//                Toast.makeText(dashboard.this, "Med Box Cicked", Toast.LENGTH_SHORT).show();
//            }
//        });


//        ImageButton Lab_Test = findViewById(R.id.LabTests);
//        Lab_Test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle button click event
//                Toast.makeText(dashboard.this, "Lab Test Cicked", Toast.LENGTH_SHORT).show();
//            }
//        });



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.Home:
                        Toast.makeText(dashboard.this, "Home clicked ", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(getApplicationContext(), dashboard.class);
                        startActivity(i);
                        // Handle Home item selection
                        // Navigate to the Home page or perform related actions
                        return true;
                    case R.id.Record:

                        Toast.makeText(dashboard.this, "Record clicked ", Toast.LENGTH_SHORT).show();


                        // Handle Record item selection
                        // Navigate to the Record page or perform related actions
                        return true;
                    case R.id.Account:
                        Toast.makeText(dashboard.this, "Account clicked", Toast.LENGTH_SHORT).show();

                        return true;
                }
                return false;
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}