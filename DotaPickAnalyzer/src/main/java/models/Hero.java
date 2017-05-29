package models;

public class Hero implements Comparable<Hero>{
    private String title;
    private int efficiency = 0;

    public Hero(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public int compareTo(Hero other) {
        return other.getEfficiency() - this.getEfficiency();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hero hero = (Hero) o;

        return !(title != null ? !title.equals(hero.title) : hero.title != null);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
