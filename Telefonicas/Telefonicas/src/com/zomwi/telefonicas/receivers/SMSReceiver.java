package com.zomwi.telefonicas.receivers;

import java.util.StringTokenizer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import com.zomwi.telefonicas.MainActivity;

public class SMSReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		Object[] pdus = (Object[]) bundle.get("pdus");
		SmsMessage mensaje = SmsMessage.createFromPdu((byte[]) pdus[0]);
		String remitente = mensaje.getOriginatingAddress();
		String cuerpo = mensaje.getMessageBody().toString();

		if (remitente.equals("174")) {
			Intent i = new Intent();
			i.setClass(context, MainActivity.class);
			i.setAction(MainActivity.class.getName());
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);

			StringTokenizer st = new StringTokenizer(cuerpo, "\n");
			st.nextToken();
			st.nextToken();
			String x = st.nextToken();
			cuerpo = x.substring(0, x.indexOf(" "));

			i.putExtra("saldo", cuerpo);
			context.startActivity(i);

		} else if (remitente.equals("5599")) {
			Toast.makeText(context, "Tienes que hacer algo mas",
					Toast.LENGTH_SHORT).show();
		}
	}
}
