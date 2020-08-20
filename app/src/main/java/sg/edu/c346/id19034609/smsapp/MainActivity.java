package sg.edu.c346.id19034609.smsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTo, etContent;
    Button btnSend, btnSend2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission();

        etTo = findViewById(R.id.editTextTo);
        etContent = findViewById(R.id.editTextContent);
        btnSend = findViewById(R.id.buttonSend);
        btnSend2 = findViewById(R.id.buttonSend2);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etTo.getText().toString().trim() != null && etContent.getText().toString().trim() != null) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("555521" + etTo.getText().toString().trim(),null,etContent.getText().toString(),null,null);
                    Toast.makeText(MainActivity.this, "Message sent", Toast.LENGTH_LONG).show();
                    etContent.setText(null);
                }
            }
        });

        btnSend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etTo.getText().toString().trim() != null && etContent.getText().toString().trim() != null) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("555521" + etTo.getText().toString().trim(),null,etContent.getText().toString(),null,null);
                    Toast.makeText(MainActivity.this, "Message sent", Toast.LENGTH_LONG).show();
                    etContent.setText(null);
                }
            }
        });

    }

    private void checkPermission() {
        int permissionSendSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        int permissionRecvSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        if (permissionSendSMS != PackageManager.PERMISSION_GRANTED && permissionRecvSMS != PackageManager.PERMISSION_GRANTED) {
            String[] permissionNeeded = new String[]{Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS};
            ActivityCompat.requestPermissions(this, permissionNeeded, 1);
        }
    }
}