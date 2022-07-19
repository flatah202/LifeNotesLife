package mf.o.self_educated.lifenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;


public class AddNewNote extends AppCompatActivity {
    EditText titleInput , descInput;
    FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);



        titleInput = (EditText) findViewById(R.id.TitleInput);
        descInput = (EditText) findViewById(R.id.DescriptionInput);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        



    }// End of onCreate method







    public void SaveButton(View view) {




        startActivity(  new Intent(AddNewNote.this, NotesRoom.class));


    }// End of SaveButton method















}// End of AddNewNote class