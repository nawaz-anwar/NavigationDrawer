package com.coetusstudio.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddnewstudentActivity extends AppCompatActivity {

    Button addStudent, updateAndDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewstudent);

        addStudent = findViewById(R.id.addStudent);
        updateAndDelete = findViewById(R.id.updateAndDelete);

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddnewstudentActivity.this, AddstudentActivity.class);
                startActivity(intent);
            }
        });

        updateAndDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddnewstudentActivity.this, UpdateanddeleteActivity.class);
                startActivity(intent);
            }
        });

    }
}