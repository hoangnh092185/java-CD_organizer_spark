// import java.util.Map;
// import java.util.HashMap;
// import java.util.ArrayList;
// import spark.ModelAndView;
// import spark.template.velocity.VelocityTemplateEngine;
// import static spark.Spark.*;
// import java.util.Collections;
//
// public class App {
//   public static void main(String[] args) {
//     staticFileLocation("/public");
//     String layout = "templates/layout.vtl";
//
//     get("/", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("template", "templates/index.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//
//       ArrayList<CD> cdsArray = request.session().attribute("cds");
//       if (cdsArray == null) {
//         cdsArray = new ArrayList<CD>();
//         request.session().attribute("cds", cdsArray);
//       }
//
//       CD userCD = new CD(request.queryParams("cd-name"), request.queryParams("band-name"), request.queryParams("year"));
//       cdsArray.add(userCD);
//       if(cdsArray.size()>1){
//         Collections.sort(cdsArray);
//       }
//       model.put("cds", request.session().attribute("cds"));
//       model.put("template", "templates/index.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//
//
//   }
// }
