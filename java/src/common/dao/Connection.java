package common.dao;

import java.io.IOException;

import javax.swing.text.Document;
import javax.swing.text.StyledDocument;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import common.props.PropertiesUtil;
import common.props.vo.ConnectionVO;

public class Connection {

	public static Connection getInstance() {
		return ConnectionInstance.instance;
	}//getInstance
	
	private static class ConnectionInstance{
		private static final Connection instance = new Connection();
	}//class
	
	private MongoClient mongoClient;
	private MongoDatabase mongoDatabase;
	
	public MongoDatabase connect() {
		
		try {
			ConnectionVO cvo = PropertiesUtil.getInstance().getConnectionVO();
			mongoClient = new MongoClient(cvo.getUrl(),cvo.getPort());
			mongoDatabase = mongoClient.getDatabase(cvo.getDbName());
		}catch(IOException|NullPointerException|NumberFormatException err) {
			System.err.println("wrong setting");
			err.printStackTrace();
		}//end catch
		return mongoDatabase;
	}//Connection
	
	public void close() {
		if(mongoClient!=null) {
			mongoClient.close();
		}//end if
	}//end close
	
}//class