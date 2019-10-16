package pl.portfolio.foodforhunger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.portfolio.foodforhunger.fixtures.CommentFixture;
import pl.portfolio.foodforhunger.fixtures.DishFixture;
import pl.portfolio.foodforhunger.fixtures.UserFixture;

@Component
public class DataLoader implements ApplicationRunner {
    private CommentFixture commentFixture;
    private DishFixture dishFixture;
    private UserFixture userFixture;

    @Autowired
    public DataLoader(CommentFixture commentFixture, DishFixture dishFixture, UserFixture userFixture) {
        this.commentFixture = commentFixture;
        this.dishFixture = dishFixture;
        this.userFixture = userFixture;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        commentFixture.initData();
        dishFixture.initData();
        userFixture.initData();
    }
}
