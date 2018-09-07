package jdk.dongtaidaili.spring;

/**
 * Created by longshihan on 2017/4/30.
 */
public class Client {
    public static void main(String[] args) {
        SimpleProxy simpleProxy = new SimpleProxy();
        SalaryInterface salaryInterface =
                (SalaryInterface) simpleProxy.bind(new Salary(), new ControlAdvice());
        salaryInterface.doSalary();
    }
}
