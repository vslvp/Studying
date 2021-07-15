public class LegalPerson extends PhysicalPerson {

    public double getAmount(){
        return super.getAmount();
    }
    public void take(double amountToTake){
        super.take(amountToTake * 1.01);
    }
    public void put(double amountToPut){
        super.put(amountToPut);
    }
}
