package com.bit.springboard.coupling;

public class AppleCarAudio implements CarAudio{

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("AppleCarAudio 볼륨 업");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("AppleCarAudio 볼륩 다운");
	}

}
