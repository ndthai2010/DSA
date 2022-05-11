package src;

public class KhongTiemInsulin extends DTD{

    public void treatmentRegimen(){
        firstStep();
        injectGlucose();
        followBloodPressure();
    }

    public void firstStep(){
        System.out.println("Tam ngung cac thuoc ha duong mau");
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
    void injectGlucose() {
        // TODO Auto-generated method stub
        System.out.println("Truyen glucose 10% 500ml pha truyen 10UI Actrapid");

    }
    
}
