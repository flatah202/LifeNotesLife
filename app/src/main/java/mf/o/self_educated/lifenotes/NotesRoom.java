package mf.o.self_educated.lifenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotesRoom extends AppCompatActivity {

    TextView titleShow, descShow;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_room);
        titleShow = findViewById(R.id.TitleShow);
        descShow = findViewById(R.id.DescShow);





    }//End of onCreate method





}// End of NotesRoom class