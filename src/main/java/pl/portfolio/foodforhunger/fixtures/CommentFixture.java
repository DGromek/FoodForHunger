package pl.portfolio.foodforhunger.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.portfolio.foodforhunger.entity.Comment;
import pl.portfolio.foodforhunger.repository.CommentRepository;
import pl.portfolio.foodforhunger.repository.UserRepository;

import java.time.LocalDateTime;


@Component
public class CommentFixture {

    private CommentRepository commentRepository;
    private UserRepository userRepository;

    @Autowired
    public CommentFixture(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public void initData() {
        Comment comment1 = new Comment();

        comment1.setContent("Wspaniałe te kotlety były, no cudownego. Z chęcią wezmę jeszcze");
        comment1.setCreated(LocalDateTime.now().minusMonths(4).minusDays(3));
        comment1.setRating(5);
        comment1.setAuthor(userRepository.getOne(2L));
        comment1.setReceiver(userRepository.getOne(1L));

        commentRepository.save(comment1);

        Comment comment2 = new Comment();

        comment2.setContent("Ziemniaki niedogotowane, mięso gumowane, surówka rozmiękła. NIE POLECAM!");
        comment2.setCreated(LocalDateTime.now().minusMonths(9).minusDays(7));
        comment2.setRating(1);
        comment2.setAuthor(userRepository.getOne(2L));
        comment2.setReceiver(userRepository.getOne(1L));

        commentRepository.save(comment2);

    }
}
