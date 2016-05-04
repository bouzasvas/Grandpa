package hci.aueb.com.grandpa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Vibrator;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static int numOfContacs = 0;
    TextView fav1, fav2, fav3;
    String currentDate;
    TextView dateText;
    ImageButton callButton;
    ImageButton calendarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateText = (TextView) findViewById(R.id.dateText);
        SimpleDateFormat parseFormat = new SimpleDateFormat("E dd MMM yyyy hh:mm a");
        Date date =new Date();
        String s = parseFormat.format(date);
        //currentDate = DateFormat.getDateTimeInstance().format(date);
        dateText.setText(s);
        //dateText.setTextSize(30);
        callButton = (ImageButton) findViewById(R.id.call_button);
        calendarButton = (ImageButton) findViewById(R.id.calendar_button);
        fav1 = (TextView) findViewById(R.id.fav1text);
        fav2 = (TextView) findViewById(R.id.fav2text);
        fav3 = (TextView) findViewById(R.id.fav3text);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_menu:
                startActivity(new Intent(this, settings.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void callButtonClick(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        Intent intent = new Intent(this, call_activity.class);
        startActivity(intent);
    }

    public void calendarButtonClick(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        Intent intent = new Intent(this, calendar_activity.class);
        startActivity(intent);
    }

    public void sosButtonOnclick(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        Intent intent = new Intent(this, sos.class);
        startActivity(intent);
    }

    public void settingsButtonOnClick(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }

    public void selectFavContact (View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        if (numOfContacs<3) {
            numOfContacs++;
            Intent intent = new Intent(this, select_contacts.class);
            startActivityForResult(intent, 1);
        }
        else
        {

        }
    }

    public void fav1Onclick (View view) {
        try {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData((Uri.parse("tel:" + "6971234567")));
            startActivity(intent);
        }
        catch (SecurityException e) {
            System.exit(-1);
        }
    }

    public void fav2Onclick (View view) {
        try {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData((Uri.parse("tel:" + "6941234567")));
            startActivity(intent);
        }
        catch (SecurityException e) {
            System.exit(-1);
        }
    }

    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        if (reqCode==1) {
            if (resultCode==Activity.RESULT_OK) {
                fav3.setText(data.getStringExtra("name"));
            }
            else {

            }
        }
    }
}
