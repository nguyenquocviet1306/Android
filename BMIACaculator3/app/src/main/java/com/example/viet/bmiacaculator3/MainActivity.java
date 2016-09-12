package com.example.viet.bmiacaculator3;


import android.graphics.Camera;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private ToggleButton tgFlashLight;
    private android.hardware.Camera camera;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCamera();
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");
        getReferences();
        addListerners();

    }

    void getReferences() {

        tgFlashLight = (ToggleButton) findViewById(R.id.tb_flash_light);
    }
   private void addListerners () {
       tgFlashLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//               Log.d(TAG,String.format("tgFlashLight check changed : %s", isChecked));
               if (isChecked) {
                   android.hardware.Camera.Parameters params = camera.getParameters();
                   params.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_TORCH);
                   camera.setParameters(params);
                   camera.startPreview();
//                   view.setBackgroundColor(Color.parseColor("#e7eecc"));
//                   view.invalidate();

               }
               else {
                   android.hardware.Camera.Parameters params = camera.getParameters();
                   params.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_OFF);
                   camera.setParameters(params);
                   camera.startPreview();
//                   view.setBackgroundColor(Color.parseColor("#303F9F"));
//                   view.invalidate();
               }
           }
       });
   }
    void getCamera() {
        try {
            camera = android.hardware.Camera.open();
        } catch (RuntimeException e) {
            Log.e(TAG,String.format("Could not open Camera %s ", e.getMessage()));
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG,"onSaveInstanceState");
    }
    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy");
        super.onDestroy();
    }
}
