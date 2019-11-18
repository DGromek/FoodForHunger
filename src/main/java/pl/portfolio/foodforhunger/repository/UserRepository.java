package pl.portfolio.foodforhunger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.portfolio.foodforhunger.entity.User;

import javax.persistence.Entity;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
