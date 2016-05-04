package hci.aueb.com.grandpa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

public class calendar_activity extends AppCompatActivity {

    Button createReminderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_activity);
        Intent intent = getIntent();
        createReminderButton = (Button) findViewById(R.id.createReminder_button);
    }

    public void createReminder_buttonOnclick (View view) {
        Intent intent = new Intent(this, create_reminder.class);
        startActivity(intent);
    }

    public void createReminderButtonOnclick (View view) {
        Intent intent = new Intent(this, create_reminder.class);
        startActivity(intent);
    }
}
