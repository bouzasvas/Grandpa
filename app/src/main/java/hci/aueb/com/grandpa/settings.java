package hci.aueb.com.grandpa;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Intent intent=getIntent();
    }

    public void createContactOnclick (View view) {
        Intent intent = new Intent(this, createContact.class);
        startActivity(intent);
    }

    public void selectFavContacts (View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, Contacts.People.CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    public void sosButtonSettingsClick (View view) {
        Intent intent = new Intent(this, sos_button_settings.class);
        startActivity(intent);
    }

    public void defineSosMsg (View view) {
        Intent intent = new Intent(this, sos_msg.class);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        switch (reqCode) {
            case (1):
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c = managedQuery(contactData, null, null, null, null);
                    if (c.moveToFirst()) {
                        String contactName = c.getString(c.getColumnIndexOrThrow(Contacts.People.NAME));
                        String contactNumber = String.valueOf(c.getInt(c.getColumnIndexOrThrow(Contacts.People.NUMBER)));
                    }
                }
                break;
        }
    }
}
