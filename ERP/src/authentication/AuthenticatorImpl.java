package authentication;

import java.util.List;
import java.util.stream.Collectors;

public class AuthenticatorImpl implements Authenticator {

    private final AccountDatabaseImpl accountDatabase;
    private Account loggedAccount;

    public AuthenticatorImpl() {
        this.accountDatabase = new AccountDatabaseImpl();
        this.loggedAccount = null;
    }

    @Override
    public boolean hasLoggedAccount() {
        return loggedAccount != null;
    }

    @Override
    public LoginStatus login(String name, String password) {
        Account account = accountDatabase.getAccount(name);
        if (account != null && account.getAccountPassword().equals(password)){
            loggedAccount = account;
            return loggedAccount instanceof Admin ? LoginStatus.ADMIN_LOGGED : LoginStatus.EMPLOYEE_LOGGED;
        }
        return LoginStatus.LOGIN_FAILED;
    }

    @Override
    public boolean hasLoggedAdmin() {
        return loggedAccount instanceof Admin;
    }

    @Override
    public boolean registerEmployee(String name, String password) {
        if (accountDatabase.accountExists(name)){
            return false;
        }

        Employee employee = new Employee(name, password);
        accountDatabase.addEmployee(employee);
        return true;
    }

    @Override
    public void logout() {
        loggedAccount = null;
    }

    @Override
    public List<PublicAccount> getEmployees() {
        return accountDatabase.getEmployees()
                .stream()
                .map(PublicAccount::new)
                .collect(Collectors.toList());
    }

    @Override
    public PublicAccount getLoggedAccount() {
        return new PublicAccount(loggedAccount);
    }
}
