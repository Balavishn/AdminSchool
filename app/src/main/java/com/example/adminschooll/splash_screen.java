package com.example.adminschooll;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;



public class splash_screen extends AppCompatActivity {

    Animation top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        ImageView topp=findViewById(R.id.imageView5);
        top= AnimationUtils.loadAnimation(this,R.anim.top_anime);
        topp.setAnimation(top);





        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(checkPermission()){
                    startActivity(new Intent(getApplicationContext(), Dashboard.class));
                    finish();
                }

            }
        },2000);



    }
    public boolean checkPermission() {
        int READ_EXTERNAL_PERMISSION = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if((READ_EXTERNAL_PERMISSION != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
            return false;
        }
        return true;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==0 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //do somethings
            Toast.makeText(getApplicationContext(),"granted",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), Dashboard.class));
            finish();
        }
        else {
            System.exit(0);
        }
    }
}