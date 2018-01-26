package com.example.huixuegong.androiddevelop.icp.aidl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.huixuegong.androiddevelop.R;

public class AidlActivity extends Activity {
    private static final String TAG = AidlActivity.class.getSimpleName();
    private EditText etNum1;
    private EditText etNum2;
    private TextView textSum;
    private Button btnAdd;

    private IAddInterface mService;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "Bind Add Service");
            mService = IAddInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "unBind Add Service");
            mService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);

        //Bind Add Service
        Intent intent = new Intent(this, AddService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

        initView();
    }

    private void initView() {
        Log.d(TAG, "init View");
        etNum1 = findViewById(R.id.edittext_num1);
        etNum2 = findViewById(R.id.edittext_num2);
        textSum = findViewById(R.id.add_result);

        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int num1 = Integer.parseInt(etNum1.getText().toString());
                    int num2 = Integer.parseInt(etNum2.getText().toString());
                    int sum = mService.add(num1, num2);
                    Log.d(TAG, "num1 = " + num1 + " + nmm2 " + num2 + " = " + sum);
                    textSum.setText(Integer.valueOf(sum).toString());
                } catch (RemoteException e) {
                    Log.e(TAG, "add failed");
                }
            }
        });
    }
}
