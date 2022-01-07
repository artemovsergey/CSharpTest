package model;

public class Human {

    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String lookIntoTheSky() {
        return "вы видите бесконечность: расстояние необъемлемо и оттого бессмысленно";
    }

}
