package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String showPath(Long id) {
        return showPath(String.valueOf(id));
    }

    public static String showPath(String id) {
        return "/posts/" + id;
    }

    public static String postsPath() {
        return "/posts";
    }
    // END
}
