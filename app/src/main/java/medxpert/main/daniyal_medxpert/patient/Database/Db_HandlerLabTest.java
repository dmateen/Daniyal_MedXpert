package medxpert.main.daniyal_medxpert.patient.Database;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import medxpert.main.daniyal_medxpert.patient.POJO.Report;
import medxpert.main.daniyal_medxpert.patient.SessionManager.SessionManager;

public class Db_HandlerLabTest {

    private DatabaseReference databaseRef;



    public Db_HandlerLabTest(String rootNode) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();  //https://medxpert-2023-default-rtdb.firebaseio.com/
        databaseRef = database.getReference(rootNode);   //labTests


    }

    public void addReportToDB(Report report,Context context) {
        // Generate a unique ID for the report
        String reportId = databaseRef.push().getKey();

        // Add the report to the "Labtest" node with the generated ID
        databaseRef.child(reportId).setValue(report).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    // Report added successfully to the database

                    // Get the CNIC of the current patient from SessionManager
                    String cnic = new SessionManager(context).getCNIC();

                    // Get the reference to the "labReports" node for the current patient
                    DatabaseReference labReportsRef = FirebaseDatabase.getInstance().getReference("Patients").child(cnic).child("labReports");

                    // Add the report ID to the ArrayList of labReports
                    labReportsRef.push().setValue(reportId).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                // Report ID added successfully to the labReports ArrayList
                                // You can perform any additional actions or callbacks here
                            } else {
                                // Failed to add report ID to labReports ArrayList
                                // You can handle the failure case or perform any additional actions or callbacks here
                            }
                        }
                    });
                } else {
                    // Failed to add report to the database
                    // You can handle the failure case or perform any additional actions or callbacks here
                }
            }
        });
    }

}
