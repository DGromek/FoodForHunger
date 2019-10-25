package pl.portfolio.foodforhunger.WORKINPROGRESS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.portfolio.foodforhunger.WORKINPROGRESS.Message;

@Repository
@Transactional
public interface MessageRepository extends JpaRepository<Message, Long> {
}
