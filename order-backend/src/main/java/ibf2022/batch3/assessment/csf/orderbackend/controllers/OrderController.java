package ibf2022.batch3.assessment.csf.orderbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

@RestController
//@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")
public class OrderController {

	// TODO: Task 3 - POST /api/order
	@GetMapping(path = "/api/order")
	public ResponseEntity<String> placeOrder(String query) {
		JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
		objectBuilder.add("order", query);
		JsonObject result = objectBuilder.build();
		return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString()); 

	}



	// TODO: Task 6 - GET /api/orders/<email>
	//@RequestMapping(path = "/orders/<email>")


	// TODO: Task 7 - DELETE /api/order/<orderId>
	//@RequestMapping(path = "/order/<orderId>")

}
