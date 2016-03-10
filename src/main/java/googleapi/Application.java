package googleapi;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import googleapi.pojo.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Override
    public void run(String... args) throws Exception {
        Location location = getGeoCode("1600 Amphitheatre Parkway, Mountain View, CA").
                getResults()[0].getGeometry().getLocation();

        log.info("latitude==> " + location.getLatitude());
        log.info("longitude==> " + location.getLongitude());
    }

    private GeoCode getGeoCode(String address) {
        final String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, GeoCode.class);
    }

    @Test
    public void testLatLong() {
        String response =
                given().
                        baseUri("https://maps.googleapis.com/maps/api").
                        param("address", "1600 Amphitheatre Parkway, Mountain View, CA").
                when().
                        get("/geocode/json").asString();

        String[] location = new JsonPath(response).get("results.geometry.location").
                toString().replaceAll("[\\[\\]{}]","").trim().split(", ");
        float latitude  = 0.0f;
        float longitude = 0.0f;

        for (String element : location) {
            if (element.contains("lat"))
                latitude = Float.valueOf(element.split("=")[1]);
            if (element.contains("lng"))
                longitude = Float.valueOf(element.split("=")[1]);
        }

        assertThat(latitude, equalTo(37.42245f));
        assertThat(longitude, equalTo(-122.08408f));
    }


    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

}