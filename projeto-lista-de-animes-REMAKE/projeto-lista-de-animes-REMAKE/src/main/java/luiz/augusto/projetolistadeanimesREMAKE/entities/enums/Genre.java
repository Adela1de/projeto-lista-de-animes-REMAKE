package luiz.augusto.projetolistadeanimesREMAKE.entities.enums;

import lombok.Getter;

public enum Genre {

    SLICE_OF_LIFE(1),
    SHOUNEN(2),
    SEINEN(3),
    ACTION(4),
    ADVENTURE(5),
    DRAMA(6),
    FANTASY(7),
    TERROR(8),
    THRILLER(9),
    COMEDY(10),
    ROMANCE(11);

    @Getter
    private int code;

    private Genre(int code) {this.code = code;}

    public static Genre valueOf(int code)
    {
        for (Genre value: Genre.values()) {
            if(value.getCode() == code) return value;
        }throw new IllegalArgumentException("Invalid Genre");
    }

}
