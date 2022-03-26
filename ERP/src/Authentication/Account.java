package Authentication;

public class Account {
    private static int accountCount = 0;
    private final long accountId;
    private final String userName;
    private final String password;


    public Account(String userName, String password) {
        accountCount++;
        this.accountId = accountCount;
        this.userName = userName;
        this.password = password;

    }

    public long getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return userName;
    }

    public String getAccountPassword() {
        return password;
    }

}
