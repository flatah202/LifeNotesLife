package mf.o.self_educated.lifenotes;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

        // creating a variable for array list and context.
        private ArrayList<NotesList> notesListArrayList;
        private Context context;

        // creating a constructor for our variables.
        public NoteAdapter(ArrayList<NotesList> notesListArrayList1, Context context) {
            this.notesListArrayList = notesListArrayList1;
            this.context = context;
        }

        @NonNull
        @Override
        public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // below line is to inflate our layout.
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_notes_room, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, int position) {
            // setting data to our views of recycler view.
            NotesList list = notesListArrayList.get(position);
            holder.TitleNotes.setText(list.getTitleNotes());
            holder.DescNotes.setText(list.getDescriptionNotes());
        }

        @Override
        public int getItemCount() {
            // returning the size of array list.
            return notesListArrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            // creating variables for our views.
            private TextView TitleNotes, DescNotes;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                // initializing our views with their ids.
                TitleNotes = itemView.findViewById(R.id.TitleShow);
                DescNotes = itemView.findViewById(R.id.DescShow);
            }
        }






}// End of NoteAdapter class
