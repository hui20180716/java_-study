import java8.Employee;
import java8.FilterEmployeeByage;
import org.junit.Test;

import java.util.*;

public class TestJava8 {
    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    public static void main(String[] args) {
        System.out.println("aa");
        new TestJava8().test03();
    }
    @Test
    public void test01(){
    //匿名内部类
    Comparator<Integer> comparator = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1,o2);
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    };
    //调用
    TreeSet<Integer> set = new TreeSet<>(comparator);
}
    @Test
    public void test02(){
        // Lambda 表达式
        Comparator<Integer> comparator = (a, b) -> Integer.compare(a, b);

        TreeSet<Integer> set = new TreeSet<>(comparator);
    }
    @Test
    public void test03(){
        System.out.println("开始");
//        for (Employee a:filterEmployees2(emps)){
//            System.out.println(a.toString());
//        }
//        List<Employee> employees = fitterEmPloyee(emps,new MyPredicate<Employee>(){
//
//            @Override
//            public boolean test(Employee employee) {
//              return   employee.getAge()>30;
//            }
//        });
//        for (Employee a:employees){
//            System.out.println(a.toString());
//        }

        List<Employee> employees = fitterEmPloyee(emps,(e) -> e.getAge()>30 );
        employees.forEach(System.out::println );
    }
    @Test
    public void test04(){
        emps.stream()
                .filter((e) -> e.getSalary()>=5000)
                .limit(2)
                .forEach(System.out::println);

        System.out.println(".............................");
        emps.stream().map(Employee :: getName)
                .forEach(System.out::println);
    }
    public List<Employee> filterEmployees(List<Employee> l) {
        List<Employee> emps =new ArrayList<>();
        for(Employee e:l){
            if (e.getAge()>=35) {
            emps.add(e);
            }
        }
        return emps;
    }
    public List<Employee> filterEmployees2(List<Employee> l) {
        List<Employee> emps =new ArrayList<>();
        for(Employee e:l){
            if (e.getSalary()>=5000) {
                emps.add(e);
            }
        }
        return emps;
    }
    public List<Employee> fitterEmPloyee(List<Employee> l,MyPredicate<Employee> mp){
        List<Employee> emps=new ArrayList<>();
        for(Employee e:l){
            if(mp.test(e)){
                emps.add(e);
            }
        }
        return  emps;
    }
}
