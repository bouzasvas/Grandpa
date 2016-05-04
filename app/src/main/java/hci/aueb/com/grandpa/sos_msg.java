package hci.aueb.com.grandpa;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class sos_msg extends AppCompatActivity {

    EditText message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos_msg);
        message = (EditText) findViewById(R.id.sos_message);
    }

    public void cancelOnClick (View view){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        Intent intent = new Intent(this,settings.class);
        startActivity(intent);
    }

    public void saveOnClick (View view){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        sos.message = message.getText().toString();
        Intent intent = new Intent(this,settings.class);
        startActivity(intent);
    }
}
