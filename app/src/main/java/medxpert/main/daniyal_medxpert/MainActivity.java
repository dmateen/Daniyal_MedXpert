package medxpert.main.daniyal_medxpert;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    private AppBarConfiguration appBarConfiguration;
//private ActivityMainBinding binding;
    BottomNavigationView bottom_navigation;

    ListView mlistView;
    ArrayList<String> my_array_list;
    ArrayAdapter<String> my_array_Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//
//        // using toolbar as ActionBar
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        //getSupportActionBar().setTitle(0);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        //bottom navigation by chat gpt //todo Single click test
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.Home:
                        Toast.makeText(MainActivity.this, "Home clicked ", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(getApplicationContext(), dashboard.class);
                        startActivity(i);
                        // Handle Home item selection
                        // Navigate to the Home page or perform related actions
                        return true;
                    case R.id.Record:

                        Toast.makeText(MainActivity.this, "Record clicked ", Toast.LENGTH_SHORT).show();


                        return true;
                    case R.id.Account:
                        Toast.makeText(MainActivity.this, "Account clicked", Toast.LENGTH_SHORT).show();



                        return true;
                }
                return false;
            }
        });



        //list display starts here

        mlistView=findViewById(R.id.medical_box_list);

         my_array_list=new ArrayList<>();
        my_array_list.add("Medical box 1");
        my_array_list.add("Medical box 2");
        my_array_list.add("Medical box 3");
        my_array_list.add("Medical box 4");
        my_array_list.add("Medical box 5");
        my_array_list.add("Medical box 6");
        my_array_list.add("Medical box 7");
        my_array_list.add("Medical box 8");

        my_array_Adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,my_array_list);
        mlistView.setAdapter(my_array_Adapter);

        //detecting click on list items
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int item_position, long id) {
                //Toast.makeText(MainActivity.this, my_array_list.get(position)+ " clicked", Toast.LENGTH_SHORT).show();



                Intent i = new Intent(MainActivity.this, Routine_Intake_Box.class);
                String titlename = my_array_list.get(item_position);
                // on below line we are passing
                // data to our new activity.
                i.putExtra("Title name", titlename);


                startActivity(i);


            }
        });

        mlistView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //deleting item on click by showing an alert box
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Are you sure you want to delete " + my_array_list.get(position) +" from list?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                my_array_list.remove(position);
                                my_array_Adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();
                return true; // Return true to consume the long click event
            }
        });

        //TODO  done hehe
        //add a floating button to add more medical boxes by using alert box
        // and use:  my_array_list.add(input coming from alert box); //to update arraylist
        //   my_array_Adapter.notifyDataSetChanged(); //to update adapter

        //handling floating button click
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInputDialog();  // function below
            }
        });

    } //on create ending here

    private void showInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Text");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String text = input.getText().toString();
                my_array_list.add(text);
                my_array_Adapter.notifyDataSetChanged();
                // Do something with the entered text
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    // home back button
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

