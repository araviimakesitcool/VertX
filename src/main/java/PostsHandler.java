import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

public class PostsHandler {

    DataBase db ;

    public PostsHandler() {
        this.db = new DataBase();
    }

    public void all(RoutingContext rc) {

        rc.response()
                .putHeader("content-type",
                        "application/json; charset=utf-8")
                .end(Json.encodePrettily(db.readingList.values()));
    }

    public void save(RoutingContext routingContext) {
    }

    public void get(RoutingContext routingContext) {
    }

    public void update(RoutingContext routingContext) {
    }

    public void delete(RoutingContext routingContext) {
    }
}