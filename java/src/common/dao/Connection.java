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

	private static Connection con;
	
	public static Connection getInstance() {
		if(con==null) {
			con = new Connection();
		}//end if
		return con;
	}//getInstance
	private MongoClient mongoClient;
	private MongoDatabase mongoDatabase;
	private void connect() {
		
		try {
			ConnectionVO cvo = PropertiesUtil.getInstance().getConnectionVO();
			mongoClient = new MongoClient(cvo.getUrl(),cvo.getPort());
			mongoDatabase = mongoClient.getDatabase(cvo.getDbName());
		}catch(IOException|NullPointerException|NumberFormatException err) {
			System.err.println("wrong setting");
			err.printStackTrace();
		}//end catch
	}//Connection
	

	
}//class