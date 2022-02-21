import java.util.concurrent.atomic.AtomicInteger;

public class DataObject {

    private static final AtomicInteger COUNTER
            = new AtomicInteger();

    private final int id;

    private String title;

    private String url;

    public DataObject( String title, String url) {
        this.id = COUNTER.getAndIncrement();
        this.title = title;
        this.url = url;
    }

    public DataObject() {
        this.id = COUNTER.getAndIncrement();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
