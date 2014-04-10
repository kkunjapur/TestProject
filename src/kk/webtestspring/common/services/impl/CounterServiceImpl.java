package kk.webtestspring.common.services.impl;

import kk.webtestspring.common.beans.Counter;
import kk.webtestspring.common.services.ICounterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class CounterServiceImpl implements ICounterService {

	@Autowired
	private MongoTemplate theMongoTemplate;
	
	public CounterServiceImpl(){
		
	}

	@Override
	public long getNextIdSequence(String collectionName) {
		return increaseCounter(collectionName);
	}

	private long increaseCounter(String counterName) {
		Query query = new Query(Criteria.where("name").is(counterName));
		Update update = new Update().inc("sequence", 1);
		Counter counter = theMongoTemplate.findAndModify(query, update,
				Counter.class); // return old Counter object
		return counter.getSequence();
	}

}
