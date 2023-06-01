package ibf2022.batch3.assessment.csf.orderbackend.respositories;

import java.util.List;

import ibf2022.batch3.assessment.csf.orderbackend.models.PizzaOrder;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import com.mongodb.client.result.UpdateResult;

@Repository
//@CrossOrigin(origins = "localhost:4200")
public class OrdersRepository {
	@Autowired
	MongoTemplate mongoTemplate;

	// @EnableWebMvc
    // public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //     @Override
    //     protected void configure(HttpSecurity http) throws Exception {
    //         http.cors().disable()...
    //     }
    // }

	// TODO: Task 3
	// WARNING: Do not change the method's signature.
	// Write the native MongoDB query in the comment below
	//   Native MongoDB query here for add()
	public void add(String order) {
		DBObject dbObject = BasicDBObject.parse(order);
		mongoTemplate.insert(dbObject, "order");
	}
	
	// TODO: Task 6
	// WARNING: Do not change the method's signature.
	// Write the native MongoDB query in the comment below
	//   Native MongoDB query here for getPendingOrdersByEmail()
	public List<PizzaOrder> getPendingOrdersByEmail(String email) {

		return null;
	}

	// TODO: Task 7
	// WARNING: Do not change the method's signature.
	// Write the native MongoDB query in the comment below
	//   Native MongoDB query here for markOrderDelivered()
	public boolean markOrderDelivered(String orderId) {

		return false;
	}


}
