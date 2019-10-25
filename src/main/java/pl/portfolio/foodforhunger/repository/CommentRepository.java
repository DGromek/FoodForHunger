package pl.portfolio.foodforhunger.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.portfolio.foodforhunger.entity.Comment;


import java.util.List;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByReceiverId(Long id);

    Page<Comment> findAllByReceiverId(Long id, Pageable pageable);
}
