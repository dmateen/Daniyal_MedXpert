package medxpert.main.daniyal_medxpert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.Calendar;

import medxpert.main.daniyal_medxpert.Database.Db_Handler;
import medxpert.main.daniyal_medxpert.POJO.SignupUser;

public class signup extends AppCompatActivity {

    private TextInputLayout firstNameEditText;
    private TextInputLayout lastNameEditText;
    private TextInputLayout cnicEditText;
    private EditText dateOfBirthEditText;
    private RadioGroup genderRadioGroup;
    private TextInputLayout countryCodeEditText;
    private TextInputLayout phoneNumberEditText;
    private TextInputLayout passwordEditText;

    String firstName;
    String lastName;
    String cnic;
    String dateOfBirth;
    String gender;
    String countryCode;
    String phoneNumber;
    String password;

    private Db_Handler dbHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        dbHandler=new Db_Handler("patients");

        //Showing back button on toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        // Initialize the EditText views
        firstNameEditText = findViewById(R.id.firstName_EditText);
        lastNameEditText = findViewById(R.id.lastName_EditText);
        cnicEditText = findViewById(R.id.cnic_EditText);
        countryCodeEditText = findViewById(R.id.countryCodeInputLayout);
        phoneNumberEditText = findViewById(R.id.phoneNumberInputLayout);
        passwordEditText = findViewById(R.id.password_EditText);
        dateOfBirthEditText = findViewById(R.id.dateOfBirthEditText);


