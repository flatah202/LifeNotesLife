package mf.o.self_educated.lifenotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class AllShowNotes extends AppCompatActivity {


    private RecyclerView showAllList;
    private FirebaseAuth firebaseAuth;
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    private FirebaseFirestore  firebaseFirestore;

//    FirestoreRecyclerAdapter<NotesList,NoteViewHolder> noteAdapter;




    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_all_show_notes);

//            getSupportActionBar().setTitle("All Notes");
           showAllList = (RecyclerView) findViewById(R.id.showAll);

           firebaseFirestore = FirebaseFirestore.getInstance();





        }// End of onCreate method





//    Query query=firebaseFirestore.collection("Notes").document("All Notes").collection("my Notes").orderBy("TitleNotes");




        public void AddNewNotes(View view) {
            Intent intent = new Intent(AllShowNotes.this, AddNewNote.class);
            startActivity(intent);
        }// End of AddNewNotes method





}// End of AllShowNotes class