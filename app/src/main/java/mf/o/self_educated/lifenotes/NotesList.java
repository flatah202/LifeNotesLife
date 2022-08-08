package mf.o.self_educated.lifenotes;

public class NotesList {

        /** variables for our Notes
        name and description.**/
        private String TitleNotes;
        private String DescriptionNotes;

        // creating constructor for our variables.
        public NotesList(String titleNotes, String descriptionNotes) {
            this.TitleNotes = titleNotes;
            this.DescriptionNotes = descriptionNotes;
        }

        // creating getter and setter methods.
        public String getTitleNotes() {
            return TitleNotes;
        }

        public void setTitleNotes(String titleNotes) {
            this.TitleNotes = titleNotes;
        }

        public String getDescriptionNotes() {
            return DescriptionNotes;
        }

        public void setDescriptionNotes(String descriptionNotes) {
            this.DescriptionNotes = descriptionNotes;
        }



}// End of NotesList Class
