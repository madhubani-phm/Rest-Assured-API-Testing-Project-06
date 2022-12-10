import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.http.Headers.headers;

public class API {

    String baseUrl="http://restapi.adequateshop.com/api/";
    private Object Bearer;

    //Verify register user details
    @Test
    public void verifyValidInputsForUserRegistrationPostApi() {

        JSONObject reqBody=new JSONObject();

        Random random = new Random();
        String name= String.valueOf(random.nextInt(10000));

        reqBody.put("email", name+"@gmail.com");
        reqBody.put("name","Qa");
        reqBody.put("password","9992929");

        Response resp= RestAssured.given().
                contentType("application/json").
                body(reqBody).
                expect().
                statusCode(200).
                log().ifValidationFails().
                when().
                post("http://restapi.adequateshop.com/api/authaccount/registration");
        System.out.println(resp.asString());

        Assert.assertNotNull(resp.jsonPath().getString("data.Name"));
        Assert.assertNotNull(resp.jsonPath().getString("data.Token"));
        Assert.assertNotNull(resp.jsonPath().getString("data.Id"));
        Assert.assertEquals(resp.jsonPath().getString("code"), "0");
    }

@Test

public void verifyValidInputsForUserLoginPostApi(){
    JSONObject req1Body=new JSONObject();
    //Random random = new Random();
    //String name= String.valueOf(random.nextInt(10000));

    req1Body.put("email","530@gmail.com");
    req1Body.put("password","9992929");

    Response resp1= RestAssured.given().
            header("contentType","application/json").
            contentType(ContentType.JSON).
            body(req1Body).
            expect().
            statusCode(200).
            log().
            ifValidationFails().
            when().
            post("http://restapi.adequateshop.com/api/authaccount/login");
    System.out.println(resp1.asString());
    Assert.assertNotNull(resp1.jsonPath().getString("data.Name"));
    Assert.assertNotNull(resp1.jsonPath().getString("data.Token"));
    Assert.assertNotNull(resp1.jsonPath().getString("data.Id"));
    Assert.assertEquals(resp1.jsonPath().getString("code"), "0");

}

@Test
    public void verifyValidInputsForCreateUserPostApi() {

        JSONObject reqBody2=new JSONObject();
        Random random = new Random();
        String name= String.valueOf(random.nextInt(10000));

        reqBody2.put("email", name+"@gmail.com");
        reqBody2.put("name","Janhoda");
        reqBody2.put("location","USA");

String token = "f58db6fa-7de0-4e41-93d4-f429bc3909f1";

        Response resp2= RestAssured.given().auth().oauth2(token).
                headers("Authorization",token).
                contentType("application/json").
                body(reqBody2).
                expect().
                statusCode(201).
                log().
                ifValidationFails().
                when().
                post(" http://restapi.adequateshop.com/api/users");
        System.out.println(resp2.asString());

        Assert.assertNotNull(resp2.jsonPath().getString("name"));
        Assert.assertNotNull(resp2.jsonPath().getString("id"));
        Assert.assertNotNull(resp2.jsonPath().getString("email"));
        Assert.assertNotNull(resp2.jsonPath().getString("location"));
        Assert.assertNotNull(resp2.jsonPath().getString("profilepicture"));
        Assert.assertNotNull(resp2.jsonPath().getString("createdat"));

//"id":189003,

    }

    @Test
    public void verifyValidInputsForGetUserGetApi(){

        JSONObject reqBody2=new JSONObject();
        //Random random = new Random();
        //String name= String.valueOf(random.nextInt(10000));

        //reqBody2.put("email", name+"@gmail.com");
        //reqBody2.put("name","Janhoda");
        //reqBody2.put("location","USA");

        String token = "f58db6fa-7de0-4e41-93d4-f429bc3909f1";

        Response resp2= RestAssured.given().auth().oauth2(token).
                headers("Authorization",token).
                contentType("application/json").
                body(reqBody2).
                expect().
                statusCode(200).
                log().
                ifValidationFails().
                when().
                get(" http://restapi.adequateshop.com/api/users/189003");
        System.out.println(resp2.asString());

        Assert.assertNotNull(resp2.jsonPath().getString("name"));
        Assert.assertNotNull(resp2.jsonPath().getString("id"));
        Assert.assertNotNull(resp2.jsonPath().getString("email"));
        Assert.assertNotNull(resp2.jsonPath().getString("location"));
        Assert.assertNotNull(resp2.jsonPath().getString("profilepicture"));
        Assert.assertNotNull(resp2.jsonPath().getString("createdat"));

    }

    @Test

    public void verifyValidInputsForUpdateUserPutApi(){
        JSONObject reqBody2=new JSONObject();
        Random random = new Random();
        String name= String.valueOf(random.nextInt(10000));

        reqBody2.put("email", name+"@gmail.com");
        reqBody2.put("name","Janhoda");
        reqBody2.put("location","USA");

        String token = "f58db6fa-7de0-4e41-93d4-f429bc3909f1";

        Response resp2= RestAssured.given().auth().oauth2(token).
                headers("Authorization",token).
                contentType("application/json").
                body(reqBody2).
                expect().
                statusCode(201).
                log().
                ifValidationFails().
                when().
                post(" http://restapi.adequateshop.com/api/users");
        System.out.println(resp2.asString());
        String id=resp2.jsonPath().getString("id");
    JSONObject reqBody4=new JSONObject();
        reqBody4.put("id",id);
        reqBody4.put("email","530@gmail.com");
        reqBody4.put("name","Maduwantha");
        reqBody4.put("location","CAN");
    Response resp4= RestAssured.given().auth().oauth2(token).
            headers("Authorization",token).
            contentType("application/json").
            body(reqBody4).
            expect().
            statusCode(201).
            log().
            ifValidationFails().
            when().
            put("http://restapi.adequateshop.com/api/users/id");
        System.out.println(resp4.asString());

        Assert.assertNotNull(resp4.jsonPath().getString("name"));
        Assert.assertNotNull(resp4.jsonPath().getString("id"));
        Assert.assertNotNull(resp4.jsonPath().getString("email"));
        Assert.assertNotNull(resp4.jsonPath().getString("location"));
        Assert.assertNotNull(resp4.jsonPath().getString("profilepicture"));
        Assert.assertNotNull(resp4.jsonPath().getString("createdat"));

}

@Test

public void verifyValidInputsForDeleteUserDeleteApi(){
    JSONObject reqBody4=new JSONObject();
    reqBody4.put("id","189028");
    reqBody4.put("email","530@gmail.com");
    reqBody4.put("name","Maduwantha");
    reqBody4.put("location","CAN");
    String token = "f58db6fa-7de0-4e41-93d4-f429bc3909f1";

    Response resp4= RestAssured.given().auth().oauth2(token).
            headers("Authorization",token).
            contentType("application/json").
            body(reqBody4).
            expect().
            statusCode(201).
            log().
            ifValidationFails().
            when().
            delete(" http://restapi.adequateshop.com/api/users/189028");
    System.out.println(resp4.asString());

    Assert.assertNotNull(resp4.jsonPath().getString("name"));
    Assert.assertNotNull(resp4.jsonPath().getString("id"));
    Assert.assertNotNull(resp4.jsonPath().getString("email"));
    Assert.assertNotNull(resp4.jsonPath().getString("location"));
    Assert.assertNotNull(resp4.jsonPath().getString("profilepicture"));
    Assert.assertNotNull(resp4.jsonPath().getString("createdat"));


}




}
