package demo;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class SpecBuilder {

	public static void main(String[] args) {
		
		AddPlace p = new AddPlace();
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		p.setAccuracy(50);
		p.setName("Amol Achari");
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress("samvatsar");
		List<String> type = new ArrayList <String>();
		type.add("shoe park");
		type.add("shop");
		p.setTypes(type); 
		p.setWebsite("http://google.com");
		p.setLanguage("French-IN");
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key", " qaclick123"). 
		addHeader("Content-Type","application/json").build();
		
		ResponseSpecification	resp =new ResponseSpecBuilder().expectStatusCode(200)
		.expectContentType(ContentType.JSON).build();
		
		RequestSpecification request = given().log().all().spec(req).body(p);
		Response response = request.when().post("maps/api/place/add/json").
		then().spec(resp).extract().response();//
		
		String responsestring = response.asString();
		 
		System.out.println(responsestring);
		  
		
		
		
	}
}
