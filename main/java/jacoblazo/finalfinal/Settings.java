package jacoblazo.finalfinal;
/**
 * Created by David on 5/12/2017.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;



public class Settings extends AppCompatActivity {
    private int photoChoice = 1;
    private int textChoice = 1;
    Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.photoSize_small:
                if (checked)
                    photoChoice = 1;
                throwToast("YOU DID SOMETHING RIGHT");
                break;

            case R.id.photoSize_medium:
                if (checked)
                    photoChoice = 2;
                throwToast("STILL WORKS. ALSO "+photoChoice);
                break;

            case R.id.photoSize_large:
                if (checked)
                    photoChoice = 3;
                throwToast("STILL WORKS. ALSO "+photoChoice);
                break;
        }
    }

    public void onOtherRadioClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.text_size_15:
                if (checked)
                    textChoice = 1;
                throwToast("This works too");
                break;
            case R.id.text_size_20:
                if (checked)
                    textChoice = 2;
                throwToast("I can't believe it");
                break;
            case R.id.text_size_25:
                if (checked)
                    textChoice = 3;
                throwToast("ARIEYOIREJYOIAERJY");
        }
    }

    // The bundle in this code is critical in ensuring the variables are kept across activities

    public void openHome(){
        Intent goHome = new Intent(this, MainActivity.class);
        bundle.putInt("photoChoice", photoChoice);
        bundle.putInt("textChoice", textChoice);
        goHome.putExtras(bundle);
        startActivity(goHome);
    }
    private void throwToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
