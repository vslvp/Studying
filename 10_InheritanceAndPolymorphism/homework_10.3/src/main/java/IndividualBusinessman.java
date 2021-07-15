public class IndividualBusinessman extends PhysicalPerson {

    public double getAmount(){
        return super.getAmount();
    }
    public void take(double amountToTake){
        super.take(amountToTake);
    }
    public void put(double amountToPut){
        if (amountToPut >= 1000){
            super.put(amountToPut * 0.995);
        }
        else {
            super.put(amountToPut * 0.99);
        }
    }
}
