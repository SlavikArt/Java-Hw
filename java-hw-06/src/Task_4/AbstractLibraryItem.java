package Task_4;

public abstract class AbstractLibraryItem implements LibraryItem {
    protected String title;

    public AbstractLibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
