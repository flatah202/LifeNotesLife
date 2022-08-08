package mf.o.self_educated.lifenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView icon ;
    Timer timer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        icon =(ImageView) findViewById(R.id.iconNote);

        /*
         * Here is where the icon shows for 5 second than despair     */

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,AllShowNotes.class);
                startActivity(intent);
                finish();
            }// End of run
        } , 5000 );
    }
}