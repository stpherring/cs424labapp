package com.example.cs424lab02;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Stephen on 10/14/2014.
 */
public class TCPHandler extends AsyncTask<String, Void, Boolean> {
    private static final String TAG = "TCPHandler";
    final static int PORT = 50001;
    Socket socket;
    PrintWriter printWriter = null;
    boolean socketOK = false;


    @Override
    protected Boolean doInBackground(String[] params) {
        String ip = params[0];
        String command = params[1];
        try {
            Log.d(TAG, "ip: " + ip);
            Log.d(TAG, "command: " + command);
            socket = new Socket(ip, PORT);
            printWriter = new PrintWriter(socket.getOutputStream());
            socket.getOutputStream().write(command.getBytes());
            socketOK = true;
            socket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            socketOK = false;
        }

        return socketOK;
    }
}
