package habsida.spring.boot_security.demo.controller;

import habsida.spring.boot_security.demo.model.Role;
import habsida.spring.boot_security.demo.model.User;
import habsida.spring.boot_security.demo.service.RoleService;
import habsida.spring.boot_security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String getAllUsers(Model model, Principal principal) {
//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);
        model.addAttribute("activePage", "admin");
        model.addAttribute("activePage1", "allUser");
        model.addAttribute("content", "admin-panel");
        model.addAttribute("content1", "users-list");
        return "layout";
    }

    @GetMapping("/admin/new")
    public String newUserForm(Model model, Principal principal) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("activePage", "admin");
        model.addAttribute("activePage1", "newUser");
        model.addAttribute("content", "admin-panel");
        model.addAttribute("content1", "new-user");
        return "layout";
    }
}
