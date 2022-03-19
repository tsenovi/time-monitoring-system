package Authentication;

public class Account {
    private final String userName;
    private final String password;

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getAccountName() {
        return userName;
    }

    public String getAccountPassword() {
        return password;
    }
}
