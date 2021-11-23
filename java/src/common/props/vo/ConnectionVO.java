package common.props.vo;

public class ConnectionVO {
	private String url;
	private int port;
	private String dbName;
	
	public ConnectionVO(String url, int port, String dbName) {
		super();
		this.url = url;
		this.port = port;
		this.dbName = dbName;
	}

	public String getUrl() {
		return url;
	}

	public int getPort() {
		return port;
	}

	public String getDbName() {
		return dbName;
	}
	
}// class