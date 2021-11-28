package com.example.fortuneteller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FortunePresenter.View {

    FortunePresenter presenter;
    TextView fText;
    Button button;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new FortunePresenter(this);

        fText = (TextView) findViewById(R.id.textBox);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                presenter.GetFortune();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fText.setText(text);
                    }
                });
            }
        });
        thread.start();
    }

    @Override
    public void fortuneTextAdded(String fortuneText) {
        text = fortuneText;
    }
}