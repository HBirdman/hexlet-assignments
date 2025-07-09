package exercise.controller.users;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    List<Post> posts = new ArrayList<>();


    @GetMapping("/users/{id}/posts")
    public List<Post> findPosts(@PathVariable int id) {
        return posts.stream().filter(p -> p.getUserId() == id).toList();
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@PathVariable int id, @RequestBody Post post) {
        post.setUserId(id);
        post.setSlug(post.getSlug());
        post.setTitle(post.getTitle());
        post.setBody(post.getBody());
        posts.add(post);
        return post;
    }
}
// END
