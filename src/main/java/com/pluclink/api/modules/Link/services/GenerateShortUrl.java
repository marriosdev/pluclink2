package com.pluclink.api.modules.Link.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GenerateShortUrl {
    public String execute(String url) {
        ArrayList<String> characters = new ArrayList<>(
            Arrays.asList(
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d",
                "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "0", "1", "2", "3", "4", "5", "6", "7",
                "8", "9"
            )
        );
        String shortUrl = "";
        int countCharacters = characters.size(); 

        for(int i=0; i<7; i++) {
            shortUrl += characters.get((new Random()).nextInt(countCharacters - 1));            
        }

        return shortUrl;
    }
}
