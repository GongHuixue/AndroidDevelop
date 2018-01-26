package com.example.huixuegong.androiddevelop.icp.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AddService extends Service {
    public AddService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private final IAddInterface.Stub mBinder = new IAddInterface.Stub() {
        @Override
        public int add(int x, int y) throws RemoteException {
            return (x + y);
        }
    };
}
