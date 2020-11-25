package java8;

public class FilterEmployeeByage<E> implements MyPredicate <Employee>{

    @Override
    public boolean test(Employee employee) {
        return employee.getAge()>35;
    }
}
