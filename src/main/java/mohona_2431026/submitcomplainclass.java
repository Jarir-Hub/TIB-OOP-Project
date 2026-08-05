package mohona_2431026;
import java.io.Serializable;

public class submitcomplainclass implements Serializable {
    private String title;
    private String category;
    private String description;
    private String location;
    private String attachment;

    public submitcomplainclass() {
    }

    public submitcomplainclass(String description, String title, String category, String location, String attachment) {
        this.description = description;
        this.title = title;
        this.category = category;
        this.location = location;
        this.attachment = attachment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "submitcomplainclass{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}
