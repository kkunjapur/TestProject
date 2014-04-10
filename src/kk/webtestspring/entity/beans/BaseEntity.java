package kk.webtestspring.entity.beans;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@SuppressWarnings("serial")
public class BaseEntity implements Serializable{
	
	@Id
	private String Id;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

}
