package medxpert.main.daniyal_medxpert.patient.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import medxpert.main.daniyal_medxpert.patient.ModelNotes.NotesModel;

import medxpert.main.daniyal_medxpert.R;

import java.util.ArrayList;

public class Adapter_Notes extends RecyclerView.Adapter<Adapter_Notes.ViewHolder> {
    private ArrayList<NotesModel> notesList;
    private Context context;

    public Adapter_Notes(ArrayList<NotesModel> notesList, Context context) {
        this.notesList = notesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotesModel note = notesList.get(position);

        holder.heading.setText(note.getHeading());
        holder.descriptionforNotes.setText(note.getDescriptionNotes());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading, descriptionforNotes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.HeadingNotes);
            descriptionforNotes = itemView.findViewById(R.id.descriptionNotes);
        }
    }
}