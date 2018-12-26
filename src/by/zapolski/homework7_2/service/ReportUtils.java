package by.zapolski.homework7_2.service;

public class ReportUtils {

    private int numColumns;

    public ReportUtils(int numColumns) {
        this.numColumns = numColumns;
    }

    void printHead(String... args){
        for (String s: args){
            System.out.printf("%13s |",s);
        }
        System.out.println();
    }

    void printFooting (int sum){
        if (sum!=0){
            System.out.printf("%13s","ИТОГО");
            for (int i = 0; i < numColumns-2; i++) {
                System.out.print("               ");
            }
            System.out.printf("%15d",sum);
            System.out.println();
            System.out.println();
        }
    }

    void printLine(){
        for (int i = 0; i < numColumns; i++) {
            System.out.print("---------------");
        }
        System.out.println();
    }
}
