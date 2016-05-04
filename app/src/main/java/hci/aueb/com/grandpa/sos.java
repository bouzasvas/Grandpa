package hci.aueb.com.grandpa;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class sos extends AppCompatActivity {

    static String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        Intent intent = getIntent();
    }

    public void ekabButtonOnClick(View view){
        try {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(1000);
            Intent callintent = new Intent(Intent.ACTION_CALL);
            callintent.setData(Uri.parse("tel:"+"166"));
            startActivity(callintent);
        }
        catch (SecurityException e) {
            System.exit(-1);
        }
    }

    public void favSosMsg (View view) {
        try {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(1000);
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("6975912445", null, message, null, null);
            Toast.makeText(getApplicationContext(), "Το μήνυμα εστάλη!",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "Αποτυχία αποστολής, δοκιμάστε αργότερα!",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
