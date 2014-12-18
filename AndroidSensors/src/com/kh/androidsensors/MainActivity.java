package com.kh.androidsensors;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity{

	private SensorManager mSensorManager;
	private Sensor mSensor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// List all sensors present
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
		Log.d("KH", "Sensors found:");
		for (int i = 0 ; i < deviceSensors.size() ; i++) {
			String sInfo = deviceSensors.get(i).getName() + " "
					+ deviceSensors.get(i).getVendor() + " "
					+ deviceSensors.get(i).getType();
			Log.d("KH", sInfo);
		}
		// Try the ambient temperature sensor
		if (mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null){
		    mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
		    Log.d("KH", mSensor.getVendor() + " " + mSensor.getVersion());
		}
		else{
		    // Sorry, there are no accelerometers on your device.
		    // You can't play this game.
			Log.d("KH", "Bummer, no ambient temp sensor found");  
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
