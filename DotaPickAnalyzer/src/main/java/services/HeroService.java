package services;

import helpers.PageParser;
import models.Hero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HeroService {

    /** using this variable to calculate how many heroes are we fighting with */
    private int count = 0;
    private ArrayList<Hero> heroes = new ArrayList<Hero>();

    public HeroService() throws IOException{
        if (heroes.isEmpty()){
            heroes = PageParser.getHeroes();
        }
    }

    public ArrayList<Hero> getHeroList() {
        return heroes;
    }

    public void setHeroList(ArrayList<Hero> heroList) {
        this.heroes = heroList;
    }


    /** getting effectivityList for hero and adding it to total */
    public void calculateEffectivity(String heroTitle) throws IOException{

        ArrayList<Hero> effectivityList = PageParser.getEfficiencyList(heroTitle);

        for (Hero first : heroes) {
            for (Hero second : effectivityList) {
                if (first.getTitle().equals(second.getTitle())){
                    first.setEfficiency(first.getEfficiency() + second.getEfficiency());
                }
            }
        }
        count++;
    }

    /** printing only best 25 heroes */
    public void printBestHeroes(){
        Collections.sort(heroes);
        for (int i = 0; i < 25; i++) {
            Hero hero = heroes.get(i);
            System.out.println(String.format("%.2f \t%s", (double)(hero.getEfficiency() - count) / (111 * count), hero.getTitle()));
        }
    }

    /** printing all 112 heroes */
    public void printFullList(){
        Collections.sort(heroes);
        for (Hero hero : heroes) {
            System.out.println(String.format("%.2f \t%s",
                    (double)(hero.getEfficiency() - count) / (111 * count), hero.getTitle()));
        }
    }
}
