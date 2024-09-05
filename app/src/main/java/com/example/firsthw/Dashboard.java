package com.example.firsthw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dashboard extends AppCompatActivity {

    Button nextButton;
    EditText etSemail, etSCountry, etSfullName, etSaddress, etScontactInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //      HOOKS
        nextButton = findViewById(R.id.btnSnext);
        etSemail = findViewById(R.id.etSemail);
        etSCountry = findViewById(R.id.etScountry);
        etSfullName = findViewById(R.id.etSfullName);
        etSaddress = findViewById(R.id.etSaddress);
        etScontactInfo = findViewById(R.id.etScontactInfo);


        // Set an onClickListener to the Next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etSemail.getText().toString().trim();
                String country = etSCountry.getText().toString().trim();
                String fullcountryName = etSfullName.getText().toString().trim();
                String address = etSaddress.getText().toString().trim();
                String contactInfo = etScontactInfo.getText().toString().trim();

                if(email.isEmpty() || country.isEmpty() || fullcountryName.isEmpty() || address.isEmpty() || contactInfo.isEmpty()){
                    Toast.makeText(Dashboard.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else if (!email.contains("@gmail.com")) {
                    Toast.makeText(Dashboard.this, "Please enter correct format for Email", Toast.LENGTH_SHORT).show();
                } else {
                    // Intent to navigate to rDetail (Receiver Details)
                    Intent intent = new Intent(Dashboard.this, rDetail.class);
                    intent.putExtra("Semail", email);
                    intent.putExtra("Scountry", country);
                    intent.putExtra("SfullcountryName", fullcountryName);
                    intent.putExtra("Saddress", address);
                    intent.putExtra("ScontactInfo", contactInfo);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}