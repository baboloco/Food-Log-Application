package jacoblazo.finalfinal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

//LOGS ACTIVITY CONTAINS: all the images taken by the camera of foods, way to get back to main activity

public class Logs extends AppCompatActivity {

    private ImageView photoSpot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        //this is where the image you want to enlarge will go
        photoSpot = (ImageView) findViewById(R.id.photoSpot);
    }


    //back to main
    public void openMain(View view){
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);

    }



    //Load gallery
    public void foodGallaryClicked(View v){
        //invoke image gallery
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

        //where the data is going to be gathered from
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureDirectoryPath = pictureDirectory.getPath();
        Uri data = Uri.parse(pictureDirectoryPath);

        //set data and type (image/*) is get all image types, we just want the jpg ones because that's the food log images!
        photoPickerIntent.setDataAndType(data, "image/jpg");

        startActivityForResult(photoPickerIntent, 20);

    }


    //result from photo gallery
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == 20){
            //everything processed just fine

            if (requestCode == RESULT_OK){
                //we got a response back from the gallery
                Uri imageUri = data.getData();

                //declare a stream to read image data from device
                InputStream inputStream;

                try {
                    inputStream = getContentResolver().openInputStream(imageUri);

                    //get a bitmap from stream
                    Bitmap imageBitmap =  BitmapFactory.decodeStream(inputStream);

                    //sets the photo chose to imageView
                    photoSpot.setImageBitmap(imageBitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Unable to open image", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
