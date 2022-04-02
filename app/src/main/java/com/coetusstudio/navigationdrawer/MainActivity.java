 package com.coetusstudio.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.coetusstudio.navigationdrawer.databinding.ActivityLoginBinding;
import com.coetusstudio.navigationdrawer.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     CardView sendNotification, lecture, studentDetails, addNewStudent, feesDetails, chat, createForm, notes;
     DrawerLayout drawerLayout;
     NavigationView navigationView;
     Toolbar toolbar;
     ActivityMainBinding binding;
     FirebaseAuth auth;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         binding = ActivityMainBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());


         sendNotification = findViewById(R.id.sendNotification);
         lecture = findViewById(R.id.lecture);
         studentDetails = findViewById(R.id.studentDetails);
         addNewStudent = findViewById(R.id.addNewStudent);
         feesDetails = findViewById(R.id.feesDetails);
         chat = findViewById(R.id.chat);
         createForm = findViewById(R.id.createForm);
         notes = findViewById(R.id.notes);

         sendNotification.setOnClickListener(this);
         lecture.setOnClickListener(this);
         studentDetails.setOnClickListener(this);
         addNewStudent.setOnClickListener(this);
         feesDetails.setOnClickListener(this);
         chat.setOnClickListener(this);
         createForm.setOnClickListener(this);
         notes.setOnClickListener(this);


         drawerLayout = findViewById(R.id.drawerLayout);
         navigationView = findViewById(R.id.navigationView);
         toolbar = findViewById(R.id.toolbar);

         auth = FirebaseAuth.getInstance();

         //step1
         setSupportActionBar(toolbar);

         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);

         drawerLayout.addDrawerListener(toggle);

         toggle.syncState();

         navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                 int id = item.getItemId();

                 if (id == R.id.optProfile) {

                 } else if (id == R.id.optSendNotification) {
                     Intent intent = new Intent(MainActivity.this, SendnotificationActivity.class);
                     startActivity(intent);

                 } else if (id == R.id.optPrivacyPolicy) {

                 } else if (id == R.id.optAboutUs) {

                 } else if (id == R.id.optLogout) {
                     auth.signOut();

                 } else {

                 }

                 drawerLayout.closeDrawer(GravityCompat.START);

                 return true;
             }
         });
     }

     @Override
     public void onBackPressed() {
         if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
             drawerLayout.closeDrawer(GravityCompat.START);
         } else {
             super.onBackPressed();
         }
     }

     private void loadFragment(Fragment fragment) {

         FragmentManager fm = getSupportFragmentManager();
         FragmentTransaction ft = fm.beginTransaction();

         ft.add(R.id.action_bar_container, fragment);
         ft.commit();


     }

     @Override
     public void onClick(View view) {
         switch (view.getId()) {
             case R.id.sendNotification:
                 Intent intent = new Intent(MainActivity.this, SendnotificationActivity.class);
                 startActivity(intent);
                 break;
             case R.id.lecture:
                 Intent intent1 = new Intent(MainActivity.this, LectureActivity.class);
                 startActivity(intent1);
                 break;
             case R.id.studentDetails:
                 Intent intent2 = new Intent(MainActivity.this, StudentdetailsActivity.class);
                 startActivity(intent2);
                 break;
             case R.id.addNewStudent:
                 Intent intent3 = new Intent(MainActivity.this, AddnewstudentActivity.class);
                 startActivity(intent3);
             case R.id.feesDetails:
                 Intent intent4 = new Intent(MainActivity.this, FeesdetailsActivity.class);
                 startActivity(intent4);
                 break;
             case R.id.chat:
                 Intent intent5 = new Intent(MainActivity.this, ChatActivity.class);
                 startActivity(intent5);
                 break;
             case R.id.createForm:
                 Intent intent6 = new Intent(MainActivity.this, CreateformActivity.class);
                 startActivity(intent6);
                 break;
             case R.id.notes:
                 Intent intent7 = new Intent(MainActivity.this, NotesActivity.class);
                 startActivity(intent7);
                 break;
         }

     }
 }