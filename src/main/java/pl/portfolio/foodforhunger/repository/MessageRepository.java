package pl.portfolio.foodforhunger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.portfolio.foodforhunger.entity.Message;

@Repository
@Transactional
public interface MessageRepository extends JpaRepository<Message, Long> {
}
