package com.haohaohu.haologsample;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.haohaohu.haolog.HaoLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        HaoLog.setEnable(true);
        HaoLog.e("test");

        HaoLog.e(true, "true-test");
        HaoLog.e(false, "false-test");

        HaoLog.e("newTag", true, "newTag-true-test");
        HaoLog.e("newTag", false, "newTag-false-test");

        HaoLog.e("newTag1", true, "newTag1-true-test", 3);
        HaoLog.e("newTag1", false, "newTag1-false-test", 3);
    }
}