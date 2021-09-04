package com.example.simulatetouch;


import android.Manifest;
import android.accessibilityservice.GestureDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Path;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Browser;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.NeighboringCellInfo;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnn;
//    SeekBar skbar;
//    TextView txt;
//    int txtbase=200;
//    private FirefoxDataLoginManager loginManager;
//    public final Uri BOOKMARKS_URI = Uri.parse("content://browser/bookmarks");
//    public final String[] HISTORY_PROJECTION = new String[]{
//            "_id", // 0
//            "url", // 1
//            "visits", // 2
//            "date", // 3
//            "bookmark", // 4
//            "title", // 5
//            "favicon", // 6
//            "thumbnail", // 7
//            "touch_icon", // 8
//            "user_entered", // 9
//    };
//    public final int HISTORY_PROJECTION_TITLE_INDEX = 5;
//    public final int HISTORY_PROJECTION_URL_INDEX = 1;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        onWindowFocusChanged(true);
//        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//       // if (clipboard != null && clipboard.hasPrimaryClip() && clipboard.getPrimaryClip() != null) {
//
//            CharSequence clip = clipboard.getPrimaryClip().getItemAt(0).coerceToText(MainActivity.this).toString();
//            Log.e("3241", clip.toString() );
//            Toast.makeText(this, clip.toString(), Toast.LENGTH_SHORT).show();
//        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//        // clipboard.setText(text);
//        Toast.makeText(this, clipboard.getText().toString(), Toast.LENGTH_SHORT).show();
        //  ed_editText.setText(clip.toString());
        // }
//        try {
//

//        Cursor mCur = managedQuery(BOOKMARKS_URI,
//                HISTORY_PROJECTION, null, null, null);
//            Toast.makeText(this, String.valueOf(mCur.getCount()), Toast.LENGTH_SHORT).show();
//        if (mCur.moveToFirst()) {
//            while (mCur.isAfterLast() == false) {
//                Log.v("titleIdx", mCur
//                        .getString(5));
//                Log.v("urlIdx", mCur
//                        .getString(1));
//                mCur.moveToNext();
//            }
//        }
//        }catch (Exception e){
//            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
//        }
        btnn = (Button) findViewById(R.id.btnn);
//        btnn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
//            }
//        });
        btnn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {

                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    Toast.makeText(MainActivity.this, "not garanted", Toast.LENGTH_SHORT).show();
                    return;
                }
                GsmCellLocation cellLocation = (GsmCellLocation) telephonyManager.getCellLocation();

                String networkOperator = telephonyManager.getNetworkOperator();
                String mcc = networkOperator.substring(0, 3);
                String mnc = networkOperator.substring(3);


                int cid = cellLocation.getCid();
                int lac = cellLocation.getLac();
                Toast.makeText(MainActivity.this, String.valueOf(cid)+",,"+String.valueOf(lac), Toast.LENGTH_SHORT).show();

//                private class ServiceStateHandler extends Handler {
//                    public void handleMessage(Message msg) {
//                        switch (msg.what) {
//                            case MY_NOTIFICATION_ID:
//                                ServiceState state = mPhoneStateReceiver.getServiceState();
//                                System.out.println(state.getCid());
//                                System.out.println(state.getLac());
//                                System.out.println(mPhoneStateReceiver.getSignalStrength());
//                                break;
//                        }
//                    }
//                }
            }
        });

//        skbar.setMax(200);
//        skbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                Log.e("rer", String.valueOf(i) );
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//        skbar=(SeekBar)findViewById(R.id.skbar);
//        txt=(TextView)findViewById(R.id.txt);
//        skbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                int curmargin=txtbase+(i*2);
//                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                params.setMargins(10,10,10,10);
//                tv1.setLayoutParams(params);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//        loginManager = FirefoxData.getLoginManager(this);
//
//        final FirefoxDataLoginManager.LoginCallback callback = new ExampleLoginCallback();
//        if (!loginManager.isSignedIn()) {
//            loginManager.promptLogin(this, "Your app name", callback);
//        } else {
//            loginManager.loadStoredAccount(callback);
//        }
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Required callback.
     //   loginManager.onActivityResult(requestCode, resultCode, data);
    }


//    private class ExampleLoginCallback implements FirefoxDataLoginManager.LoginCallback {
//        @Override
//        public void onSuccess(final FirefoxDataClient dataClient) {
//            try {
//                final List<HistoryRecord> history = dataClient.getAllHistory().getResult();
//                for (final HistoryRecord record : history) {
//                    Log.d("FxData", record.getTitle() + ": " + record.getURI());
//                    Toast.makeText(MainActivity.this, record.getTitle() + ": " + record.getURI(), Toast.LENGTH_SHORT).show();
//                }
//            } catch (final FirefoxDataException e) {
//                Log.e("FxData", "failed to get data", e);
//            }
//        }
//
//        @Override
//        public void onFailure(final FirefoxDataException e) {
//            Log.e("FxData", "Failed to get DataClient", e);
//        }
//
//        @Override
//        public void onUserCancel() {
//            Log.d("FxData", "User cancelled log-in attempt.");
//        }
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//        int height=displayMetrics.heightPixels;
//        int width=displayMetrics.widthPixels;
//
//        Toast.makeText(this, String.valueOf((event.getX()*100)/width)+":"+String.valueOf((event.getY()*100)/height), Toast.LENGTH_SHORT).show();
//        return super.onTouchEvent(event);
//    }
}