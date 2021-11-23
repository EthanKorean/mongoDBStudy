package common.props.model;

public enum PropsPathEnum {

	DB_CONNECTION_INFO("common/props/model/connection.properties");
	
	public String path;
	
	private PropsPathEnum(String path) {
		this.path=path;
	}//PropsPathEnum
	
	public String getPath() {
		return path;
	}//getPath
	
}//class
