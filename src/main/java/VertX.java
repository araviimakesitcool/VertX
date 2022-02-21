import io.vertx.config.ConfigRetriever;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;

import io.vertx.ext.web.handler.BodyHandler;



public class VertX extends AbstractVerticle {
        public static Vertx ver;


    public static void main(String[] args) {

        ver = Vertx.vertx();                     // vi is Verticle
      //////////////////////////////////

        ver.deployVerticle( new VertX());
        
        ////////////////////////////////////



    }


    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        PostsHandler handle = new PostsHandler();
        Router router = routes(handle);

        // Create the HTTP server
        vertx.createHttpServer()
                // Handle every request using the router
                .requestHandler(router)
                // Start listening
                .listen(8888)
                // Print the port
                .onSuccess(server -> {
                    startPromise.complete();
                    System.out.println("HTTP server started on port " + server.actualPort());
                })
                .onFailure(event -> {
                    startPromise.fail(event);
                    System.out.println("Failed to start HTTP server:" + event.getMessage());
                });


    }



    @Override
    public void stop()  {

    }
    //create routes
    private Router routes(PostsHandler handlers) {
        // Create a Router
        Router router = Router.router(ver);
        // register BodyHandler globally.
        //router.route().handler(BodyHandler.create());
        router.get("/posts").produces("application/json").handler(handlers::all);
        router.post("/posts").consumes("application/json").handler(BodyHandler.create()).handler(handlers::save);
        router.get("/posts/:id").produces("application/json").handler(handlers::get).failureHandler(frc -> frc.response().setStatusCode(404).end());
        router.put("/posts/:id").consumes("application/json").handler(BodyHandler.create()).handler(handlers::update);
        router.delete("/posts/:id").handler(handlers::delete);
        router.get("/hello").handler(rc -> rc.response().end("Hello from my route"));
        return router;
    }



}
