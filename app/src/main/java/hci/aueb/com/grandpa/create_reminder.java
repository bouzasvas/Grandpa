package hci.aueb.com.grandpa;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class create_reminder extends AppCompatActivity {

    String subject;
    TextView date, time;
    ListView subjects;
    ArrayAdapter adapter;
    String[] choices = new String[]{"Γενέθλια", "Γιατρός", "Χάπια"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_reminder);
        Intent intent = getIntent();
        subjects = (ListView) findViewById(R.id.subjectList);
        subjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                subject = subjects.getItemAtPosition(position).toString();
            }
        });
        adapter = new ArrayAdapter<String>(this, R.layout.text_view_subjectslist, choices);
        subjects.setAdapter(adapter);
        date = (TextView) findViewById(R.id.date_selection);
        time = (TextView) findViewById(R.id.time_selection);
    }

    public void selectDateAction(View view) {
        Intent intent = new Intent(this, date_select.class);
        startActivityForResult(intent, 1);
    }

    public void selectTimeAction(View view) {
        Intent intent = new Intent(this, time_select.class);
        startActivityForResult(intent, 2);
    }

    public void saveButtonOnClick(View view) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateF = dateFormat.parse(date.getText().toString());
        //Calendar cal = new GregorianCalendar(dateF.getYear(), dateF.getMonth(), dateF.getDay());
        //Calendar begin = Calendar.getInstance();
        //Calendar end = Calendar.getInstance();
        //int day = dateF.getDate();
        //int month = dateF.getMonth();
        //int year = dateF.getYear();
        int hour = Integer.valueOf(time.getText().subSequence(0, 2).toString());
        int min = Integer.valueOf(time.getText().subSequence(3, 5).toString());
        dateF.setHours(hour);
        dateF.setMinutes(min);
        //begin.set(year, month, day, hour, min);
        //end.set(year, month, day, hour+1, min);
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.Events.TITLE, subject);
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "This event is created by Grandpa App");
        intent.putExtra(CalendarContract.Events.HAS_ALARM, true);
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, dateF.getTime());
        //intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK)
                date.setText(data.getStringExtra("date"));
        }
        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK)
                time.setText(data.getStringExtra("time"));
        }
    }
}
