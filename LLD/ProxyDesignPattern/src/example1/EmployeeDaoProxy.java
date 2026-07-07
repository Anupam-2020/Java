package example1;

public class EmployeeDaoProxy implements EmployeeDao {

    private EmployeeDao employeeDaoObj;
    private String clientRole;

    public EmployeeDaoProxy(String clientRole) {
        employeeDaoObj = new EmployeeDaoImpl(); // creating actual object.
        this.clientRole = clientRole;
    }

    @Override
    public void getEmployeeById(int empID) {
        if(clientRole.equalsIgnoreCase("ADMIN") || clientRole.equalsIgnoreCase("USER")) {
            employeeDaoObj.getEmployeeById(empID);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    @Override
    public void createEmployee(EmployeeDTO obj) {
        if(clientRole.equalsIgnoreCase("ADMIN")) {
            employeeDaoObj.createEmployee(obj);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }
}
