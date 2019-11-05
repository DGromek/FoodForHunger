//package pl.portfolio.foodforhunger.validator;
//
//import org.springframework.context.ApplicationContext;
//import pl.portfolio.foodforhunger.service.UserService;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
//    private UserService userService;
//
//    public UniqueUsernameValidator() {
//        this.userService = ApplicationContextService.getBean(UserService.class);
//    }
//
//    @Override
//    public boolean isValid(String username, ConstraintValidatorContext context) {
//        return userService.findByUsername(username) == null;
//    }
//}
