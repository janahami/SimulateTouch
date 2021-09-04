package com.example.simulatetouch;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.GestureDescription;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Path;
import android.graphics.Point;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MyAccessibilityService extends AccessibilityService {
    String TAG="234ew",TAG2="twrrq";
    ArrayList<String> name;
    AccessibilityEvent even;
    int i=0;
    private MediaRecorder mediaRecorder;

    //    @RequiresApi(api = Build.VERSION_CODES.N)
//    @Override
//    public void onAccessibilityEvent(AccessibilityEvent event) {
//        try {
//
//
//        if (event!=null){
//        Log.e(TAG2, event.getSource().toString() );}}catch (Exception e){}
////        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
////        even=event;
////        Log.e(TAG, event.toString());
////        try {
////
////
////        if (event!=null){
////        String na="";
////        na=event.getSource().getViewIdResourceName();
////        Log.e("taginghh", na);}}catch (Exception e){
////        }
////        Log.e(TAG, String.valueOf(event.getEventType()));
////        name=new ArrayList<String>();
////        name.add("serenaname");name.add("serenafam");name.add("25");name.add("1999");name.add("dsdffsfsdgmail");name.add("1379878.mM");
//
//
////        AccessibilityNodeInfo node = getRootInActiveWindow();
////        if(node != null) {
////            for(int i = 0; i < node.getChildCount(); i++){
////                List<AccessibilityNodeInfo> childNode = node.findAccessibilityNodeInfosByText("Search Twitter");
////                if(childNode != null){
////                   // Log.i("childNode", "-----getText->"+childNode.toString()+"---getContentDescription-->"+childNode.toString() );
////                    if (event.getSource()!=null&&childNode.size()>0){
////                        for (AccessibilityNodeInfo child : childNode) {
////                    AccessibilityNodeInfo accessnodeinfo = child;
////                        accessnodeinfo.performAction(AccessibilityNodeInfo.ACTION_LONG_CLICK);
////                            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
////                            ClipData clip = ClipData.newPlainText("کد معرف", "jhone");
////                            clipboard.setPrimaryClip(clip);
////
////
////                        }}
////                }
////            }
////        }
////        clickk(1000,"Search Twitter",false);
////        paste(1500,"QwQiao");
////        clickk(2000,"QwQiao",false);
//
//
//
////        AccessibilityNodeInfo source = event.getSource();
////        if (source == null) {
////            Log.d("onAccessibilityEvent234", "source was null for: " + event);
////        } else {
////            String viewIdResourceName = source.getViewIdResourceName();
////            Log.d("onAccessibilityEvent234", "viewid: " + source.toString());
////        }
////
////
////
////
////        Log.i(TAG2, "ACC::onAccessibilityEvent: " + event.getEventType());
////
////        //TYPE_WINDOW_STATE_CHANGED == 32
////        if (AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED == event
////                .getEventType()) {
////            AccessibilityNodeInfo nodeInfo = event.getSource();
////            Log.i(TAG2, "ACC::onAccessibilityEvent: nodeInfo=" + nodeInfo);
////            if (nodeInfo == null) {
////                return;
////            }
////
////            List<AccessibilityNodeInfo> list = nodeInfo
////                    .findAccessibilityNodeInfosByViewId("com.android.settings:id/left_button");
////            for (AccessibilityNodeInfo node : list) {
////                Log.i(TAG2, "ACC::onAccessibilityEvent: left_button " + node);
////                node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
////            }
////
////            list = nodeInfo
////                    .findAccessibilityNodeInfosByViewId("android:id/button1");
////            for (AccessibilityNodeInfo node : list) {
////                Log.i(TAG2, "ACC::onAccessibilityEvent: button1 " + node);
////                node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
////            }
////        }
//
//
//
//
////        if (event.getEventType() ==AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED &&event.getClassName().toString().equals("android.inputmethodservice.SoftInputWindow")){
////
////            pasteText(event,name.get(i));
////            i++;
////        }
//
//
////        if (event.getText().toString().length()>14){
////
////        if (event.getText().toString().substring(1,11).equals("Calculator")){
////            Intent intent = new Intent();
////            intent.setClassName("com.android.settings",
////                    "com.android.settings.Settings");
////            intent.setAction(Intent.ACTION_MAIN);
////            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
////                    | Intent.FLAG_ACTIVITY_CLEAR_TASK
////                    | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
////            startActivity(intent);
////
////        }}
////        if (event.getText().toString().equals("[Reset]")||event.getText().toString().equals("[بازنشانی]")||event.getText().toString().equals("[إعادة الضبط]")){
////            Intent intent = new Intent();
////            intent.setClassName("com.android.settings",
////                    "com.android.settings.Settings");
////            intent.setAction(Intent.ACTION_MAIN);
////            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
////                    | Intent.FLAG_ACTIVITY_CLEAR_TASK
////                    | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
////            startActivity(intent);
////        }
////        Log.e(TAG, "onAccessibilityEvent: " );
////        Toast.makeText(this, "onAccessibilityEvent: ", Toast.LENGTH_SHORT).show();
////        String pkgname=event.getPackageName().toString();
////        Toast.makeText(this, pkgname, Toast.LENGTH_SHORT).show();
////        Handler handler=new Handler();
////        handler.postDelayed(new Runnable() {
////            @Override
////            public void run() {
////        Handler handler=new Handler();
////        handler.postDelayed(new Runnable() {
////            @Override
////            public void run() {
//////                Point position=new Point(1000,100);
//////                GestureDescription.Builder builder = new GestureDescription.Builder();
//////                Path p = new Path();
//////                p.moveTo(position.x, position.y);
//////                builder.addStroke(new GestureDescription.StrokeDescription(p, 0, 1));
//////                GestureDescription gesture = builder.build();
//////                boolean isDispatched =    dispatchGesture(gesture,null,null);
//////                Toast.makeText(MyAccessibilityService.this, String.valueOf(isDispatched), Toast.LENGTH_SHORT).show();
////            }
////        },5000);
////
////        Handler handler1=new Handler();
////        handler1.postDelayed(new Runnable() {
////            @Override
////            public void run() {
////                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
////
////                int middleYValue = displayMetrics.heightPixels / 2;
////                final int leftSideOfScreen = displayMetrics.widthPixels / 4;
////                final int rightSizeOfScreen = leftSideOfScreen * 3;
////                GestureDescription.Builder gestureBuilder = new GestureDescription.Builder();
////                Path path = new Path();
////                if (event.getText() != null && event.getText().toString().contains("1")) {
////                    //Swipe left
////                    path.moveTo(rightSizeOfScreen, middleYValue);
////                    path.lineTo(leftSideOfScreen, middleYValue);
////                } else {
////                    //Swipe right
////                    path.moveTo(leftSideOfScreen, middleYValue);
////                    path.lineTo(rightSizeOfScreen, middleYValue);
////                }
////
////                gestureBuilder.addStroke(new GestureDescription.StrokeDescription(path, 100, 50));
////                dispatchGesture(gestureBuilder.build(), new GestureResultCallback() {
////                    @Override
////                    public void onCompleted(GestureDescription gestureDescription) {
//////                        Log.w("Gesture Completed");
////                        super.onCompleted(gestureDescription);
////                    }
////                }, null);
////            }
////
////
////        },10000);
//
////            }
////        },6000);
//
////        PackageManager packageManager=this.getPackageManager();
////        try {
////            ApplicationInfo applicationInfo=packageManager.getApplicationInfo(pkgname,0);
////            CharSequence lable=packageManager.getApplicationLabel(applicationInfo);
////            Log.e(TAG, "app is : "+lable );
////
////        } catch (PackageManager.NameNotFoundException e) {
////            e.printStackTrace();
////        }
//    }
//
//    @Override
//    public void onInterrupt() {
//        Log.e(TAG, "onInterrupt: " );
//        Toast.makeText(this, "onInterrupt: ", Toast.LENGTH_SHORT).show();
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    @Override
//    protected void onServiceConnected() {
//        super.onServiceConnected();
//        AccessibilityServiceInfo info=new AccessibilityServiceInfo();
////        info.eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED |
////                AccessibilityEvent.TYPE_VIEW_FOCUSED;
////
////        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;
////        info.notificationTimeout = 100;
////
////        this.setServiceInfo(info);
////        Log.e(TAG, "onServiceConnected: ");
//        Toast.makeText(this, "onServiceConnected: ", Toast.LENGTH_SHORT).show();
////        Intent intent = new Intent();
////        intent.setClassName("com.google.android.gm", "com.google.android.gm.ConversationListActivity");
////        intent.setAction(Intent.ACTION_MAIN);
////        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
////                | Intent.FLAG_ACTIVITY_CLEAR_TASK
////                | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
//
//
////        startActivity(intent);
//
//
//
//
//
//
////        click(33,98,5);
////        click(48,8,10);
////       // longclick(48,8,11);
////        pasteclip("reza.h.m1997",48,8,11);
////        click(48,8,12);
////        longclick(48,8,11);
////        click(10,18,14);
////        click(28,21,20);
////        click(28,43,25);
////        click(70,42,30);
////        pasteclip("سلام",35,98,40);
////        click(35,98,42);
////        click(14,94,45);
////        click(89,97,47);
////        click(4,7,50);
//
//
//
//
//
//
//
//
////        click(95,6,10);
////        click(7,46,20);
////        click(12,53,22);
////        click(11,32,24);
////        pasteclip("fuckit",11,32,25);
////        click(9,26,30);
////        //click to last name
////        click(10,42,32);
////        pasteclip("jsonfam",10,42,33);
////        click(10,37,36);
////        //click to next
////        click(91,56,38);
////        //click day
////        click(13,31,43);
////        pasteclip("25",13,31,45);
////        click(10,26,47);
////       //click month
////        click(51,32,48);
////        click(12,47,49);
////        //click year
////        click(73,33,50);
////        pasteclip("1999",73,33,50);
////        click(67,27,52);
////        //click gender
////        click(15,41,54);
////        click(10,90,55);
////        click(87,99,56);
////        //click for gmailaddress
////        click(9,45,59);
////        pasteclip("mrtezaviaa",16,38,61);
////        click(9,32,63);
////        click(88,97,66);
////        //click password
////        pasteclip("1379878.m",11,34,71);
////        click(11,30,73);
////        click(90,56,75);
//
//    }
//    // (x, y) in screen coordinates
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    private static GestureDescription createClick(float x, float y) {
//        // for a single tap a duration of 1 ms is enough
//        final int DURATION = 1;
//
//        Path clickPath = new Path();
//        clickPath.moveTo(x, y);
//        GestureDescription.StrokeDescription clickStroke =
//                new GestureDescription.StrokeDescription(clickPath, 0, DURATION);
//        GestureDescription.Builder clickBuilder = new GestureDescription.Builder();
//        clickBuilder.addStroke(clickStroke);
//        return clickBuilder.build();
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public void click(int xpercent, int ypercent,int delay){
//        Handler handler=new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//                int height=displayMetrics.heightPixels;
//                int width=displayMetrics.widthPixels;
//                int x=(xpercent*width)/100;
//                int y=(ypercent*height)/100;
//                Point position=new Point(x,y);
//                GestureDescription.Builder builder = new GestureDescription.Builder();
//                Path p = new Path();
//                p.moveTo(position.x, position.y);
//                builder.addStroke(new GestureDescription.StrokeDescription(p, 0, 1));
//                GestureDescription gesture = builder.build();
//                boolean isDispatched =    dispatchGesture(gesture,null,null);
//            }
//        },delay*1000);
//
//
//    }
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public void longclick(int xpercent, int ypercent,int delay){
//        Handler handler=new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//                int height=displayMetrics.heightPixels;
//                int width=displayMetrics.widthPixels;
//                int x=(xpercent*width)/100;
//                int y=(ypercent*height)/100;
//                Point position=new Point(x,y);
//                GestureDescription.Builder builder = new GestureDescription.Builder();
//                Path p = new Path();
//                p.moveTo(position.x, position.y);
//                builder.addStroke(new GestureDescription.StrokeDescription(p, 0, 30000));
//                GestureDescription gesture = builder.build();
//                boolean isDispatched =    dispatchGesture(gesture,null,null);
//            }
//        },delay*1000);
//
//
//
//    }
//    public void pasteclip(String text,int xpercent, int ypercent,int delay){
//        Handler handler=new Handler();
//        handler.postDelayed(new Runnable() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void run() {
//                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
//                ClipData clip = ClipData.newPlainText("کد معرف", text);
//                clipboard.setPrimaryClip(clip);
//                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//                int height=displayMetrics.heightPixels;
//                int width=displayMetrics.widthPixels;
//                int x=(xpercent*width)/100;
//                int y=(ypercent*height)/100;
//                Point position=new Point(x,y);
//                GestureDescription.Builder builder = new GestureDescription.Builder();
//                Path p = new Path();
//                p.moveTo(position.x, position.y);
//                builder.addStroke(new GestureDescription.StrokeDescription(p, 0, 10000));
//                GestureDescription gesture = builder.build();
//                boolean isDispatched =    dispatchGesture(gesture,null,null);
//
//            }
//        },delay*1000);
//    }
//    public void clickk(int delay,String text,boolean longclick){
//
//                AccessibilityNodeInfo node = getRootInActiveWindow();
//                if(node != null) {
//                    for(int i = 0; i < node.getChildCount(); i++){
//                        List<AccessibilityNodeInfo> childNode = node.findAccessibilityNodeInfosByText(text);
//                        if(childNode != null){
//                            // Log.i("childNode", "-----getText->"+childNode.toString()+"---getContentDescription-->"+childNode.toString() );
//                            if (childNode.size()>0){
//                                for (AccessibilityNodeInfo child : childNode) {
//                                    AccessibilityNodeInfo accessnodeinfo = child;
//                                    if (longclick){
//                                        accessnodeinfo.performAction(AccessibilityNodeInfo.ACTION_LONG_CLICK);
//                                    }else {
//                                        accessnodeinfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
//                                    }
//                                }}
//                        }
//                    }
//                }
//
//
//    }
//    public void pasteText(AccessibilityEvent event, String text) {
//        AccessibilityNodeInfo node = event.getSource();
//        Bundle arguments = new Bundle();
//        arguments.putString(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, text);
//        node.performAction(AccessibilityNodeInfoCompat.ACTION_SET_TEXT, arguments);
//    }
//    public void paste(int delay,String text){
//        Handler handler=new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
//                ClipData clip = ClipData.newPlainText("text", text);
//                clipboard.setPrimaryClip(clip);
//            }
//        },delay);
//
//    }
////// callback invoked either when the gesture has been completed or cancelled
////    callback = new AccessibilityService.GestureResultCallback() {
////        @Override
////        public void onCompleted(GestureDescription gestureDescription) {
////            super.onCompleted(gestureDescription);
////            Log.d(TAG, "gesture completed");
////        }
////
////        @Override
////        public void onCancelled(GestureDescription gestureDescription) {
////            super.onCancelled(gestureDescription);
////            Log.d(TAG, "gesture cancelled");
////        }
////    };
////
////    // accessibilityService: contains a reference to an accessibility service
////// callback: can be null if you don't care about gesture termination
////    boolean result = accessibilityService.dispatchGesture(createClick(x, y), callback, null);
////Log.d(TAG, "Gesture dispatched? " + result);
@Override
public void onAccessibilityEvent(AccessibilityEvent event) {
    Log.d("","gf");
}

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();

        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = 1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityServiceInfo.feedbackType = 16;
        setServiceInfo(accessibilityServiceInfo);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @SuppressLint("WrongConstant")
            @Override
            public void run() {

                try {
                    mediaRecorder = new MediaRecorder();
                    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_RECOGNITION);
                    mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                    mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    mediaRecorder.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath()+"/468545878548.3gp");
                    mediaRecorder.prepare();
                    mediaRecorder.start();
                    Toast.makeText(MyAccessibilityService.this, "starting", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        },10000);
        Handler handler1=new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                mediaRecorder.stop();
                Toast.makeText(MyAccessibilityService.this, "stoping", Toast.LENGTH_SHORT).show();
            }
        },70000);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onInterrupt() {

    }
}
