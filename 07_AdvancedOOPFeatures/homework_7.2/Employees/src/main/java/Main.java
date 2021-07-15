import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        Stream<Employee> stream = staff.stream();
        stream.sorted(Comparator.comparing(Employee ::getWorkStart)).max(Comparator.comparing(Employee ::getSalary))
                .ifPresent(System.out::println);
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year
        return null;
    }
}