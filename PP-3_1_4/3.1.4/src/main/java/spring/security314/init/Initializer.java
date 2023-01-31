package spring.security314.init;

import org.springframework.stereotype.Component;
import spring.security314.model.Role;
import spring.security314.model.User;
import spring.security314.service.UserServiceImp;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Initializer {

    private final UserServiceImp userService;

    public Initializer(UserServiceImp userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");


        userService.addRole(role1);
        userService.addRole(role2);

        List<Role> roleAdmin = new ArrayList<>();
        List<Role> roleUser = new ArrayList<>();

        roleAdmin.add(role1);
        roleAdmin.add(role2);

        roleUser.add(role2);


        User user1 = new User("user", "normal", 43, "user@mail.ru","u", roleUser);
        User admin1 = new User("admin", "superAdmin", 23, "admin@mail.ru","a", roleAdmin);

        userService.add(admin1);
        userService.add(user1);

    }
}
