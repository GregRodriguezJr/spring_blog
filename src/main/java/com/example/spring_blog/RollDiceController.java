package com.example.spring_blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{num}")
    public String userInput(@PathVariable int num, Model model) {
        int randomNum = (int) Math.floor(Math.random() * 7);

        boolean result = num == randomNum;

        model.addAttribute("result" , result);
        model.addAttribute("randomNum" , randomNum);
        model.addAttribute("userGuess", num);

        return "roll-dice";
    }

}