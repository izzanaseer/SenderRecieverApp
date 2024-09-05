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

public class rDetail extends AppCompatActivity {

    Button nextButton;
    EditText etRemail, etRCountry, etRfullName, etRaddress, etRcontactInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rdetail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //      HOOKS
        nextButton = findViewById(R.id.btnRnext);
        etRemail = findViewById(R.id.etRemail);
        etRCountry = findViewById(R.id.etRcountry);
        etRfullName = findViewById(R.id.etRfullName);
        etRaddress = findViewById(R.id.etRaddress);
        etRcontactInfo = findViewById(R.id.etRcontactInfo);

        Intent intent1 = getIntent();
        String emailS = intent1.getStringExtra("Semail");
        String countryS = intent1.getStringExtra("Scountry");
        String fullcountryNameS = intent1.getStringExtra("SfullcountryName");
        String addressS = intent1.getStringExtra("Saddress");
        String contactInfoS = intent1.getStringExtra("ScontactInfo");

        // Set an onClickListener to the Next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailR = etRemail.getText().toString().trim();
                String countryR = etRCountry.getText().toString().trim();
                String fullcountryNameR = etRfullName.getText().toString().trim();
                String addressR = etRaddress.getText().toString().trim();
                String contactInfoR = etRcontactInfo.getText().toString().trim();

                if(emailR.isEmpty() || countryR.isEmpty() || fullcountryNameR.isEmpty() || addressR.isEmpty() || contactInfoR.isEmpty()){
                    Toast.makeText(rDetail.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else if (!emailR.contains("@gmail.com")) {
                    Toast.makeText(rDetail.this, "Please enter correct format for Email", Toast.LENGTH_SHORT).show();
                }
                else {
                    // Intent to navigate to ReviewInfo
                    Intent intent = new Intent(rDetail.this, ReviewInfo.class);
                    intent.putExtra("Remail", emailR);
                    intent.putExtra("Rcountry", countryR);
                    intent.putExtra("RfullcountryName", fullcountryNameR);
                    intent.putExtra("Raddress", addressR);
                    intent.putExtra("RcontactInfo", contactInfoR);

                    intent.putExtra("Semail", emailS);
                    intent.putExtra("Scountry", countryS);
                    intent.putExtra("SfullcountryName", fullcountryNameS);
                    intent.putExtra("Saddress", addressS);
                    intent.putExtra("ScontactInfo", contactInfoS);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}