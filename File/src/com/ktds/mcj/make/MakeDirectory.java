package com.ktds.mcj.make;

import java.io.File;

public class MakeDirectory {

	public void start() {
		
//		String directoryPath = "D:\\game";
		String directoryPath = "/Users/minchangjang/Desktop/makeFile/game";
		
		// 폴더 만들기
		File game = new File(directoryPath);
		
		// 폴더를 생성한다.
		if ( !game.exists() ) {
			game.mkdir();
		}
		
	}
	
	public static void main(String[] args) {
		new MakeDirectory().start();
	}
	
}
