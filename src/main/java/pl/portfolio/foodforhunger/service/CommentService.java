package pl.portfolio.foodforhunger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.portfolio.foodforhunger.entity.Comment;
import pl.portfolio.foodforhunger.repository.CommentRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment getOne(Long id) {
        return commentRepository.getOne(id);
    }

    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    public Page<Comment> findAllByReceiverIdOrderByCreatedDesc(Long receiverId, int pageId, int size) {
        return commentRepository.findAllByReceiverIdOrderByCreatedDesc(receiverId, PageRequest.of(pageId, size));
    }
}
