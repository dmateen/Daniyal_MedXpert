package medxpert.main.daniyal_medxpert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import medxpert.main.daniyal_medxpert.Database.Db_Handler;
import medxpert.main.daniyal_medxpert.SessionManager.SessionManager;

public class login extends AppCompatActivity {

    private Db_Handler dbHandler;

    TextInputLayout cnicLayout;
    TextInputLayout passwordLayout;

    String cnic;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Getting data about session
        SessionManager sessionManager= new SessionManager(this);
        if(sessionManager.isLoggedIn())
            startActivity(new Intent(this, dashboard.class));


        //Showing back button on toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView textView = findViewById(R.id.register);
        String html = "<font color=#808080"  + ">Not a member? </font><font color= #0755E9"
                + "> Register Now!!</font>";
        textView.setText(Html.fromHtml(html));

    }

    public void loginBtnClicked(View view){

        cnicLayout = findViewById(R.id.cnic_EditText);
        passwordLayout = findViewById(R.id.password_EditText);

        cnic = cnicLayout.getEditText().getText().toString().trim();
        password = passwordLayout.getEditText().getText().toString().trim();

        if (cnic.isEmpty() || password.isEmpty()) {
            Toast.makeText(login.this, "Please enter CNIC and password", Toast.LENGTH_SHORT).show();
        } else {
            performLogin(cnic, password);
        }

    }

    private void performLogin(String cnic, String password) {
        dbHandler = new Db_Handler("patients");
        dbHandler.login(cnic, password, this, new Db_Handler.LoginCallback() {
            @Override
            public void onLoginSuccess() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(login.this, "Logged In", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(login.this, dashboard.class));
                    }
                });
            }

            @Override
            public void onLoginFailure() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(login.this, "CNIC or Password not correct", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


}