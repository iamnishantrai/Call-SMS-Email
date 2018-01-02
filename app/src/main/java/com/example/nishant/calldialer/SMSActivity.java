package com.example.nishant.calldialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends Fragment {

    private EditText phone_no, sms;
    private Button sms_button;
    private String sms_content, phoneno;

    public SMSActivity(){

    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstance){

        phone_no = getView().findViewById(R.id.phone_no_sms);
        sms = getView().findViewById(R.id.sms);
        sms_button = getView().findViewById(R.id.btnSendSMS);

        sms_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneno = phone_no.getText().toString();
                sms_content = sms.getText().toString();

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneno, null, sms_content, null, null);

            }
        });

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_sms, container, false);
    }

}