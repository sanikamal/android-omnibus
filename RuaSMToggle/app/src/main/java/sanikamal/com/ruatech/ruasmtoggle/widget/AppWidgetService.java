package sanikamal.com.ruatech.ruasmtoggle.widget;

import android.app.IntentService;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.annotation.Nullable;
import android.widget.RemoteViews;

import sanikamal.com.ruatech.ruasmtoggle.R;
import sanikamal.com.ruatech.ruasmtoggle.RingerHelper;

/**
 * Created by Sani Kamal on 17-Feb-18.
 */

public class AppWidgetService extends IntentService {
    private static String ACTION_DO_TOGGLE = "actionDoToggle";
    AudioManager audioManager;

    public AppWidgetService() {
        super("AppWidgetService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

    }

    /**
     * This method is invoked on the worker thread with a request to process.
     * Only one Intent is processed at a time, but the processing happens on a
     * worker thread that runs independently from other application logic.
     * So, if this code takes a long time, it will hold up other requests to
     * the same IntentService, but it will not hold up anything else.
     * When all requests have been handled, the IntentService stops itself,
     * so you should not call {@link #stopSelf}.
     *
     * @param intent The value passed to {@link
     *               Context#startService(Intent)}.
     *               This may be null if the service is being restarted after
     *               its process has gone away; see
     *               {@link Service#onStartCommand}
     *               for details.
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null && intent.getBooleanExtra(ACTION_DO_TOGGLE, false)) {
            RingerHelper.performToggle(audioManager);

        }
        AppWidgetManager mgr = AppWidgetManager.getInstance(this);
        ComponentName name = new ComponentName(this, AppWidget.class);
        mgr.updateAppWidget(name, updateUi());
    }

    private RemoteViews updateUi() {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.app_widget);
        int phoneImage = RingerHelper.isPhoneSilent(audioManager) ? R.drawable.icon_ringer_off : R.drawable.icon_ringer_on;
        remoteViews.setImageViewResource(R.id.phone_state, phoneImage);
        Intent intent = new Intent(this, AppWidgetService.class).putExtra(ACTION_DO_TOGGLE, true);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        remoteViews.setOnClickPendingIntent(R.id.widget, pendingIntent);
        return remoteViews;
    }
}
