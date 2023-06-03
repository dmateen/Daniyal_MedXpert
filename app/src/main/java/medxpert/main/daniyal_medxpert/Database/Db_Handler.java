package medxpert.main.daniyal_medxpert.Database;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Db_Handler {

    private DatabaseReference databaseRef;

    public Db_Handler(String rootNode) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference(rootNode);
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

    // Add additional methods for reading, updating, deleting data, etc.
}
