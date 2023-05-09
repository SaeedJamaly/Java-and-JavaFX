package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Soen6441 Team
 */

public class Apartment extends Property{

    private int unitNo;


    public int getUnitNo(){
        return unitNo;
    }
    public void setUnitNo(int unitNo){
        this.unitNo = unitNo;
    }
    /**
     * Constructor of the concrete creator
     */
    public Apartment(){
        super(PropertyType.APARTMENT);
    }
    /**
     * construct method of the concrete creator
     */

    @Override
    public void build(ArrayList<String> list){

        this.setType(PropertyType.valueOf(list.get(0).toUpperCase()));
        this.setID(Integer.parseInt(list.get(1)));
        this.setAddress(list.get(2));
        this.setCity(list.get(3));
        this.setZip(list.get(4));
        this.setNoOfBedrooms(Integer.parseInt(list.get(5)));
        this.setNoOfBathrooms(Integer.parseInt(list.get(6)));
        this.setStatus(1);
        this.setUnitNo(Integer.parseInt(list.get(7)));
    }
}
