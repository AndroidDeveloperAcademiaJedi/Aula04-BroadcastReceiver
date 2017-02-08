package com.academiajedi.androiddveloper.exemplobroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnBroadcast1;
    private Button btnBroadCast2;
    private MeuBroadcast meuBroadcast;

    private static final String MINHA_ACAO = "com.academiajedi.androiddeveloper.exemplobroadcast.MINHA_ACAO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meuBroadcast = new MeuBroadcast();

        btnBroadcast1 = (Button) findViewById(R.id.btnBroadcast1);
        btnBroadcast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MINHA_ACAO);
                sendBroadcast(it);
            }
        });

        btnBroadCast2 = (Button) findViewById(R.id.btnBroadCast2);
        btnBroadCast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
                registerReceiver(meuBroadcast, filter);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(meuBroadcast);
    }
}
