package Peak_Test.Models;

public class KeyCard {
    private String cardNum;
    private int status;

    public KeyCard(String cardNum, int status) {
        this.cardNum = cardNum;
        this.status = status;
    }

    public String getCardNum() {
        return cardNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return cardNum + ',' +  status;
    }
}
