package medxpert.main.daniyal_medxpert.patient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import medxpert.main.daniyal_medxpert.R;
import medxpert.main.daniyal_medxpert.patient.POJO.RoutineIntake_Pojo;
import medxpert.main.daniyal_medxpert.patient.RecyclerViewAdapter.MedicineAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Routine_Intake_Box extends AppCompatActivity {


    ArrayList<RoutineIntake_Pojo>  routine_Intake_List =new ArrayList<> ();
    RecyclerView RoutineRecyclerView;
    LinearLayoutManager linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_intake_box);

//Toolbar code
        //getting title from intent
        String titlename =getIntent().getStringExtra("Title name");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle(titlename);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //setting title on run time
        TextView toolbarTitle = findViewById(R.id.toolbartitle);
        toolbarTitle.setText(titlename);

        
        



        RoutineIntake_Pojo med1=new RoutineIntake_Pojo("Panadol 5mg", 10);
        RoutineIntake_Pojo med2=new RoutineIntake_Pojo("Brufin", 3);
        RoutineIntake_Pojo med3=new RoutineIntake_Pojo("Imodium", 9);
        RoutineIntake_Pojo med4=new RoutineIntake_Pojo("Disprin", 7);
        RoutineIntake_Pojo med5=new RoutineIntake_Pojo("dawai 5mg", 10);
        RoutineIntake_Pojo med6=new RoutineIntake_Pojo("dawai ", 3);
        RoutineIntake_Pojo med7=new RoutineIntake_Pojo("dawai ", 9);
        RoutineIntake_Pojo med8=new RoutineIntake_Pojo("dawai ", 7);
        RoutineIntake_Pojo med9=new RoutineIntake_Pojo("Panadol ", 10);
        RoutineIntake_Pojo med10=new RoutineIntake_Pojo("Brufin", 3);
        RoutineIntake_Pojo med11=new RoutineIntake_Pojo("Imodium", 9);
        RoutineIntake_Pojo med12=new RoutineIntake_Pojo("Disprin", 7);

        routine_Intake_List.add(med1);
        routine_Intake_List.add(med2);
        routine_Intake_List.add(med3);
        routine_Intake_List.add(med4);
        routine_Intake_List.add(med5);
        routine_Intake_List.add(med6);
        routine_Intake_List.add(med7);
        routine_Intake_List.add(med8);
        routine_Intake_List.add(med9);
        routine_Intake_List.add(med10);
        routine_Intake_List.add(med11);
        routine_Intake_List.add(med12);







        //Recycler view code to display medicing list and their quantity




        RoutineRecyclerView=findViewById(R.id.Routine_intake);

        MedicineAdapter routineIntakemanager = new MedicineAdapter(this, routine_Intake_List ); //passing array list "routine_Intake_List" inside it

        RoutineRecyclerView.setAdapter(routineIntakemanager);
        linearLayout = new LinearLayoutManager(this);
           RoutineRecyclerView.setLayoutManager(linearLayout);


           //buttom navigation menu click listening:
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.Home:
                        Toast.makeText(Routine_Intake_Box.this, "Home clicked ", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(getApplicationContext(), dashboard.class);
                        startActivity(i);
                        // Handle Home item selection
                        // Navigate to the Home page or perform related actions
                        return true;
                    case R.id.Record:

                        Toast.makeText(Routine_Intake_Box.this, "Record clicked ", Toast.LENGTH_SHORT).show();

                        // Handle Record item selection
                        // Navigate to the Record page or perform related actions
                        return true;
                    case R.id.Account:
                        Toast.makeText(Routine_Intake_Box.this, "Account clicked", Toast.LENGTH_SHORT).show();



                        return true;
                }
                return false;
            }
        });




    }

//Todo Back Butttom implementation

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