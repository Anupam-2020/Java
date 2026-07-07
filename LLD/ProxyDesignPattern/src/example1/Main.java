package example1;

public class Main {
    public static void main(String[] args) {
        String client = "Admin";
        EmployeeDTO employeeDTO = new EmployeeDTO(2L, "Electrical");
        EmployeeDaoProxy employeeDaoProxy = new EmployeeDaoProxy(client);
        employeeDaoProxy.createEmployee(employeeDTO);
        employeeDaoProxy.getEmployeeById(12);
    }
}
