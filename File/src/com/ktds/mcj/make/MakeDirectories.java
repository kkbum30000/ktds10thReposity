package com.ktds.mcj.make;

import java.io.File;

public class MakeDirectories {

	public void start() {
		
//		String directoryPath = "D:\\game\\mobile\\poketmon\\go";
		String directoryPath = "/Users/minchangjang/Desktop/makeFile/game/mobile/poketmon/go";
		
		// 폴더 만들기
		File game = new File(directoryPath);
		
		// 폴더를 생성한다.
		if ( !game.exists() ) {
			game.mkdirs();
		}
		
	}
	
	public static void main(String[] args) {
		new MakeDirectories().start();
	}
	
}
