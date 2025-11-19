package org.example.crud_jdbc_proyect.controller;

import org.example.crud_jdbc_proyect.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {


    @GetMapping("/")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        // Usuario hardcodeado para demostración
        User user = null;
        if (username.equals("admin")) {
            user = new User(1L, "admin", "password");
        }
         else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
        if (!user.getPassword().equals(password)) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
        session.setAttribute("user", user);
        return "redirect:/piramide";
    }
}
