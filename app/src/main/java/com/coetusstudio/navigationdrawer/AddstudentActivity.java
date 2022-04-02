package com.coetusstudio.navigationdrawer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.coetusstudio.navigationdrawer.models.users;
import com.coetusstudio.navigationdrawer.models.usersStudent;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.Random;

public class AddstudentActivity extends AppCompatActivity {

    EditText stName, stMail, stAddmissionNumber, stEnrollmentNumber, stBranch, stSemester, stPassword;
    ImageView studentImg;
    Button btnAdded;
    Bitmap bitmap;
    private static final int PICK_IMAGE_REQUEST = 4;
    Uri filepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);

        stName = findViewById(R.id.edtName);
        stMail = findViewById(R.id.edtMail);
        stAddmissionNumber = findViewById(R.id.edtAddmissionNumber);
        stEnrollmentNumber = findViewById(R.id.edtEnrollmentNumber);
        stBranch = findViewById(R.id.edtBranch);
        stSemester = findViewById(R.id.edtSemester);
        stBranch = findViewById(R.id.edtPassword);
        studentImg = findViewById(R.id.studentImg);
        btnAdded = findViewById(R.id.btnAdded);


        studentImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(
                        Intent.createChooser(
                                intent,
                                "Select Image from here..."),
                        PICK_IMAGE_REQUEST);


            }
        });


        btnAdded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadtofirebase();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            // Get the Uri of data
            filepath = data.getData();
            try {

                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                filepath);
                studentImg.setImageBitmap(bitmap);
            }

            catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }
    }

    private void uploadtofirebase() {

        final ProgressDialog dialog=new ProgressDialog(this);
        dialog.setTitle("Student Added");
        dialog.show();

        FirebaseStorage storage=FirebaseStorage.getInstance();
        final StorageReference uploader=storage.getReference("Image1"+new Random().nextInt(50));

        uploader.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                    {
                        uploader.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri){

                                dialog.dismiss();
                                FirebaseDatabase db=FirebaseDatabase.getInstance();
                                DatabaseReference root=db.getReference("Student Details");

                                usersStudent obj=new usersStudent(stName.getText().toString(),stMail.getText().toString(),stEnrollmentNumber.getText().toString(),stBranch.getText().toString(),stSemester.getText().toString(),stPassword.getText().toString(),uri.toString());
                                root.child(stAddmissionNumber.getText().toString()).setValue(obj);

                                stName.setText("");
                                stMail.setText("");
                                stAddmissionNumber.setText("");
                                stEnrollmentNumber.setText("");
                                stBranch.setText("");
                                stSemester.setText("");
                                stPassword.setText("");
                                studentImg.setImageResource(R.drawable.manimg);

                            }
                        });
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot)
                    {
                        float percent=(100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                        dialog.setMessage("Uploaded :"+(int)percent+" %");
                    }
                });
    }


}
