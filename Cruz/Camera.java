package com.example.windows10.gymbuff;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camera extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        image = (ImageView)findViewById(R.id.Image_View);
        Button camera = (Button)findViewById(R.id.camera_Button);
        camera.setOnClickListener(launch_Camera);
        Button returnMenu = (Button)findViewById(R.id.return_Menu);
        returnMenu.setOnClickListener(launch_Menu);
    }
    private View.OnClickListener launch_Camera = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dispatchTakePictureIntent();
        }
    };
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            image.setImageBitmap(imageBitmap);
        }
    }
    private View.OnClickListener launch_Menu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent menu = new Intent(Camera.this,Menu.class);
            startActivity(menu);
        }
    };
}
