package jacoblazo.foodlogapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


//MAIN ACTIVITY CONTAINS: Switching between all activities + opening camera for new log + camera method,
// method to save image



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    //Go to settings
    public void openSettings(View view){
        Intent settingsIntent = new Intent(this, Settings.class);
        startActivity(settingsIntent);
    }

    //Go to logs
    public void openLogs(View view){
        Intent logsIntent = new Intent(this, Logs.class);
        startActivity(logsIntent);
    }

    //Go to about
    public void openAbout(View view){
        Intent aboutIntent = new Intent(this, About.class);
        startActivity(aboutIntent);
    }


    //open camera
    public void openCamera(View v){

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 10);

        //get path of where to save image
        File desiredPictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureName = getPictureName();
        File imageFile = new File(desiredPictureDirectory, pictureName);
        Uri pictureUri = Uri.fromFile(imageFile);

        //save image to given path
        cameraIntent.putExtra( MediaStore.EXTRA_OUTPUT, pictureUri);
    }

    //determine image name
    private String getPictureName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());
        String fullName = "FoodImage" + timestamp + ".jpg";
        return fullName;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            //the user has clicked the okay button in the camera
            if (requestCode == 10) {
                //we are hearing back from camera
               //nothing here, camera should close
            }
        }
    }


    //when photo is taken, take user to the log submit screen and take the captured image and move it there


}
