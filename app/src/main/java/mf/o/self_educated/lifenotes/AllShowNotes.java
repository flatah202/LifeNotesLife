package mf.o.self_educated.lifenotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class AllShowNotes extends AppCompatActivity {


    private RecyclerView showAllList;

    // variable for our adapter class and array list
    private NoteAdapter noteAdapter;
    private ArrayList<NotesList> NotesArrayList;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_all_show_notes);

           TextView header = (TextView) findViewById(R.id.allNotes);
           showAllList = (RecyclerView) findViewById(R.id.showAll);




           //call the building of RecyclerView
        buildRecyclerView();



        }// End of onCreate method






    private void buildRecyclerView() {
        // initializing our adapter class.
        noteAdapter = new NoteAdapter(NotesArrayList, AllShowNotes.this);

        // adding layout manager to our recycler view.
        LinearLayoutManager manager = new LinearLayoutManager(this);
        showAllList.setHasFixedSize(true);

        // setting layout manager to our recycler view.
        showAllList.setLayoutManager(manager);

        // setting adapter to our recycler view.
        showAllList.setAdapter(noteAdapter);
    }

        public void AddNewNotes(View view) {
            Intent intent = new Intent(AllShowNotes.this, AddNewNote.class);
            startActivity(intent);
        }// End of AddNewNotes method





}// End of AllShowNotes class