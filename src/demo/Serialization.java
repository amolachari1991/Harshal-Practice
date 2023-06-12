package demo;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import pojo.AddPlace;
import pojo.Location;

public class Serialization {

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
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String res = 	given().log().all().queryParam("key"," qaclick123").header("Content-Type", "application/json").body(p).
		when().post("maps/api/place/add/json").
		then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(res);
		
		
		
		
	}
}
