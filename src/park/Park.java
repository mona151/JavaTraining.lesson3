package park;

import exceptions.NegativePriceException;
import transport.Transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Park {
    private List<Transport> transport = new ArrayList<Transport>();
    private List<Transport> sortedTransport = new ArrayList<>();
    private float priceSum;
    public Park(List<Transport> transport){
        this.transport = transport;
    }

    public void getParkInfo(){
        System.out.println("Amount of cars in the park is " + transport.size());
        for (int i = 0; i < transport.size(); i++) {
            transport.get(i).getFullName();
        }
    }

    public float getParkTotalPrice(){
        for (int i = 0; i < transport.size(); i++) {
            priceSum = priceSum + transport.get(i).getPrice();
        }
        return priceSum;
    }

    public void sortParkByFuelConsumption(){
        //Collections.copy(sortedTransport, transport);
        sortedTransport.addAll(transport);

        for (int i = sortedTransport.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                    if (sortedTransport.get(j).getFuelConsumption() > sortedTransport.get(j + 1).getFuelConsumption()){
                        Collections.swap(sortedTransport, j, j + 1);
                    }
            }
        }

        for (int i = 0; i < sortedTransport.size(); i++) {
            sortedTransport.get(i).getFullName();
        }
    }

    public void getTransportByParameters (int fuelConsumptionMin, int fuelConsumptionMax, int priceMin, int priceMax)throws NegativePriceException {
        if (priceMin <= 0 || priceMax <= 0){
            throw new NegativePriceException("Price value cannot be negative or equal to 0");
        }
        for (int i = 0; i < transport.size(); i++) {
            if (transport.get(i).getFuelConsumption() >= fuelConsumptionMin && transport.get(i).getFuelConsumption() <= fuelConsumptionMax &&
                    transport.get(i).getPrice() >= priceMin && transport.get(i).getPrice() <= priceMax){
                transport.get(i).getFullName();
            }
        }
    }
}