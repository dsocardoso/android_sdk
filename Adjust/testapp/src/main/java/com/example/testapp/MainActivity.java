package com.example.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.adjust.sdk.AdjustFactory;
import com.adjust.testlibrary.TestLibrary;

public class MainActivity extends AppCompatActivity {
    private TestLibrary testLibrary;
    private CommandListener commandListener;
    public static final String TAG = "TestApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        commandListener = new CommandListener(this.getApplicationContext());
        String baseUrl = "https://10.0.2.2:8443";
        AdjustFactory.setBaseUrl(baseUrl);
        testLibrary = new TestLibrary(baseUrl, commandListener);
        startTestSession();
    }

    private void startTestSession() {
        testLibrary.initTestSession("unity4.10.0@android4.11.1");
    }

    public void onStartTestSession(View v) {
        startTestSession();
    }
}
