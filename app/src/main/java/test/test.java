package test;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

import java.util.Random;

/**
 * Created by mn on 2016/7/11.
 */
public class test {
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

}
