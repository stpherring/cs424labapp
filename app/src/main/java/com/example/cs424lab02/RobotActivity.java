package com.example.cs424lab02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Stephen on 10/14/2014.
 */
public class RobotActivity extends Activity
{
    private Button forward;
    private Button reverse;
    private Button left;
    private Button right;
    private Button stop;
    private Button quit;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot);
        Intent i = this.getIntent();
        Bundle extras = i.getExtras();
        final String ip = extras.getString("ip");

        forward = (Button) findViewById(R.id.forward_button);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TCPHandler().execute(ip, "forward");
            }
        });

        reverse = (Button) findViewById(R.id.reverse_button);
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TCPHandler().execute(ip, "reverse");
            }
        });

        left = (Button) findViewById(R.id.left_button);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TCPHandler().execute(ip, "left");
            }
        });
        right = (Button) findViewById(R.id.right_button);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TCPHandler().execute(ip, "right");
            }
        });

        stop = (Button) findViewById(R.id.stop_button);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TCPHandler().execute(ip, "stop");
            }
        });

        quit = (Button) findViewById(R.id.quit_button);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TCPHandler().execute(ip, "quit");
            }
        });
    }
}
