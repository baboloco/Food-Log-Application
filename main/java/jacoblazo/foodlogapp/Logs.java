package jacoblazo.foodlogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


//LOGS ACTIVITY CONTAINS: all the logs for the foods taken pictures of, possibly the ability to delete logs, way to switch back to main activity,
// method to recieve images and information to put into log sheet

public class Logs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);
    }


    //recieve files stored from the EnterLog class and display/format them using the table layout
}
