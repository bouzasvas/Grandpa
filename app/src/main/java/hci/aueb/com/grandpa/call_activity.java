package hci.aueb.com.grandpa;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class call_activity extends AppCompatActivity {

    TextView callingNumber;
    Button clear;
    ImageButton call;
    ImageButton n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, asterisk, sharp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_activity);
        Intent intent = getIntent();
        callingNumber = (TextView) findViewById(R.id.num);
        clear = (Button) findViewById(R.id.clear_button);
        call = (ImageButton) findViewById(R.id.calling_button);
        n1 = (ImageButton) findViewById(R.id.number1);
        n2 = (ImageButton) findViewById(R.id.number2);
        n3 = (ImageButton) findViewById(R.id.number3);
        n4 = (ImageButton) findViewById(R.id.number4);
        n5 = (ImageButton) findViewById(R.id.number5);
        n6 = (ImageButton) findViewById(R.id.number6);
        n7 = (ImageButton) findViewById(R.id.number7);
        n8 = (ImageButton) findViewById(R.id.number8);
        n9 = (ImageButton) findViewById(R.id.number9);
        n0 = (ImageButton) findViewById(R.id.number0);
        asterisk = (ImageButton) findViewById(R.id.asterisk);
        sharp = (ImageButton) findViewById(R.id.sharp);
    }

    public void number1Click (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        callingNumber.append("1");
    }

    public void number2Click (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        callingNumber.append("2");
    }

    public void number3Click (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        callingNumber.append("3");
    }

    public void number4Click (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        callingNumber.append("4");
    }

    public void number5Click (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        callingNumber.append("5");
    }

    public void number6Click (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        callingNumber.append("6");
    }

    public void number7Click (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        callingNumber.append("7");
    }

    public void number8Click (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        callingNumber.append("8");
    }

    public void number9Click (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        callingNumber.append("9");
    }

    public void number0Click (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        callingNumber.append("0");
    }

    public void asteriskClick (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        callingNumber.append("*");
    }

    public void sharpClick (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        callingNumber.append("#");
    }

    public void clearClick (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        callingNumber.setText("");
    }

    public void callClick(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        try {
            Intent callintent = new Intent(Intent.ACTION_CALL);
            callintent.setData(Uri.parse("tel:" + callingNumber.getText().toString()));
            startActivity(callintent);
        }
        catch (SecurityException e) {
            System.exit(-1);
        }

    }
}
