package pl.portfolio.foodforhunger.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.portfolio.foodforhunger.entity.Comment;
import pl.portfolio.foodforhunger.repository.CommentRepository;
import pl.portfolio.foodforhunger.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDate;
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

        Comment comment3 = new Comment();
        comment3.setContent("Cakiem gituwa");
        comment3.setCreated(LocalDateTime.now().minusMonths(11).minusDays(4));
        comment3.setRating(3);
        comment3.setAuthor(userRepository.getOne(2L));
        comment3.setReceiver(userRepository.getOne(1L));
        commentRepository.save(comment3);

        Comment comment4 = new Comment();
        comment4.setContent("Bywao lepiej, bywao gorzej. Ujdzie.");
        comment4.setCreated(LocalDateTime.now().minusMonths(4).minusDays(6));
        comment4.setRating(2);
        comment4.setAuthor(userRepository.getOne(2L));
        comment4.setReceiver(userRepository.getOne(1L));
        commentRepository.save(comment4);

        Comment comment5 = new Comment();
        comment5.setContent("Smakowało mi ale mame nie, daje 3 gwiazdki.");
        comment5.setCreated(LocalDateTime.now().minusMonths(1).minusDays(11));
        comment5.setRating(3);
        comment5.setAuthor(userRepository.getOne(2L));
        comment5.setReceiver(userRepository.getOne(1L));
        commentRepository.save(comment5);
    }
}
