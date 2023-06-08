package medxpert.main.daniyal_medxpert.Database;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import medxpert.main.daniyal_medxpert.POJO.SignupUser;

public class Db_Handler {

    private DatabaseReference databaseRef;

    public Db_Handler(String rootNode) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();  //https://medxpert-2023-default-rtdb.firebaseio.com/
        databaseRef = database.getReference(rootNode);   //patients
    }

    public void writeData(String node, Object data) {
        DatabaseReference nodeRef = databaseRef.child(node);
        nodeRef.setValue(data)
                .addOnSuccessListener(aVoid -> {
                    // Data is successfully written to the database
                    // Proceed with any additional steps or actions
                })
                .addOnFailureListener(e -> {
                    // An error occurred while writing data to the database
                    // Handle the error
                });
    }

//    public boolean checkLogin(String cnic, String password, LoginCallback logged_in) {
//        Query query = databaseRef.orderByChild("cnic").equalTo(cnic);
//
//        DataSnapshot dataSnapshot = query.get().getResult();
//
//        if (dataSnapshot.exists()) {
//            for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
//                String storedPassword = childSnapshot.child("password").getValue(String.class);
//                if (storedPassword != null && storedPassword.equals(password)) {
//                    return true; // CNIC and password match found
//                }
//            }
//        }
//
//        return false; // CNIC and password not found or do not match
//
//
//    }

//    public static void checkLogintest(String cnic, String password, final LoginCallback callback) {
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
//        Query query = databaseReference.child("patients").orderByChild("cnic").equalTo(cnic);
//
//        query.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
//                        String storedPassword = childSnapshot.child("password").getValue(String.class);
//                        if (storedPassword != null && storedPassword.equals(password)) {
//                            callback.onLoginSuccess(); // CNIC and password match found
//                            return;
//                        }
//                    }
//                }
//                callback.onLoginFailure(); // CNIC and password not found or do not match
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                callback.onLoginFailure(); // Error occurred
//            }
//        });
//    }
//
    public interface LoginCallback {
        void onLoginSuccess();
        void onLoginFailure();
    }


    public void login(String cnic, String password, Context context, final LoginCallback callback) {
        DatabaseReference databaseReference = databaseRef.child(cnic);
        databaseReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {
                        Toast.makeText(context, "Read Successfully", Toast.LENGTH_SHORT).show();
                        DataSnapshot snapshot = task.getResult();
                        String db_password = snapshot.child("password").getValue(String.class);

                        if (!password.equals(db_password))
                            callback.onLoginFailure();
                        else
                            callback.onLoginSuccess();
                    } else {

                        callback.onLoginFailure();
                    }
                } else {
                    callback.onLoginFailure();
                }
            }
        });
    }








    // Add additional methods for reading, updating, deleting data, etc.
}
