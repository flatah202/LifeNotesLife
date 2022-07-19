package mf.o.self_educated.lifenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class NotesRoom extends AppCompatActivity {

    TextView titleShow, descShow;

    SharedPreferences sharedPreferencesData;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Title = "titleKey";
    public static final String Desc = "descKey";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_room);
        titleShow = findViewById(R.id.TitleShow);
        descShow = findViewById(R.id.DescShow);

        sharedPreferencesData = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
        String title = sharedPreferencesData.getString(Title, null);
        String desc = sharedPreferencesData.getString(Desc, null);

        if(title != null || desc != null) {
            titleShow.setText("TITLE: " +title);
            descShow.setText("DESC: \n" +desc);
        }





    }//End of onCreate method





}// End of NotesRoom class