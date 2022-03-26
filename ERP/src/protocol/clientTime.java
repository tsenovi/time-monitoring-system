package protocol;

public class clientTime <Client, Integer>{

    private Client c;
    private Integer t;

    public clientTime(Client c, Integer t) {
        this.c = c;
        this.t = t;
    }

    public Client getC() {
        return c;
    }

    public Integer getT() {
        return t;
    }
}
