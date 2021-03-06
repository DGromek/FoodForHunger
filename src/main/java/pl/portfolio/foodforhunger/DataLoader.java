package pl.portfolio.foodforhunger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.portfolio.foodforhunger.fixture.CommentFixture;
import pl.portfolio.foodforhunger.fixture.DishFixture;
import pl.portfolio.foodforhunger.fixture.RoleFixture;
import pl.portfolio.foodforhunger.fixture.UserFixture;

@Component
public class DataLoader implements ApplicationRunner {
    private CommentFixture commentFixture;
    private DishFixture dishFixture;
    private RoleFixture roleFixture;
    private UserFixture userFixture;

    @Autowired
    public DataLoader(CommentFixture commentFixture, DishFixture dishFixture, RoleFixture roleFixture, UserFixture userFixture) {
        this.commentFixture = commentFixture;
        this.dishFixture = dishFixture;
        this.roleFixture = roleFixture;
        this.userFixture = userFixture;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        commentFixture.initData();
        dishFixture.initData();
        roleFixture.initData();
        userFixture.initData();
    }
}
