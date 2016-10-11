package doge.watchdoge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import doge.watchdoge.emailsender.DummyEmailSender;

public class ChooseReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_report);

        DummyEmailSender sender = new DummyEmailSender();
    }
}
