package com.bit.springboard.coupling;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CarOwner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 스프링 컨테이너 가동
		//스프링 컨테이너 객체 생성
		//  bean 태그로 등록되어 있는 클래스의 객체 자동 생성(bean)객체     어떤 설정파일을 가지고 스프링 컨테이너를 구동할지
		AbstractApplicationContext factory = new GenericXmlApplicationContext("root-context.xml");
		
		//2. 의존성 검색(DL: Dependency Lookup)과 의존성 주입(DI : Dependency Injection)
		// 의존성 주입 : 의존성 검색을 통해 찾은 객체를 변수에 담아줌.
		//                     의존성 검색 id값으로 생성되어있는 bean객체 검색
		Car car = (KiaCar)factory.getBean("kCar");
		car.engineOn();
		car.speedUp();
		car.speedDown();
		car.engineOff();
		
		KiaCar kCar = (KiaCar)factory.getBean("kCar");
		System.out.println(kCar.getModel());
		
		car = (Car)factory.getBean("hCar");
		car.engineOn();
		car.speedUp();
		car.speedDown();
		car.engineOff();
		
		HyundaiCar hcar = (HyundaiCar)factory.getBean("hCar");
		hcar.volumeUp();
		hcar.volumeUp();
		hcar.volumeUp();
		hcar.volumeUp();
		hcar.volumeDown();
				
		//3. Spring Container 종료
		//스프링컨테이너가 종료되면서 factory에 생성되어 있던 bean 객체들을 자동 삭제.
		factory.close();
		
		
	}

}
