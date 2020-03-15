package pl.betleja.model;

public enum Color {

    BLACK("black"),
    WHITE("white"),
    RED("red"),
    BLUE("blue"),
    GREEN("green"),
    YELLOW("yellow"),
    GREY("grey"),
    SILVER("silver"),
    OTHER("other");

    private String description;

    Color(String description) {

        this.description = description;
    }


}
