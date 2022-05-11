package src;

public class BothCases2 extends BothCases1 {

    public void treatmentRegimen(){
        injectInsulin();
        followBloodPressure();
    }

    @Override
    void followBloodPressure() {
        // TODO Auto-generated method stub
        System.out.println("Theo doi duong mau 4 lan/ngay (6h - 12h - 18h - 22h");

        if(glucose <= 0){
            return;
        }else if(glucose >= 3.9 && glucose < 8.3){
            System.out.println("Dat muc tieu");
        }else if(glucose > 8.3 && glucose <= 11.1){
            System.out.println("Tiem duoi da Actrapid 2UI");
        }else{
            System.out.println("Tiem duoi da Actrapid 4UI");
        }
    }

    @Override
    public void injectInsulin() {
        // TODO Auto-generated method stub
        super.injectInsulin();
        System.out.println("Tang Lantus len 2UI");
    }
}
