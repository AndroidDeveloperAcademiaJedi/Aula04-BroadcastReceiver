package com.academiajedi.androiddveloper.exemplobroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by alexsoaresdesiqueira on 07/02/17.
 */

public class MeuBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String acao = intent.getAction();

        if (Intent.ACTION_BOOT_COMPLETED.equals(acao)) {
            Intent i = new Intent(context, MainActivity.class);
            i.addCategory(Intent.CATEGORY_DEFAULT);
            context.startActivity(i);

        } else if (ConnectivityManager.CONNECTIVITY_ACTION.equals(acao)){

            ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isConnected()) {
                Toast.makeText(context, "Conectado a internet", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Sem Conexão com a internet", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Ação: "+acao, Toast.LENGTH_SHORT).show();
        }
    }
}
