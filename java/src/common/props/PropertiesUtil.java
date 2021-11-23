package common.props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import common.props.model.PropsPathEnum;
import common.props.vo.ConnectionVO;

public class PropertiesUtil {
	private static PropertiesUtil pUtil;
	public static PropertiesUtil getInstance() {
		if(pUtil==null) {
			pUtil = new PropertiesUtil();
		}//end if
		return pUtil;
	}//getInstance
	private PropertiesUtil() {}//PropertiesUtil
	
	
	
	public ConnectionVO getConnectionVO() throws IOException, NumberFormatException,NullPointerException {
		ConnectionVO cvo=null;
		//final String path = "common.props.model.connection.properties";
		String path = PropsPathEnum.DB_CONNECTION_INFO.getPath();
		Properties properties = getProperties(path);
		String url = properties.getProperty("url");
		int port = Integer.parseInt(properties.getProperty("port"));
		String dbName = properties.getProperty("dbName");
		cvo = new ConnectionVO(url, port, dbName);
		return cvo;
	}//getConnectionVO
	
	public Properties getProperties(String path) throws IOException{
		Properties properties = null;
		InputStream inStream = null;
		try {
			properties= new Properties();
			inStream = getClass().getClassLoader().getResourceAsStream(path);
			
			if(inStream==null) {
				throw new NullPointerException();
			}//end if
			properties.load(inStream);
			
		} finally {
			if(inStream!=null) {
				inStream.close();
			}//end if
		}//end finally
		return properties;
	}//getProperties
	
}//class
