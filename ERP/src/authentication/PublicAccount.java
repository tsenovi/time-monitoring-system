package authentication;

import java.io.Serializable;

public class PublicAccount implements Serializable {

    public final String userName;

    public PublicAccount(Account account) {
        this.userName = account.getAccountName();
    }

    @Override
    public String toString() {
        return "PublicAccount{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
