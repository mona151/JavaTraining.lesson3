package transport;

import exceptions.ZeroFCException;

public class Auto extends Transport {


    public Auto (float fuelConsumption, String model, int price, String manufacturer) throws ZeroFCException {
        super(model, manufacturer, fuelConsumption);
        setPrice(price);

        if (fuelConsumption == 0){
            throw new ZeroFCException("Fuel consumption cannot be 0");
        }
        if (fuelConsumption < 0){
            throw new ZeroFCException("Fuel consumption cannot be negative");
        }
    }

    public void getFullName(){
        System.out.println(getManufacturer() + " " + getModel() + ", price: " + getPrice() + ", fuel consumption: " + getFuelConsumption());
    }
}