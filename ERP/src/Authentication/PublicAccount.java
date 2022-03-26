package Authentication;

public class PublicAccount {

    public final long accountId;
    public final String userName;

    public PublicAccount(Account account) {
        this.accountId = account.getAccountId();
        this.userName = account.getAccountName();
    }
}
