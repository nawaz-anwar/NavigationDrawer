package com.coetusstudio.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.cast.framework.media.ImagePicker;

public class First_Activity extends AppCompatActivity implements View.OnClickListener{

    Button btnFacultyLogin, btnHodDean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btnFacultyLogin = findViewById(R.id.btnFacultyLogin);
        btnHodDean = findViewById(R.id.btnHodDean);

        btnFacultyLogin.setOnClickListener(this);
        btnHodDean.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFacultyLogin:
                Intent intent = new Intent(First_Activity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btnHodDean:
                Intent intent1 = new Intent(First_Activity.this, SignupActivity.class);
                startActivity(intent1);
                break;

        }
    }


}