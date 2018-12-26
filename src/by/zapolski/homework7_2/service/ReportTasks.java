package by.zapolski.homework7_2.service;

import by.zapolski.homework7_2.model.Employee;
import by.zapolski.homework7_2.model.PaymentType;

import java.util.ArrayList;

public class ReportTasks {

    //просто отчет по всем сотрудниками
    public void printReport01 (ArrayList<Employee> list){
        ArrayList<String> listToPrint = new ArrayList<>();
        int sum=0;
        for (Employee emp: list){
            listToPrint.add(String.format("%13s |%13s |%13s |",emp.getName(),emp.getPaymentType(),emp.getSum()));
            sum += emp.getSum();
        }
        print(listToPrint,sum,"ФИО","Вид оплаты","Сумма");
    }

    //добавили налоги на разную оплату труда
    public void printReport02 (ArrayList<Employee> list){
        ArrayList<String> listToPrint = new ArrayList<>();
        int sum=0;
        for (Employee emp: list){
            int tax = 0;
            long sumWithTax = 0;
            switch (emp.getPaymentType()){
                case MADE :
                    tax = 15;
                    break;
                case RATE :
                    tax = 20;
                    break;
                case HOURLY:
                    tax = 20;
                    break;
            }
            sumWithTax = emp.getSum()-Math.round(emp.getSum()*tax/100f);
            listToPrint.add(String.format("%13s |%13d |%13d |%13d |",emp.getName(),tax,emp.getSum(),sumWithTax));
            sum += sumWithTax;
        }
        print(listToPrint,sum,"ФИО","Налог, %","Сумма","К выплате");
    }

    //добавили скидку на налог для сотрудников с детьми
    public void printReport03 (ArrayList<Employee> list){
        ArrayList<String> listToPrint = new ArrayList<>();
        int sum=0;
        for (Employee emp: list){
            int tax = 0;
            long sumWithTax = 0;
            switch (emp.getPaymentType()){
                case MADE :
                    tax = 15;
                    break;
                case RATE :
                    tax = 20;
                    break;
                case HOURLY:
                    tax = 20;
                    break;
            }
            if (emp.getCountChildren()==0) tax -= 5;
            sumWithTax = emp.getSum()-Math.round(emp.getSum()*tax/100f);
            listToPrint.add(String.format("%13s |%13d |%13d |%13d |",emp.getName(),tax,emp.getSum(),sumWithTax));
            sum += sumWithTax;
        }
        print(listToPrint,sum,"ФИО","Налог, %","Сумма","К выплате");
    }

    //добавили половинную оплату в валюте для сотруднигов с почасовой оплатой
    public void printReport04 (ArrayList<Employee> list,float course){
        ArrayList<String> listToPrint = new ArrayList<>();
        for (Employee emp: list){
            int tax = 0;
            long sumWithTax = 0;
            switch (emp.getPaymentType()){
                case MADE :
                    tax = 15;
                    break;
                case RATE :
                    tax = 20;
                    break;
                case HOURLY:
                    tax = 20;
                    break;
            }
            if (emp.getCountChildren()==0) tax += 5;
            sumWithTax = emp.getSum()-Math.round(emp.getSum()*tax/100f);

            StringBuilder sb = new StringBuilder();
            if (emp.getPaymentType()== PaymentType.HOURLY){
                sb.append((int)Math.floor(sumWithTax/2f)).append('/').append((int)Math.ceil(sumWithTax/2f/course));
            }else sb.append(sumWithTax);

            listToPrint.add(String.format("%13s |%13d |%13d |%13s |",emp.getName(),tax,emp.getSum(),sb.toString()));
        }
        print(listToPrint,0,"ФИО","Налог, %","Сумма","грн/тугрики");
    }


    private void print(ArrayList<String> list, int sum,String... head){
        ReportUtils reportUtil = new ReportUtils(head.length);
        reportUtil.printHead(head);
        reportUtil.printLine();
        for (String s: list) System.out.println(s);
        reportUtil.printLine();
        reportUtil.printFooting(sum);

    }



}
