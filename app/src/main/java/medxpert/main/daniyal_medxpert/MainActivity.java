package medxpert.main.daniyal_medxpert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.register);
        String html = "<font color=" + Color.BLACK + ">Not a member? </font><font color= #0755E9"
                + "> Register Now!!</font>";
        textView.setText(Html.fromHtml(html));


        Button btn=findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),OTP.class));
            }
        });
    }
}