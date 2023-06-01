package Activities;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
    public  Plane(int maxPassengers ) {
        this.maxPassengers = maxPassengers ;
        this.passengers = new ArrayList<> ();
    }

     public void onboard(String passenger) {
            this.passengers.add(passenger);
        }

        public Date takeOff() {
            this.lastTimeTookOf = new Date();
            return lastTimeTookOf;
        }

        public void land() {
            this.lastTimeLanded = new Date();
        }

        public Date getLastTimeLanded() {
            return lastTimeLanded;
        }

        public List<String> getPassengers() {
            return passengers;
        }
    }




