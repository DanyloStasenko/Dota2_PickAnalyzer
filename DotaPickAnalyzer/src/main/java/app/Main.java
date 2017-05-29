package app;

import helpers.NameSimplifier;
import services.HeroService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        // TODO: create classification: tank, support, carry, etc.
        // TODO: create spring-mvc / java-FX layer

        try {
            HeroService service = new HeroService();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            boolean exit = false;
            while (!exit){
                String input = reader.readLine();

                if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("stop") || input.equalsIgnoreCase("quit")){
                    exit = true;
                } else {
                    service.calculateEffectivity(NameSimplifier.simplifyName(input));
                    service.printBestHeroes();
                }
            }

        } catch (IOException e){
            // e.printStackTrace();
            System.err.println("Bad command... Something went wrong... Closing program");
        }
    }
}
