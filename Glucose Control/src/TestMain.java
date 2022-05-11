package src;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {
    
    public static Scanner sc = new Scanner(System.in);

    public static void inputPatientStatus(ArrayList<DTD> patient){
        System.out.print("Number of Patients:");
        int n = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < n; i++){
            System.out.println("Option 0: Khong tiem Insulin");
            System.out.println("Option 1: Tiem Insulin");
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 0:
                    KhongTiemInsulin k = new KhongTiemInsulin();
                    patient.add(k);
                    break;
                case 1:
                    BothCases1 b1 = new BothCases1();
                    patient.add(b1);
                    break;
                default:
                    break;
            }
        }
    }

    public static void outputStatusPatient(ArrayList<DTD> patient) {
        for (int i = 0; i < patient.size(); i++) {
            patient.get(i).treatmentRegimen();
        }
    }

    public void countDays(ArrayList<DTD> patient) {
        int count = 0;

        for(int i = 0; i < patient.size(); i++) {
            count++;
        }

        if(count >= 4 && count <= 8){
            BothCases1 bc1 = new BothCases1();
            patient.clear();
            patient.add(bc1);
        }
    }
    public static void main(String[] args) {
        ArrayList<DTD> patient = new ArrayList<DTD>();
    }
}
