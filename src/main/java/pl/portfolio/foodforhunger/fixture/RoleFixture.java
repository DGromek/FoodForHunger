package pl.portfolio.foodforhunger.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.portfolio.foodforhunger.entity.Role;
import pl.portfolio.foodforhunger.repository.RoleRepository;

@Component
public class RoleFixture {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleFixture(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void initData() {
        Role role1 = new Role();
        role1.setName("ROLE_USER");
        roleRepository.save(role1);

        Role role2 = new Role();
        role2.setName("ROLE_ADMIN");
        roleRepository.save(role2);
    }

}
