package com.example.huixuegong.androiddevelop.icp.binderpool;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * Created by huixue.gong on 2018/1/29.
 */

public class BinderPool {
    private final static String TAG = BinderPool.class.getSimpleName();
    public final static int BINDER_NONE = -1;
    public final static int BINDER_ADD = 0;
    public final static int BINDER_DEL = 1;

    private Context mContext;
    private IBinderPool mBinderPool;
    private static BinderPool mInstance;

    private BinderPool(Context context) {
        mContext = context.getApplicationContext();
        connectBinderPoolService();
    }

    public static BinderPool getInstance(Context context) {
        if(mInstance == null) {
            synchronized (BinderPool.class) {
                if(mInstance == null) {
                    mInstance = new BinderPool(context);
                }
            }
        }
        return mInstance;
    }

    private void connectBinderPoolService() {
        Intent intent = new Intent(mContext, BinderPoolService.class);
        mContext.bindService(intent, mBinderPoolConnection, Context.BIND_AUTO_CREATE);
    }

    public IBinder queryBinder(int binderCode) {
        IBinder binder = null;
        try {
            if (mBinderPool != null) {
                binder = mBinderPool.queryBinder(binderCode);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return binder;
    }

    private ServiceConnection mBinderPoolConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBinderPool = IBinderPool.Stub.asInterface(service);
            try {
                mBinderPool.asBinder().linkToDeath(mBinderPoolDeathRecipient, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private IBinder.DeathRecipient mBinderPoolDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            Log.w(TAG, "binder died.");
            mBinderPool.asBinder().unlinkToDeath(mBinderPoolDeathRecipient, 0);
            mBinderPool = null;
            connectBinderPoolService();
        }
    };

    public static class BinderPoolImpl extends IBinderPool.Stub {
        public BinderPoolImpl() {super();}

        @Override
        public IBinder queryBinder(int binderCode) throws RemoteException {
            IBinder binder = null;
            switch (binderCode) {
                case BINDER_ADD: {
                    binder = new AddImpl();
                    break;
                }
                case BINDER_DEL: {
                    binder = new DelImpl();
                    break;
                }
                default:
                    break;
            }
            return binder;
        }
    }
}
