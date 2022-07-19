package mf.o.self_educated.lifenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddNewNote extends AppCompatActivity {
    TextView header;
    EditText titleInput , descInput;
    SharedPreferences sharedPreferencesData;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Title = "titleKey";
    public static final String Desc = "descKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);

        sharedPreferencesData = getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE);
        String name = sharedPreferencesData.getString(MyPREFERENCES, null);
        if(name != null) {
            Intent intent = new Intent(AddNewNote.this, NotesRoom.class);
            startActivity(intent);
        }




        header = (TextView) findViewById(R.id.NewNotes);
        titleInput = (EditText) findViewById(R.id.TitleInput);
        descInput = (EditText) findViewById(R.id.DescriptionInput);
    }// End of onCreate method




    public void SaveButton(View view) {

        SharedPreferences.Editor editor = sharedPreferencesData.edit();
        editor.putString(Title,titleInput.getText().toString());
        editor.putString(Desc,descInput.getText().toString());
        editor.apply();

        Intent intent = new Intent(AddNewNote.this, NotesRoom.class);
        startActivity(intent);


    }// End of SaveButton method















}// End of AddNewNote class