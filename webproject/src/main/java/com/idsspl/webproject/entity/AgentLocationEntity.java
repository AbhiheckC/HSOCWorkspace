

package com.idsspl.webproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

@Entity
@Table(name = "CUSTOMER_AGENT_LOCATION", schema = "CUSTOMER")
public class AgentLocationEntity {
 
    @Id    
    @Column(name = "agent_id")
    private String agentId;

    @Column(name = "latitude")
    private String latitude;
    
    @Column(name = "longitude")
    private String longitude; 
    
    @Column(name = "agent_name")
    private String agentName;
    
	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}


    
}