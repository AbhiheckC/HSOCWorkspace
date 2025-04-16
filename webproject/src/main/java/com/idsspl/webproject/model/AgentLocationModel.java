package com.idsspl.webproject.model;

public class AgentLocationModel {

	private String agentId;

	private String latitude;

	private String longitude;

	private String agentName;

	public String getAgentId() {
		return agentId;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

}
