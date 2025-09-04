package repository;

import model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class PostRepository {

    private List<Post> posts = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong(0);

    public List<Post> all() {
        return Collections.unmodifiableList(posts);
    }

    public Optional<Post> getById(long id) {
        return posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            post.setId(idCounter.incrementAndGet());
            posts.add(post);
        } else {
            Optional<Post> existingPost = getById(post.getId());
            if (existingPost.isPresent()) {
                existingPost.get().setContent(post.getContent());
            } else {
                return null;
            }
        }
        return post;
    }

    public void removeById(long id) {
        posts.removeIf(p -> p.getId() == id);
    }
}
