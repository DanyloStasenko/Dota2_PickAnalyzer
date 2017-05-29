package helpers;

import static org.junit.Assert.*;

public class NameSimplifierTest {

    @org.junit.Test
    public void testSimplifyTitle() throws Exception {
        assertEquals("lone-druid", NameSimplifier.simplifyName("Lone Druid"));
        assertEquals("drow-ranger", NameSimplifier.simplifyName("Drow Ranger"));
        assertEquals("elder-titan", NameSimplifier.simplifyName("Elder Titan"));

        assertEquals("nyx-assassin", NameSimplifier.simplifyName("Nyx Assassin"));
        assertEquals("shadow-fiend", NameSimplifier.simplifyName("Shadow Fiend"));
        assertEquals("winter-wyvern", NameSimplifier.simplifyName("Winter Wyvern"));

        assertEquals("natures-prophet", NameSimplifier.simplifyName("Nature's Prophet"));
        assertEquals("ancient-apparition", NameSimplifier.simplifyName("Ancient Apparition"));
        assertEquals("keeper-of-the-light", NameSimplifier.simplifyName("Keeper of the Light"));
    }
}