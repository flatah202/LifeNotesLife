package mf.o.self_educated.lifenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


public class AllShowNotes extends AppCompatActivity {

    ListView showAllList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_show_notes);

       TextView header = (TextView) findViewById(R.id.allNotes);
       showAllList = (ListView) findViewById(R.id.showAll);



    }// End of onCreate method




    public void AddNewNotes(View view) {
        Intent intent = new Intent(AllShowNotes.this, AddNewNote.class);
        startActivity(intent);
    }// End of AddNewNotes method





}// End of AllShowNotes class