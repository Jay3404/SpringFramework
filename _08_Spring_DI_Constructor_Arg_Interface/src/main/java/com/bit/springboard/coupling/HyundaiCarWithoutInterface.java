package com.bit.springboard.coupling;

import org.springframework.stereotype.Component;

@Component
public class HyundaiCarWithoutInterface implements Car{
	//의존 관계 생성
	//HyundaiCar가 CarAudio에 의존함
	//CarAudio의 내용이 변경되면 HyundaiCar의 결과가 바뀌기 때문에 의존관계가 형성된다.
	CarAudio carAudio;
	
	String model;
	public HyundaiCarWithoutInterface() {
		System.out.println("HyundaiCar 기본 생성자 호출");
	}
	
	public HyundaiCarWithoutInterface(CarAudio carAudio) {
		System.out.println("HyundaiCar CarAudio 파라미터 생성자 호출");
		this.carAudio = carAudio;
	}
	
	public HyundaiCarWithoutInterface(CarAudio carAudio, String model) {
		System.out.println("HyundaiCar CarAudio, Model 파라미터 생성자 호출");
		this.carAudio = carAudio;
		this.model = model;
	}

	//bean init-method에서 사용할 메소드 선언
	public void initMethod() {
		this.model = "아반떼";
		System.out.println("HyundaiCar 객체 생성");
	}
	
	public void destroyMethod() {
		this.model = "";
		System.out.println("HyundiaCar 객체 삭제 전 동작");
	}
	
	@Override
	public void engineOn() {
		System.out.println("HyundaiCar 시동을 건다.");
	}
	@Override
	public void engineOff() {
		System.out.println("HyundaiCar 시동을 끈다.");
	}
	@Override
	public void speedUp() {
		System.out.println("HyundaiCar 속도를 올린다.");
	}

	@Override
	public void speedDown() {
		System.out.println("HyundaiCar 속도를 낮춘다.");
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	//이 방식은 메소드가 호출될 때마다 CarAudio 객체가 생성되므로 CarAudio 객체도 스프링 컨테이너에 생성하고 공유해서 쓸 수 있도록 하는 방식으로 변경이 이뤄져야한다.
	public void volumeUp() {
		//의존성주입
//		carAudio = new CarAudio();
		//bean 객체의 메소드 사용
		this.carAudio.volumeUp();
	}
	
	public void volumeDown() {
		//의존성주입
//		carAudio = new CarAudio();
		//bean 객체의 메소드 사용
		this.carAudio.volumeDown();
	}
	

}
