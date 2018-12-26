package by.zapolski.homework7_2;

import by.zapolski.homework7_2.model.Employee;
import by.zapolski.homework7_2.model.PaymentType;
import by.zapolski.homework7_2.service.ReportTasks;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>(70);
        PaymentType[] types = PaymentType.values();
        for (int i = 0; i < 6; i++) {
            Employee employee = new Employee("Worker "+i, types[rnd(0,2)],
                    rnd(1000,5000),rnd(0,3),(rnd(0, 1)!=0),rnd(0,300));

            if ((employee.getHours()>200)&&(employee.getPaymentType()==PaymentType.HOURLY)){
                employee.setPremium(500);
            }
            list.add(employee);
        }

        ReportTasks reportTasks = new ReportTasks();
        reportTasks.printReport01(list);
        reportTasks.printReport02(list);
        reportTasks.printReport03(list);
        reportTasks.printReport04(list,8f);
        System.out.println();
        reportTasks.printReport05_06(list,8f);
        System.out.println();
    }

    private static int rnd(int min, int max){
        return (int)(Math.random()*((max-min)+1))+min;
    }

}
