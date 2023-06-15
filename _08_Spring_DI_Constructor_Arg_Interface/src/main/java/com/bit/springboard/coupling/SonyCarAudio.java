package com.bit.springboard.coupling;

public class SonyCarAudio implements CarAudio{

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("SonyCarAudio 볼륨 업");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("SonyCarAudio 볼륩 다운");
	}
}
