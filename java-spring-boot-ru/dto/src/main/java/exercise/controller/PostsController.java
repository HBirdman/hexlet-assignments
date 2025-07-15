package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<PostDTO> index() {
        List<Post> posts = postRepository.findAll();
        var result = posts.stream()
                .map(this::postToDTO)
                .toList();
        return result;
    }

    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        return postToDTO(post);
    }

    private PostDTO postToDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        dto.setComments(commentToDTO(post));
        return dto;
    }

    private List<CommentDTO> commentToDTO(Post post) {
        List<Comment> comments = commentRepository.findByPostId(post.getId());
        List<CommentDTO> dtos = new ArrayList<>();
        for (var comment : comments) {
            var dto = new CommentDTO();
            dto.setId(comment.getId());
            dto.setBody(comment.getBody());
            dtos.add(dto);
        }
        return dtos;
    }
}
// END
