package com.example.huixuegong.androiddevelop.icp.binderpool;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.huixuegong.androiddevelop.R;

public class BinderPoolActivity extends Activity {
    private final static String TAG = BinderPoolActivity.class.getSimpleName();

    private EditText etNum1;
    private EditText etNum2;
    private TextView textSum;
    private Button btnAdd;
    private EditText etNum3;
    private EditText etNum4;
    private TextView textDel;
    private Button btnDel;

    private IAdd mAddService;
    private IDel mDelService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder_pool);
        new Thread(new Runnable() {
            @Override
            public void run() {
                getBinder();
            }
        }).start();

        initView();
    }

    private void getBinder() {
        BinderPool binderPool = BinderPool.getInstance(BinderPoolActivity.this);
        IBinder addBinder = binderPool.queryBinder(BinderPool.BINDER_ADD);
        mAddService = (IAdd)AddImpl.asInterface(addBinder);

        IBinder delBinder = binderPool.queryBinder(BinderPool.BINDER_DEL);
        mDelService = (IDel)AddImpl.asInterface(delBinder);
    }

    private void initView() {
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
                    int sum = mAddService.add(num1, num2);
                    Log.d(TAG, "num1 = " + num1 + " + nmm2 " + num2 + " = " + sum);
                    textSum.setText(Integer.valueOf(sum).toString());
                } catch (RemoteException e) {
                    Log.e(TAG, "add failed");
                }
            }
        });

        etNum3 = findViewById(R.id.edittext_num3);
        etNum4 = findViewById(R.id.edittext_num4);
        textDel = findViewById(R.id.del_result);

        btnDel = findViewById(R.id.btn_del);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int num1 = Integer.parseInt(etNum3.getText().toString());
                    int num2 = Integer.parseInt(etNum4.getText().toString());
                    int sum = mDelService.del(num1, num2);
                    Log.d(TAG, "num1 = " + num1 + " + nmm2 " + num2 + " = " + sum);
                    textDel.setText(Integer.valueOf(sum).toString());
                } catch (RemoteException e) {
                    Log.e(TAG, "add failed");
                }
            }
        });
    }
}
