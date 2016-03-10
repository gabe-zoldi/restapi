package googleapi.pojo;

/**
 * Created by hatorihanzo on 3/9/2016.
 */
public class Location {

    private String lng;
    private String lat;

    public String getLongitude () {
        return lng;
    }
    public void setLongitude (String lng) {
        this.lng = lng;
    }

    public String getLatitude () {
        return lat;
    }
    public void setLatitude (String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Location [longitude = " + lng +
                ", latitude = " + lat + "]";
    }

}