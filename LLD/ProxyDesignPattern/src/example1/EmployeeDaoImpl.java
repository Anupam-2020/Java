package example1;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void getEmployeeById(int empID) {
        System.out.println("Fetching employee info from DB with id: "+empID);
    }

    @Override
    public void createEmployee(EmployeeDTO obj) {
        System.out.println("Creating employee with details -> "+ obj.getDepartment() + " "+obj.getId());
    }
}
