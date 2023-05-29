package Peak_Test.Models;

import java.util.ArrayList;
import java.util.List;

public class KeyCardList {
    private List<KeyCard> keyCards;

    public KeyCardList() {
        this.keyCards = new ArrayList<KeyCard>();
    }

    public void add(KeyCard keyCard) {
        keyCards.add(keyCard);
    }

    public void setKeyCards(List<KeyCard> keyCardList) {
        keyCards = keyCardList;
    }

    public KeyCard findStatusEmpty() {
        for (KeyCard k: keyCards) {
            if (k.getStatus() == 1) {
                return k;
            }
        }
        return null;
    }

    public KeyCard findStatusNotEmpty(String number){
        for (KeyCard k: keyCards) {
            if (k.getCardNum().equals(number)) {
                return k;
            }
        }
        return null;
    }
}
