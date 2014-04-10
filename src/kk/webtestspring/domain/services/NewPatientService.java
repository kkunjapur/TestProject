package kk.webtestspring.domain.services;

import kk.webtestspring.common.services.impl.CounterServiceImpl;
import kk.webtestspring.domain.beans.Address;
import kk.webtestspring.domain.beans.Contact;
import kk.webtestspring.domain.beans.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class NewPatientService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CounterServiceImpl counterService;
	
	private static final String COLLECTION_PATIENT = "patient";
	private static final String COLLECTION_ADDRESS = "address";
	private static final String COLLECTION_CONTACT = "contact";
	
	public NewPatientService(){
		
	}
	
	public void addPatient(Patient patient){
		
		Contact contact = patient.getContact();
		contact.setId("contact" + counterService.getNextIdSequence(COLLECTION_CONTACT));
		
		Address address = contact.getAddress();
		address.setId("address" + counterService.getNextIdSequence(COLLECTION_ADDRESS));
		
		if (!mongoTemplate.collectionExists(Address.class)) {
            mongoTemplate.createCollection(Address.class);
        }
		mongoTemplate.insert(address, COLLECTION_ADDRESS);
		
		if (!mongoTemplate.collectionExists(Contact.class)) {
            mongoTemplate.createCollection(Contact.class);
        }
		contact.setAddress(address);
		mongoTemplate.insert(contact, COLLECTION_CONTACT);
		
		if (!mongoTemplate.collectionExists(Patient.class)) {
            mongoTemplate.createCollection(Patient.class);
        }      
		patient.setContact(contact);
        patient.setId("patient" + counterService.getNextIdSequence(COLLECTION_PATIENT));
        mongoTemplate.insert(patient, COLLECTION_PATIENT);
	}
	
}
