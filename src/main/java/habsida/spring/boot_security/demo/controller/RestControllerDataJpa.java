package habsida.spring.boot_security.demo.controller;

import habsida.spring.boot_security.demo.model.Role;
import habsida.spring.boot_security.demo.model.User;
import habsida.spring.boot_security.demo.service.RoleService;
import habsida.spring.boot_security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class RestControllerDataJpa {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public RestControllerDataJpa(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/ret")
    public ResponseEntity<List<User>> getAllUsers(Principal principal) {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

//    @GetMapping("/new")
//    public ResponseEntity<List<Role>> newUserForm(Principal principal) {
//        List<Role> roles = roleService.getAllRoles();
//        return ResponseEntity.ok(roles);
//    }

    @PostMapping("/new")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        Set<Role> userRoles = user.getRoles().stream()
                .map(role -> roleService.getRoleById(role.getId()))
                .collect(Collectors.toSet());

        user.setRoles(userRoles);
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value="/update", consumes = {"application/json"})
    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        User user = new User();
        Set<Role> userRoles = user.getRoles().stream()
                .map(role -> roleService.getRoleById(role.getId()))
                .collect(Collectors.toSet());

        user.setRoles(userRoles);
        userService.updateUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delUser(@RequestBody User user) {
        userService.deleteUser(user.getId());
        return ResponseEntity.noContent().build();
    }
}
