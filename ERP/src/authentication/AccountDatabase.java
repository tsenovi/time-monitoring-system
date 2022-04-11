package authentication;

public interface AccountDatabase {

    void addEmployee(Employee account);

    boolean accountExists(String username);

    Account getAccount(String username);
}
