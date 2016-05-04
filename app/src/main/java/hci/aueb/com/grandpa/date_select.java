package hci.aueb.com.grandpa;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class date_select extends AppCompatActivity {

    Intent intent;
    DatePicker date;
    Button select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_select);
        intent = getIntent();
        date = (DatePicker) findViewById(R.id.datePicker);
        select = (Button) findViewById(R.id.save_button);
    }

    public void saveOnclick (View view) {
        int day = date.getDayOfMonth();
        int month = date.getMonth()+1;
        int year = date.getYear();
        String finalDate;
        if (month<10)
            finalDate = day+"/"+"0"+month+"/"+year;
        else
            finalDate = day+"/"+month+"/"+year;
        intent.putExtra("date", finalDate);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}
