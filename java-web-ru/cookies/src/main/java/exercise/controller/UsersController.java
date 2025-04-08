package exercise.controller;

import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;

import java.util.Objects;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void register(Context ctx) {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        String token = Security.generateToken();
        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        ctx.cookie("token", token);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", String.class).get();
        var cookieToken = ctx.cookie("token");
        var user = UserRepository.find(Long.valueOf(id)).get();
        if (Objects.equals(cookieToken, user.getToken())) {
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        } else
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    // END
}
