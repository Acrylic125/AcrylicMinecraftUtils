package com.acrylic.version_latest.Messages;

public enum Symbols {

    HEART("❤"),
    BOX("⬛"),
    STAR("⭐"),
    VERTICAL_BAR("▌"),
    DOUBLE_ARROW_RIGHT("»"),
    DOUBLE_ARROW_LEFT("«"),
    SINGLE_ARROW_RIGHT("➤"),

    //Math
    PLUS_MINUS("±"),

    BUKKIT_COLOR_CODE_SYMBOL("\u00A7"),
    COLOR_CODE_SYMBOL("&");

    private final String symbol;

    Symbols(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
