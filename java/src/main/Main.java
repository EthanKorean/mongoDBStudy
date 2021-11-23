package main;

import common.dao.Connection;

/**
 *  프로젝트 시작하는 클래스<br/>
 * 1. 각자 개인이름으로 package분리할것<br/>
 * 2. 해당 class는 clone이후 ignore에 추가해주세요<br/>
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Start");
		Connection con = Connection.getInstance();
	}//main
	
}//class 
