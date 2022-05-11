package src;

public class BothCases1 extends DTD {

    protected double amount;

    public void treatmentRegimen(){
        injectInsulin();
        injectGlucose();
        followBloodPressure();
    }

    public void injectInsulin(){
        this.amount = 0.2 * weight;
        System.out.println("Lieu khoi dau: " + amount + "UI/ngay");
        System.out.println("Loai Insulin: Lantus");
        System.out.println("Thoi diem tiem: 22h");
    }
    
    @Override
    void followBloodPressure() {
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
    void injectGlucose() {
        // TODO Auto-generated method stub
        System.out.println("Truyen glucose 10% 500ml pha truyen 10UI Actrapid");
    }
    
}
