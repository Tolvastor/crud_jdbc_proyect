package org.example.crud_jdbc_proyect.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PiramideController {

    @GetMapping("/piramide")
    public String pyramid(HttpSession session, Model model) {
        if (session.getAttribute("user") == null)
            return "redirect:/";

        return "piramide";
    }

    @PostMapping("/piramide")
    public String generatePyramid(
            @RequestParam int height,
            HttpSession session,
            Model model) {

        if (session.getAttribute("user") == null)
            return "redirect:/";

        model.addAttribute("height", height);
        return "piramide";
    }
}
