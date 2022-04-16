package authentication;

import java.io.Serializable;
import java.util.Objects;

public class PublicAccount implements Serializable {

    public final String userName;

    public PublicAccount(Account account) {
        this.userName = account.getAccountName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicAccount that = (PublicAccount) o;
        return userName.equals(that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public String toString() {
        return "PublicAccount{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
