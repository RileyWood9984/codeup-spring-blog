package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "This is the landing page!";
    }

    @GetMapping("/roll-dice")
    public String rolling() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    @ResponseBody
    public String rolling(@PathVariable int n) {
        int newRoll = (int) ((Math.random()*6)+1);
        int r1 = (int)((Math.random()*6)+1);
        int r2 = (int)((Math.random()*6)+1);
        int r3 = (int)((Math.random()*6)+1);
        int r4 = (int)((Math.random()*6)+1);
        int r5 = (int)((Math.random()*6)+1);
        int r6 = (int)((Math.random()*6)+1);
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        rolls.add(r1);
        rolls.add(r2);
        rolls.add(r3);
        rolls.add(r4);
        rolls.add(r5);
        rolls.add(r6);
        int counter=0;
        for (int roll:rolls) {
            if (roll==n){
                counter++;
            }
        }
        System.out.println(rolls.get(1));
        System.out.println(rolls.get(2));
        System.out.println(rolls.get(3));
        System.out.println(rolls.get(4));
        System.out.println(rolls.get(5));
        System.out.println(rolls.get(0));

        return "Your guess was " + n + " the roll was " + newRoll +". You matched "+ counter+" times out of 6 additional rolls.";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
