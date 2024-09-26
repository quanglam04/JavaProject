package com.example.food_store.controller.admin;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.food_store.domain.User;
import com.example.food_store.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("listUser", users);
        return "admin/user/table-user";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute("newUser") User trinhlam) {
        this.userService.handleSaveUser(trinhlam);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("id", id);
        model.addAttribute("user", user);

        return "admin/user/show";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("id", id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") User trinhlam) {
        User currentUser = this.userService.getUserById(trinhlam.getId());
        if (currentUser != null) {
            currentUser.setAddress(trinhlam.getAddress());
            currentUser.setFullName(trinhlam.getFullName());
            currentUser.setPhone(trinhlam.getPhone());

            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        // User user = new User();
        // user.setId(id);
        model.addAttribute("id", id);
        model.addAttribute("newUser", new User());

        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("newUser") User trinhlam) {
        this.userService.deleteUserById(trinhlam.getId());

        return "redirect:/admin/user";
    }

}
