package com.example.alumno.practica7;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    Button bfoto_gallery;
    ImageView foto_gallery;
    private ProgressDialog progressDialog;
    static final int MY_REQUEST_READ_GALLERY = 14;
    int asd = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       bfoto_gallery = (Button)findViewById(R.id.button);
       foto_gallery = (ImageView) findViewById(R.id.imageView);

        bfoto_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
    public void enviar(View v){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMax(100);
        progressDialog.setMessage("Enviando...");
        progressDialog.setTitle("Enviar");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while(progressDialog.getProgress()<=progressDialog.getMax()){
                        Thread.sleep(200);
                        handle.sendMessage(handle.obtainMessage());
                        if(progressDialog.getProgress() == progressDialog.getMax()){
                            progressDialog.dismiss();
                            asd++;
                        }
                    }
                    tst(asd);
                }catch (Exception e){}
            }

        }).start();
    }
    Handler handle = new Handler(){
        @Override
        public void handleMessage(Message g){
            super.handleMessage(g);
            progressDialog.incrementProgressBy(1);
        }
    };

    public void tst(int i){
        if(i>0) {
            Toast toast;
            toast = Toast.makeText(getApplicationContext(), "ad", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            foto_gallery.setImageURI(imageUri);
        }
    }
}
