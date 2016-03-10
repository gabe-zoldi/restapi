package googleapi.pojo;

/**
 * Created by hatorihanzo on 3/9/2016.
 */
public class Viewport {

    private Southwest southwest;
    private Northeast northeast;

    public Southwest getSouthwest () {
        return southwest;
    }
    public void setSouthwest (Southwest southwest) {
        this.southwest = southwest;
    }

    public Northeast getNortheast () {
        return northeast;
    }
    public void setNortheast (Northeast northeast) {
        this.northeast = northeast;
    }

    @Override
    public String toString() {
        return "Viewport [southwest = " + southwest +
                ", northeast = " + northeast + "]";
    }
}