        //Adding Listeners
        firstNameEditText.getEditText().setOnFocusChangeListener(firstNameFocusChangeListener);
        lastNameEditText.getEditText().setOnFocusChangeListener(lastNameFocusChangeListener);
        cnicEditText.getEditText().setOnFocusChangeListener(cnicFocusChangeListener);
        countryCodeEditText.getEditText().setOnFocusChangeListener(countryCodeFocusChangeListener);
        phoneNumberEditText.getEditText().setOnFocusChangeListener(phoneNumberFocusChangeListener);
        passwordEditText.getEditText().setOnFocusChangeListener(passwordFocusChangeListener);


    }

    // Define OnFocusChangeListener for each field
    private View.OnFocusChangeListener firstNameFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                firstNameEditText = findViewById(R.id.firstName_EditText);
                firstName = firstNameEditText.getEditText().getText().toString().trim();
                if (!validateFirstName(firstName)) {
                    firstNameEditText.setError("Invalid first name");
                } else {
                    firstNameEditText.setError(null);
                }
            }
        }
    };


    private View.OnFocusChangeListener lastNameFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                lastName = lastNameEditText.getEditText().getText().toString().trim();
                if (!validateLastName(lastName)) {
                    lastNameEditText.setError("Invalid last name");
                } else {
                    lastNameEditText.setError(null);
                }
            }
        }
    };

    private View.OnFocusChangeListener cnicFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                cnic = cnicEditText.getEditText().getText().toString().trim();
                if (!validateCNIC(cnic)) {
                    cnicEditText.setError("Invalid CNIC - Must be 13 numbers without dashes");
                } else {
                    cnicEditText.setError(null);
                }
            }
        }
    };


    private View.OnFocusChangeListener countryCodeFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                countryCode = countryCodeEditText.getEditText().getText().toString().trim();
                if (!validateCountryCode(countryCode)) {
                    countryCodeEditText.setError("Invalid country code");
                } else {
                    countryCodeEditText.setError(null);
                }
            }
        }
    };

    private View.OnFocusChangeListener phoneNumberFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                phoneNumber = phoneNumberEditText.getEditText().getText().toString().trim();
                if (!validatePhoneNumber(phoneNumber)) {
                    phoneNumberEditText.setError("Invalid phone number");
                } else {
                    phoneNumberEditText.setError(null);
                }
            }
        }
    };

    private View.OnFocusChangeListener passwordFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                password = passwordEditText.getEditText().getText().toString().trim();
                if (!validatePassword(password)) {
                    passwordEditText.setError("Invalid password - Must be 8 characters atleast ");
                } else {
                    passwordEditText.setError(null);
                }
            }
        }

    };

    public void moveToLogin(View view){
        this.startActivity(new Intent(this,login.class));
    }

    //Function when register button is clicked
    public void signUp(View view) {

        dateOfBirth = dateOfBirthEditText.getText().toString();
        genderRadioGroup = findViewById(R.id.genderRadioGroup);

        if(!validateFields(view))
            return;


        // Initialize the EditText views

        gender = ((RadioButton) findViewById(genderRadioGroup.getCheckedRadioButtonId())).getText().toString();




        // Create a data object to represent the user's data
        SignupUser user = new SignupUser(firstName, lastName, cnic, dateOfBirth, gender, countryCode, phoneNumber, password);
//
//        // Write the data to the database using the DbHandler instance
//        dbHandler.writeData("Patient_Users", user);
//
        Toast.makeText(this, firstName+" "+lastName+" "+cnic+" "+gender+" "+dateOfBirth+" "+countryCode+" "+phoneNumber+" "+password, Toast.LENGTH_SHORT).show();
    }

    // Function to validate first name
    private boolean validateFirstName(String firstName) {
        // Perform validation here
        // You can modify this function based on your validation rules for the first name
        // Return true if the first name is valid, false otherwise
        return firstName.matches("[a-zA-Z ]+");
    }

    // Function to validate last name
    private boolean validateLastName(String lastName) {
        // Perform validation here
        // You can modify this function based on your validation rules for the last name
        // Return true if the last name is valid, false otherwise
        return lastName.matches("[a-zA-Z ]+");
    }

    // Function to validate CNIC
    private boolean validateCNIC(String cnic) {
        // Perform validation here
        // You can modify this function based on your validation rules for the CNIC
        // Return true if the CNIC is valid, false otherwise
        return cnic.matches("[0-9]{13}");
    }


    // Function to validate country code
    private boolean validateCountryCode(String countryCode) {
        // Perform validation here
        // You can modify this function based on your validation rules for the country code
        // Return true if the country code is valid, false otherwise
        return countryCode.matches("[0-9]+");
    }

    // Function to validate phone number
    private boolean validatePhoneNumber(String phoneNumber) {
        // Perform validation here
        // You can modify this function based on your validation rules for the phone number
        // Return true if the phone number is valid, false otherwise
        return phoneNumber.matches("[0-9]+");
    }

    // Function to validate password
    private boolean validatePassword(String password) {
        // Perform validation here
        // You can modify this function based on your validation rules for the password
        // Return true if the password is valid, false otherwise
        return password.length() >= 8;
    }

    private boolean validateFields(View view) {
        // Validate first name
        String firstName = firstNameEditText.getEditText().getText().toString().trim();
        if (firstName.isEmpty()) {
            firstNameEditText.setError("First name is required");
            return false;
        } else {
            firstNameEditText.setError(null);
        }

        // Validate last name
        String lastName = lastNameEditText.getEditText().getText().toString().trim();
        if (lastName.isEmpty()) {
            lastNameEditText.setError("Last name is required");
            return false;
        } else {
            lastNameEditText.setError(null);
        }

        // Validate CNIC
        String cnic = cnicEditText.getEditText().getText().toString().trim();
        String cnicRegex = "^[0-9]{13}$"; // Example regex for CNIC format
        if (!cnic.matches(cnicRegex)) {
            cnicEditText.setError("Invalid CNIC format");
            return false;
        } else {
            cnicEditText.setError(null);
        }

        // Validate date of birth
        String dateOfBirth = dateOfBirthEditText.getText().toString().trim();
        if (dateOfBirth.isEmpty()) {
            // Perform date validation logic here, similar to the previous example
            // ...

            // For example, if date is invalid:
            dateOfBirthEditText.setError("Invalid date");
            return false;
        } else {
            dateOfBirthEditText.setError(null);
        }

        // Validate gender
        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        if (selectedGenderId == -1) {

            TextView genderHelperText= findViewById(R.id.genderHelperText);
            genderHelperText.setTextColor(Color.RED);

            return false;
        }
        else{
            TextView genderHelperText= findViewById(R.id.genderHelperText);
            genderHelperText.setTextColor(ColorStateList.valueOf(0xFF808080));
        }

        // Validate country code
        countryCode = "+"+countryCodeEditText.getEditText().getText().toString();

        String countryCodeRegex = "^[+][0-9]{1,3}$"; // Example regex for country code format: starts with '+' followed by 1 to 3 digits
        Toast.makeText(this, countryCode, Toast.LENGTH_SHORT).show();
        if (!countryCode.matches(countryCodeRegex)) {
            countryCodeEditText.setError("Invalid country code format");
            return false;
        } else {
            countryCodeEditText.setError(null);
        }

        // Validate phone number
        String phoneNumber = phoneNumberEditText.getEditText().getText().toString().trim();
        String phoneNumberRegex = "^[0-9]{10}$"; // Example regex for 10-digit phone number
        if (!phoneNumber.matches(phoneNumberRegex)) {
            phoneNumberEditText.setError("Invalid phone number format");
            return false;
        } else {
            phoneNumberEditText.setError(null);
        }

        // Validate password
         password = passwordEditText.getEditText().getText().toString();
        // Perform validation logic for password, if required
        // ...

        // All fields are valid
        return true;
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
                            TextInputLayout dateInputLayout = findViewById(R.id.dateOfBirthInputLayout);
                            dateInputLayout.setErrorEnabled(true);
                            dateInputLayout.setError("Invalid date");

                            // You can also set the helper text color to red
                            dateInputLayout.setHelperTextColor(ColorStateList.valueOf(Color.RED));
                        } else {
                            // Selected date is valid, update the date of birth EditText
                            String dateOfBirth = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                            dateOfBirthEditText.setText(dateOfBirth);

                            // Clear any existing error message
                            TextInputLayout dateInputLayout = findViewById(R.id.dateOfBirthInputLayout);
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