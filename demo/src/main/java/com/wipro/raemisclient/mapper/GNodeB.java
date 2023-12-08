package com.wipro.raemisclient.mapper;

public class GNodeB {

	private long gnbId;

	private String gnbName;

	private int plmnId;

	private String ipAddress;

	private String status;

	private String nodeId;

	public long getGnbId() {
		return gnbId;
	}

	public void setGnbId(long gnbId) {
		this.gnbId = gnbId;
	}

	public String getGnbName() {
		return gnbName;
	}

	public void setGnbName(String gnbName) {
		this.gnbName = gnbName;
	}

	public int getPlmnId() {
		return plmnId;
	}

	public void setPlmnId(int plmnId) {
		this.plmnId = plmnId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public GNodeB(long gnbId, String gnbName, int plmnId, String ipAddress, String status, String nodeId) {
		super();
		this.gnbId = gnbId;
		this.gnbName = gnbName;
		this.plmnId = plmnId;
		this.ipAddress = ipAddress;
		this.status = status;
		this.nodeId = nodeId;
	}

	@Override
	public String toString() {
		return "GNodeB [gnbId=" + gnbId + ", gnbName=" + gnbName + ", plmnId=" + plmnId + ", ipAddress=" + ipAddress
				+ ", status=" + status + ", nodeId=" + nodeId + "]";
	}

}
