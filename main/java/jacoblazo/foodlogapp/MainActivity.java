package jacoblazo.foodlogapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


//MAIN ACTIVITY CONTAINS: Switching between all activities + opening camera for new log + camera method,
// method to save image and put it into the logsheet, after photo is taken, take the user to an 'enter information' sheet to finilize the logsheet



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



    //when photo is taken, take user to the log submit screen and take the captured image and move it there


}
