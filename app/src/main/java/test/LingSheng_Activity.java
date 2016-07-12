package test;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jingang.app.R;

import java.util.Random;

/**
 * Created by mn on 2016/7/11.
 */
public class LingSheng_Activity extends Activity {

    Button start,stop;
    public  int PlaySound(final Context context) {
        NotificationManager mgr = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        Notification nt = new Notification();
        nt.defaults = Notification.DEFAULT_SOUND;
        int soundId = new Random(System.currentTimeMillis())
                .nextInt(Integer.MAX_VALUE);
        mgr.notify(soundId, nt);
        return soundId;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lingsheng_layout);
        stop= (Button) findViewById(R.id.stop);
        start= (Button) findViewById(R.id.start);
      final   MediaPlayer mp = new MediaPlayer();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    mp.setDataSource(LingSheng_Activity.this, RingtoneManager
                            .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
                    mp.prepare();
                    mp.setLooping(true);
                    mp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
               // PlaySound(LingSheng_Activity.this);
            }
        });
      stop.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
             mp.stop();
          }
      });
    }
}
