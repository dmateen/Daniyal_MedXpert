package medxpert.main.daniyal_medxpert.doctor.Database;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import medxpert.main.daniyal_medxpert.doctor.POJO.SignupUser_Pojo;

public class doctor_Db_HandlerUpdateProfile {
    private DatabaseReference databaseRef;
    SignupUser_Pojo userPojo;

    public doctor_Db_HandlerUpdateProfile(String rootNode) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();  //https://medxpert-2023-default-rtdb.firebaseio.com/
        databaseRef = database.getReference(rootNode);
    }

    public void getRecord(String toString, GetRecordCallbackdoctor getRecordCallback) {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    SignupUser_Pojo userPojo = dataSnapshot.getValue(SignupUser_Pojo.class);
                    getRecordCallback.onSuccess(userPojo);
                } else {
                    getRecordCallback.onFailure("Record not found.");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                getRecordCallback.onFailure(databaseError.getMessage());
            }
        };

        databaseRef.child(toString).addListenerForSingleValueEvent(valueEventListener);
    }

    public interface GetRecordCallbackdoctor {
        void onSuccess(SignupUser_Pojo userPojo);
        void onFailure(String errorMessage);
    }
}
