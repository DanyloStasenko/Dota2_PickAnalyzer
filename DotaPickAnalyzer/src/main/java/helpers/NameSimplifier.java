package helpers;

/**
 * The program simplifies the input string
 * according to the following rules:
 *      - converting all characters to lowercase
 *      - replacing [spaces] with [-]
 *      - deleting ' (single-quotes)
 *
 * Examples:
 *      ExAmPle       ->  examples
 *      Hello World   ->  hello-world
 *      Somebody's    ->  somebodys
 *
 * @author  Danylo Stasenko
 * @version 1.0
 * @since   2017-05-28
 */
public class NameSimplifier {

    public static String simplifyName(String input){

        StringBuilder builder = new StringBuilder(input.toLowerCase());

        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '\''){
                builder.deleteCharAt(i);
            }
            if (builder.charAt(i) == ' '){
                builder.setCharAt(i, '-');
            }
        }

        return builder.toString();
    }

}
