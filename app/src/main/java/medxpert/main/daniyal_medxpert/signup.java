package medxpert.main.daniyal_medxpert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class signup extends AppCompatActivity {

    private EditText dateOfBirthEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        dateOfBirthEditText = findViewById(R.id.dateOfBirthEditText);

        //Showing back button on toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }

    public void showDatePicker(View view) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Create a Calendar object for the selected date
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(year, monthOfYear, dayOfMonth);

                        // Get the current date
                        Calendar currentDate = Calendar.getInstance();

                        if (selectedDate.after(currentDate)) {
                            // If selected date is after the current date, show error message
                            TextInputLayout dateInputLayout = findViewById(R.id.date_EditText);
                            dateInputLayout.setErrorEnabled(true);
                            dateInputLayout.setError("Invalid date");

                            // You can also set the helper text color to red
                            dateInputLayout.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                        } else {
                            // Selected date is valid, update the date of birth EditText
                            String dateOfBirth = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                            dateOfBirthEditText.setText(dateOfBirth);

                            // Clear any existing error message
                            TextInputLayout dateInputLayout = findViewById(R.id.date_EditText);
                            dateInputLayout.setErrorEnabled(false);
                            dateInputLayout.setError(null);

                            // Set the default color to the helper text
                            dateInputLayout.setHelperTextColor(ColorStateList.valueOf(0xFF808080));
                        }
                    }
                },
                year,
                month,
                day
        );

        datePickerDialog.show();
    }


}