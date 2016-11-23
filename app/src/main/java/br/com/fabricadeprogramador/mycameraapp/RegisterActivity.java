package br.com.fabricadeprogramador.mycameraapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.camera.CropImageIntentBuilder;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 123;
    private static final int CROP_REQUEST = 456;

    Uri imageUri;

    @Bind(R.id.user_image)
    ImageView userImage;

    @Bind(R.id.name)
    EditText userName;

    @Bind(R.id.email)
    EditText userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.user_image)
    public void changeImage(){

        File image = new File(getExternalCacheDir(), "foto.jpg");
        imageUri = Uri.fromFile(image);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        File croppedImage = new File(getFilesDir(), "croppedFoto.jpg");

        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK){
            Uri croppedImageUri = Uri.fromFile(croppedImage);
            CropImageIntentBuilder crop = new CropImageIntentBuilder(200, 200, croppedImageUri);
            crop.setCircleCrop(true);
            crop.setOutlineCircleColor(0xFF03A9F4);
            crop.setSourceImage(imageUri);
            startActivityForResult(crop.getIntent(RegisterActivity.this), CROP_REQUEST);

        } else if(requestCode == CROP_REQUEST && resultCode == RESULT_OK){
            userImage.setImageBitmap(BitmapFactory.decodeFile(croppedImage.getAbsolutePath()));
            //Toast.makeText(this, "Imagem Não Carregada!", Toast.LENGTH_SHORT).show();
        }
    }
}
