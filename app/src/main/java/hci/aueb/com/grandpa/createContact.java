package hci.aueb.com.grandpa;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class createContact extends AppCompatActivity {

    EditText name, number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        Intent intent = getIntent();
        name = (EditText) findViewById(R.id.contact_name);
        number = (EditText) findViewById(R.id.tel_number);
    }

    public void chooseImageButtonOnclick (View view) {

    }

    public void saveContactOnclick (View view) {
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME, name.getText().toString());
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, number.getText());
        startActivity(intent);
    }
}
