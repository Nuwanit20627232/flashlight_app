package com.example.thoch1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    RelativeLayout layout;
    ImageButton imageButton;
    CameraManager cameraManager;
    String cameraId;
    Boolean state=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout=findViewById(R.id.offb);
        imageButton=findViewById(R.id.flashl1);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(state==false){
                     try{
                         cameraManager=(CameraManager)getSystemService(CAMERA_SERVICE);
                         cameraId=cameraManager.getCameraIdList()[0];
                         cameraManager.setTorchMode(cameraId,!state);
                         layout.setBackgroundResource(R.drawable.tochon);
                         state=true;

                     }catch (CameraAccessException e){
                         e.printStackTrace();
                     }
                 }

            else {
                     try {
                         cameraManager=(CameraManager)getSystemService(CAMERA_SERVICE);
                         cameraId=cameraManager.getCameraIdList()[0];
                         cameraManager.setTorchMode(cameraId,!state);
                         layout.setBackgroundResource(R.drawable.tochoff);
                         state=false;

                     }catch (CameraAccessException e){
                         e.printStackTrace();

                     }
                 }






            }
        });




    }
}