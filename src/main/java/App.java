import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Collections;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    //homepage
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("artists",Artist.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //artist page
    get("/artist/:id", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      Artist currentArtist = Artist.find(Integer.parseInt(request.params(":id")));
      model.put("artist",currentArtist);
      model.put("cds",currentArtist.getCDs());
      model.put("template", "templates/artist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Submits form on a new artist
    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Artist anArtist = new Artist(request.queryParams("artist"));
      model.put("artists",Artist.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Submits a new CD
    post("/artist/:id" , (request,response)-> {
      Map<String, Object> model = new HashMap<String, Object>();
      Artist currentArtist = Artist.find(Integer.parseInt(request.queryParams("categoryId")));
      CD newCD = new CD(request.queryParams("cd"),request.queryParams("year"));
      currentArtist.addCDs(newCD);
      model.put("artist",currentArtist);
      model.put("cds",currentArtist.getCDs());
      model.put("template", "templates/artist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
