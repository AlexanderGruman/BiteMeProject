package logic.Users;

public class ClientUser {
	private String ipAddress, hostName, status;

	public ClientUser(String ipAddress, String hostName, String status) {
		this.ipAddress = ipAddress;
		this.hostName = hostName;
		this.status = status;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public String getHostName() {
		return hostName;
	}

	public String getStatus() {
		return status;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Client [ipAddress=" + ipAddress + ", hostName=" + hostName + ", status=" + status + "]\n";
	}
}
