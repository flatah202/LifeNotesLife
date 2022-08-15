package mf.o.self_educated.lifenotes;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AllShowNotes extends AppCompatActivity {


    private RecyclerView showAllList;
    private FirebaseAuth firebaseAuth;
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    private FirebaseFirestore  firebaseFirestore;
    RecyclerView.LayoutManager layoutManager;

    private FirestoreRecyclerAdapter<NotesList,NoteViewHolder> noteAdapter;


    @Override
    protected void onStart() {
        super.onStart();
        noteAdapter.startListening();


    }// End the method of onStart




    @Override
    protected void onStop() {
        super.onStop();
        if (noteAdapter != null) {
            noteAdapter.stopListening();
        }


    }// End the method of onStop

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_all_show_notes);

//            getSupportActionBar().setTitle("All Notes");

           firebaseFirestore = FirebaseFirestore.getInstance();



        // Storing the data from firebase and assigning it
        Query query=firebaseFirestore.collection("Notes").document("All Notes").collection("my Notes").orderBy("TitleNotes",Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<NotesList> NoteList = new FirestoreRecyclerOptions.Builder<NotesList>().setQuery(query,NotesList.class).build();


        noteAdapter = new FirestoreRecyclerAdapter<NotesList, NoteViewHolder>(NoteList) {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            protected void onBindViewHolder(@NonNull NoteViewHolder NoteHolder, int position, @NonNull NotesList notesList) {


                //Generate the color the our recyclerView

                int colorCode = getTheColor();
                NoteHolder.holderLinearLayout.setBackgroundColor(NoteHolder.itemView.getResources().getColor(colorCode, null));


                NoteHolder.title.setText(notesList.getTitleNotes());
                NoteHolder.desc.setText(notesList.getDescriptionNotes());


                NoteHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(AllShowNotes.this, "You have enter to the page Activity", Toast.LENGTH_SHORT).show();


                    }
                });




            }

            @NonNull
            @Override
            public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_notes_room,parent,false);

                return new NoteViewHolder(view);
            }

        };






        /*
        * Assigning the recyclerView to our adapter
        * */
        showAllList = (RecyclerView) findViewById(R.id.showAll);
        showAllList.setHasFixedSize(true);
//        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        showAllList.setLayoutManager(staggeredGridLayoutManager);
        showAllList.setLayoutManager(new LinearLayoutManager(AllShowNotes.this));
        showAllList.setAdapter(noteAdapter);



    }// End of onCreate method




   private int getTheColor() {

       List<Integer> allColor = new ArrayList<>();
       allColor.add(R.color.orange);
       allColor.add(R.color.textColor);
       allColor.add(R.color.purple_200);
       allColor.add(R.color.yellow);
        allColor.add(R.color.orange2);
        allColor.add(R.color.purple_500);

       Random random = new Random();
       int colorNumber = random.nextInt(allColor.size());
       return  allColor.get(colorNumber);


    } // End of getTheColor method




    /*
    * Make a viewHolder class and add the recyclerView to it
    * */
    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView desc;
        LinearLayout holderLinearLayout;


        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.TitleShow);
            desc = itemView.findViewById(R.id.DescShow);
            holderLinearLayout = itemView.findViewById(R.id.linearHolder);
        }




    }// End of NoteViewHolder class




        // Move to the AddNewNotes page
        public void AddNewNotes(View view) {
            Intent intent = new Intent(AllShowNotes.this, AddNewNote.class);
            startActivity(intent);
        }// End of AddNewNotes method








}// End of AllShowNotes class