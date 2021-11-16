package guru.qa.enums;

public enum Brands {

    FINLANDIA("Finlandia"),
    KANZLER("Kanzler"),
    MERKEL("Merkel"),
    BULAT("Булат"),
    SLAVYANKA("Славянка"),
    EUROSTAHL("Eurostahl"),
    HUNTER("Hunter"),
    OREGON("Oregon"),
    WAGNER("Wagner");

    private final String name;

    Brands(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
