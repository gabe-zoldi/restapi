package googleapi;

import googleapi.pojo.Results;

/**
 * Created by hatorihanzo on 3/9/2016.
 */
public class GeoCode {

    private Results[] results;
    private String status;

    public Results[] getResults () {
        return results;
    }
    public void setResults (Results[] results) {
        this.results = results;
    }

    public String getStatus () {
        return status;
    }
    public void setStatus (String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GeoCode [results = " + results + ", status = " + status + "]";
    }

}