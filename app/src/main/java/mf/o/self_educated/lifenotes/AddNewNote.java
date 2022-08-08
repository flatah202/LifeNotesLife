package mf.o.self_educated.lifenotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class AddNewNote extends AppCompatActivity {
    EditText titleInput , descInput;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore fireStore;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);



        titleInput = (EditText) findViewById(R.id.TitleInput);
        descInput = (EditText) findViewById(R.id.DescriptionInput);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        fireStore = FirebaseFirestore.getInstance();


    }// End of onCreate method






    /**
     * The method for saving the notes in our
     * firebase document .
     *
     * */
   public void SaveButton(View view) {

        String title = titleInput.getText().toString();
        String  desc = descInput.getText().toString();
        if (title.isEmpty() || desc.isEmpty()){

            Toast.makeText(getApplicationContext(), "Both are Require", Toast.LENGTH_SHORT).show();
        }
        else {
            DocumentReference reference = fireStore.collection("Notes").document("All Notes").collection("my Notes").document();
            Map<String , Object> note = new HashMap<>();
            note.put("TitleNotes",title);
            note.put("DescriptionNotes",desc );


            reference.set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(getApplicationContext(), "The note created successful", Toast.LENGTH_SHORT).show();
                    startActivity(  new Intent(AddNewNote.this, NotesRoom.class));

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Fail to created note", Toast.LENGTH_SHORT).show();

                }
            });

        }// End of else statement





    }// End of SaveButton method















}// End of AddNewNote class