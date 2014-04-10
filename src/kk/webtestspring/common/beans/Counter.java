package kk.webtestspring.common.beans;

import kk.webtestspring.entity.beans.BaseEntity;

import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document(collection="Counter")
public class Counter extends BaseEntity {

	private String name;
	
	private Long sequence;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}
}
