package ibf2022.batch3.assessment.csf.orderbackend.respositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import ibf2022.batch3.assessment.csf.orderbackend.models.PizzaOrder;

public class PendingOrdersRepository {
	@Autowired
	MongoTemplate mongoTemplate;
	// TODO: Task 3
	// WARNING: Do not change the method's signature.
	public void add(PizzaOrder order) {
		DBObject dbObject = BasicDBObject.parse(order);
		mongoTemplate.insert(dbObject, "order");
	}

	// TODO: Task 7
	// WARNING: Do not change the method's signature.
	public boolean delete(String orderId) {
		return false;
	}

}
