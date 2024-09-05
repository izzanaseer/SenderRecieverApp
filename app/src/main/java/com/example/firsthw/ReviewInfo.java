package com.example.firsthw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReviewInfo extends AppCompatActivity {

    TextView tvRCountry, tvRfullName, tvRaddress, tvRcontactInfo;
    TextView tvSCountry, tvSfullName, tvSaddress, tvScontactInfo;
    View fab_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_review_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //        HOOKS
        tvRCountry = findViewById(R.id.tvRCountry);
        tvRfullName = findViewById(R.id.tvRName);
        tvRaddress = findViewById(R.id.tvRAddress);
        tvRcontactInfo = findViewById(R.id.tvRContact);

        tvSCountry = findViewById(R.id.tvSCountry);
        tvSfullName = findViewById(R.id.tvSName);
        tvSaddress = findViewById(R.id.tvSAddress);
        tvScontactInfo = findViewById(R.id.tvSContact);

        fab_add = findViewById(R.id.fab_add);


        Intent intent = getIntent();
        String countryS = intent.getStringExtra("Rcountry");
        String fullcountryNameS = intent.getStringExtra("RfullcountryName");
        String addressS = intent.getStringExtra("Raddress");
        String contactInfoS = intent.getStringExtra("RcontactInfo");

        String countryR = intent.getStringExtra("Scountry");
        String fullcountryNameR = intent.getStringExtra("SfullcountryName");
        String addressR = intent.getStringExtra("Saddress");
        String contactInfoR = intent.getStringExtra("ScontactInfo");


        tvRCountry.setText(countryR);
        tvRfullName.setText(fullcountryNameR);
        tvRaddress.setText(addressR);
        tvRcontactInfo.setText(contactInfoR);

        tvSCountry.setText(countryS);
        tvSfullName.setText(fullcountryNameS);
        tvSaddress.setText(addressS);
        tvScontactInfo.setText(contactInfoS);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReviewInfo.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}