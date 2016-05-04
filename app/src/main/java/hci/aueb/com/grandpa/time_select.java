package hci.aueb.com.grandpa;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class time_select extends AppCompatActivity {

    Intent intent;
    TimePicker time;
    Button select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_select);
        intent = getIntent();
        time = (TimePicker) findViewById(R.id.timePicker);
        select = (Button) findViewById(R.id.savet_button);
    }

    public void saveOnclick (View view) {
        int hour = time.getCurrentHour();
        int min = time.getCurrentMinute();
        String time = hour+":"+min;
        if (min<10) {
            time = hour+":"+"0"+min;
        }
        intent.putExtra("time", time);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}
