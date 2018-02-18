package sanikamal.com.ruatech.ruasmtoggle;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout contentLayout=findViewById(R.id.content);
        audioManager=(AudioManager) getSystemService(AUDIO_SERVICE);
        contentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RingerHelper.performToggle(audioManager);
                updateUi();

            }
        });
    }
    private void updateUi(){
        ImageView imageView=findViewById(R.id.phone_icon);
        int phoneImage=RingerHelper.isPhoneSilent(audioManager) ? R.drawable.ringer_off:R.drawable.ringer_on;
        imageView.setImageResource(phoneImage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUi();
    }
}
