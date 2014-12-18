package com.kh.android.sensors;

import java.util.ArrayList;
import java.util.List;

import com.kh.android.sensors.R;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DiscoveryActivity extends ListActivity {
	private Handler m_handler = new Handler();
	/* Get Default Adapter */
	private BluetoothAdapter m_bluetooth = BluetoothAdapter.getDefaultAdapter();
	/* Storage the BT devices */
	private List<BluetoothDevice> m_devices = new ArrayList<BluetoothDevice>();
	/* Discovery is Finished */
	private volatile boolean m_discoveryFinished = false;

	private Runnable m_discoveryWorkder = new Runnable() {
		public void run() {
			/* Start search device */
			m_bluetooth.startDiscovery();
			Log.d("EF-BTBee", ">>Starting Discovery");
			for (;;) {
				if (m_discoveryFinished) {
					Log.d("EF-BTBee", ">>Finished");
					break;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
		}
	};

	/**
	 * Receiver When the discovery finished be called.
	 */
	private BroadcastReceiver m_foundReceiver = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			/* get the search results */
			BluetoothDevice device = intent
					.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
			/* add to list */
			m_devices.add(device);
			/* show the devices list */
			showDevices();
		}
	};
	
	private BroadcastReceiver m_discoveryReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			/* unRegister Receiver */
			Log.d("EF-BTBee", ">>unregisterReceiver");
			unregisterReceiver(m_foundReceiver);
			unregisterReceiver(this);
			m_discoveryFinished = true;
		}
	};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.discovery);

		if (!m_bluetooth.isEnabled()) {
			m_bluetooth.enable();
		}
		/* Register Receiver */
		IntentFilter discoveryFilter = new IntentFilter(
				BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		registerReceiver(m_discoveryReceiver, discoveryFilter);
		IntentFilter foundFilter = new IntentFilter(
				BluetoothDevice.ACTION_FOUND);
		registerReceiver(m_foundReceiver, foundFilter);

		m_handler.post(m_discoveryWorkder);
		for (; m_bluetooth.isDiscovering();) {
			m_bluetooth.cancelDiscovery();
		}
		m_discoveryFinished = true;
	}

	public void onPause(View view){
		Log.d("EF-BTBee", ">>onPause");
		m_bluetooth.disable();
		unregisterReceiver(m_discoveryReceiver);
		unregisterReceiver(m_foundReceiver);	
	}
	
	/* Show devices list */
	protected void showDevices() {
		List<String> list = new ArrayList<String>();
		if (m_devices.size() > 0) {
			for (int i = 0, size = m_devices.size(); i < size; ++i) {
				StringBuilder b = new StringBuilder();
				BluetoothDevice d = m_devices.get(i);
				b.append(d.getAddress());
				b.append('\n');
				b.append(d.getName());
				String s = b.toString();
				list.add(s);
			}
		} else
			list.add("There isn't bluetooth devices");
		Log.d("EF-BTBee", ">>showDevices");
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);
		m_handler.post(new Runnable() {
			public void run() {
				setListAdapter(adapter);
			}
		});
	}

	/* Select device */
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Log.d("EF-BTBee", ">>Click device");
		Intent result = new Intent();
		result.putExtra(BluetoothDevice.EXTRA_DEVICE, m_devices.get(position));
		setResult(RESULT_OK, result);
		finish();
	}
}
