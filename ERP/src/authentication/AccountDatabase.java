package authentication;

import java.util.List;

public interface AccountDatabase {

    void addEmployee(Employee account);

    List<Employee> getEmployees();

    boolean accountExists(String username);

    Account getAccount(String username);
}
