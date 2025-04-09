package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.Generator;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.render("build.jte");
    }

    public static void create(Context ctx) throws Exception {
        var name = ctx.formParam("name");
        var password = encrypt(ctx.formParam("password"));
        var user = UsersRepository.findByName(name)
                .orElseThrow(() -> new NotFoundResponse("Wrong username or password"));
        if (!user.getPassword().equals(password)) {
            var error = "Wrong username or password";
            var page = new LoginPage(name, error);
            ctx.render("build.jte", model("page", page));
            return;
        }
        ctx.sessionAttribute("currentUser", name);
        ctx.redirect("/");
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
    // END
}
