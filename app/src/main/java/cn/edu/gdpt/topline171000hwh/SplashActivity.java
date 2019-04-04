package cn.edu.gdpt.topline171000hwh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //显示3秒，然后自动跳转到MainActivity.java
        //定时器和任务
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {//实质是子线程，重写Runnable()
            @Override
            public void run() {//重写run()
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(task,500);
    }
}
