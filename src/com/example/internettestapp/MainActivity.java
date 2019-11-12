package com.example.internettestapp;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	Button btn1,btn2;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1=(Button)findViewById(R.id.button1);
		btn2=(Button)findViewById(R.id.button2);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ConnectivityManager cm=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
				NetworkInfo ni=cm.getActiveNetworkInfo();
				if(ni!=null&&ni.isConnectedOrConnecting())
				{
					Toast.makeText(MainActivity.this,"Connected or connecting", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "not connected", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				WifiManager wm=(WifiManager)getSystemService(WIFI_SERVICE);
				if(wm.isWifiEnabled())
				{
					Toast.makeText(MainActivity.this,"WIFI:ON", Toast.LENGTH_SHORT).show();
					WifiInfo wi=wm.getConnectionInfo();
					if(wi.getNetworkId()==-1)
					{
						Toast.makeText(MainActivity.this,"WIFI IS NOT CONNECT TO ANY DEVICE", Toast.LENGTH_SHORT).show();
						
					}
					else
					{
						Toast.makeText(MainActivity.this,"WIFI IS CONNECTED", Toast.LENGTH_SHORT).show();
					}
				}
				else
				{
					Toast.makeText(getApplicationContext(), "WIFI IS OFF", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}

