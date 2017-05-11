package jacoblazo.foodlogapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


//LOGS ACTIVITY CONTAINS: all the images taken by the camera of foods, way to get back to main activity

public class Logs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);
    }

    //back to main
    public void openMain(View view){
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);

    }



    //Load gallery
    public void foodGallaryClicked(View v){
        //invoke image gallery
        


    }

}
