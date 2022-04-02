package authentication;

public class AuthenticatorImpl implements Authenticator {

    private final AccountDatabase accountDatabase;
    private Account loggedAccount;

    public AuthenticatorImpl() {
        this.accountDatabase = new AccountDatabase();
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
    public PublicAccount getLoggedAccount() {
        return new PublicAccount(loggedAccount);
    }
}