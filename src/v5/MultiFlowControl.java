package v5;

public class MultiFlowControl {
    private Saving saving;
    
    public MultiFlowControl() {
    }
    // Constructor injection
    public MultiFlowControl(Saving saving) {
        this.saving = saving;
    }

    //setting injection
    public void setSaving(Saving saving) {
        this.saving = saving;
    }

    public void control(double number1, double number2) {
        Multiplication multiplication = new 
        Multiplication(number1, number2);
        double result = multiplication.multiply();
        
        //khong được biết gì về IOFile
        saving.save(result);
    }

}
