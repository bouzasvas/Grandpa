package hci.aueb.com.grandpa;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class select_contacts extends AppCompatActivity {

    Intent intent1;
    TextView name, tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contacts);
        intent1 = getIntent();
        name = (TextView) findViewById(R.id.contact_name);
        tel = (TextView) findViewById(R.id.tel_no);
        Intent intent = new Intent(Intent.ACTION_PICK, Contacts.People.CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    public void search_contact (View view) {
        intent1.putExtra("name", name.getText().toString());
        intent1.putExtra("tel", tel.getText().toString());
        setResult(Activity.RESULT_OK, intent1);
        finish();
    }

    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        switch (reqCode) {
            case (1):
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c = getContentResolver().query(contactData, null, null, null, null);
                    if (c.moveToFirst()) {
                        name.setText(c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
                        //tel.setText(c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                    }
                }
                break;
        }
    }
}
