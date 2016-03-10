package googleapi.pojo;

/**
 * Created by hatorihanzo on 3/9/2016.
 */
public class Southwest {

    private String lng;
    private String lat;

    public String getLng () {
        return lng;
    }
    public void setLng (String lng) {
        this.lng = lng;
    }

    public String getLat () {
        return lat;
    }
    public void setLat (String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Southwest [lng = " + lng +
                ", lat = " + lat + "]";
    }
}