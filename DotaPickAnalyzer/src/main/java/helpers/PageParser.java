package helpers;

import models.Hero;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageParser {
    /** getting list with hero names */
    public static ArrayList<Hero> getHeroes() throws IOException{
        Document htmlDoc = Jsoup.connect("https://www.dotabuff.com/heroes/spectre/matchups")
                .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                .timeout(10000)
                .get();

        Elements parsedElements = htmlDoc.body().getElementsByTag("div");   // getting all <div> elements
        String regex = "<td class=\"cell-xlarge\">.+";                      // Hero names are here + a lot of trash in this line

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parsedElements.toString());
        ArrayList<Hero> heroes = new ArrayList<Hero>();

        while (matcher.find()) {
            // deleting unused characters to get hero names
            StringBuilder builder = new StringBuilder(matcher.group());
            builder.delete(builder.length() - 9, builder.length());
            builder.delete(0, builder.lastIndexOf(">") + 1);

            Hero hero = new Hero(builder.toString());

            if (!heroes.contains(hero)){
                heroes.add(hero);
            }
        }

        return heroes;
    }

    /** getting counter-picks list */
    public static ArrayList<Hero> getEfficiencyList(String heroTitle) throws IOException{
        Document htmlDoc = Jsoup.connect("https://www.dotabuff.com/heroes/" + heroTitle + "/matchups")
                .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                .timeout(10000)
                .get();

        Elements parsedElements = htmlDoc.body().getElementsByTag("div");
        String regex = "<td class=\"cell-xlarge\">.+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parsedElements.toString());

        ArrayList<Hero> heroes = new ArrayList<Hero>();

        while (matcher.find()) {

            StringBuilder builder = new StringBuilder(matcher.group());
            builder.delete(builder.length() - 9, builder.length());
            builder.delete(0, builder.lastIndexOf(">") + 1);

            Hero hero = new Hero(builder.toString());
            if (!heroes.contains(hero)){
                heroes.add(hero);
            }
        }

        int i = 1;
        for (Hero hero : heroes) {
            hero.setEfficiency(hero.getEfficiency() + i++);
        }

        return heroes;
    }
}
