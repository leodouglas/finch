package br.com.finchsolucoes.lorem;

/**
 * Created by leodouglas on 23/12/15.
 */

import static com.jayway.restassured.RestAssured.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class CustomerIT {

    @Test
    public void sucess() {
        when().delete("/api/v1/customers").then().statusCode(200);
        when().get("/api/v1/customers").then().statusCode(200);

        ArrayList result = when().get("/api/v1/customers").jsonPath().get();
        assertTrue(result.isEmpty());
    }

}
