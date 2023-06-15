package com.bit.springboard.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.bit.springboard.dto.BoardDTO;

public class BoardServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 스프링 컨테이너 구동
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("root-context.xml");
		
		//2. BoardService 변수의 의존성 검색과 의존성 주입
		BoardService boardService = (BoardService)factory.getBean("boardService");
		
		//3. 글 등록 테스트
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setBoardTitle("test 제목");
//		boardDTO.setBoardContent("test 내용입니다.");
//		boardDTO.setBoardWriter("관리자");
//		
//		boardService.insertBoard(boardDTO);
		
		//4. 글 상세 조회 테스트
//		BoardDTO returnBoard = boardService.getBoard(1);
//		
//		System.out.println(returnBoard);
		
		//5. 글 수정 테스트
//		BoardDTO updateBoard = new BoardDTO();
//		updateBoard.setBoardTitle("test 제목 수정");
//		updateBoard.setBoardContent("test수정 내용입니다.");
//		updateBoard.setBoardWriter("관리자2");
//		updateBoard.setBoardNo(1);
//		
//		boardService.updateBoard(updateBoard);
		
		//6. 글 삭제 테스트
//		boardService.deleteBoard(1);
		
		//7. 전체 글 불러오기
		List<BoardDTO> list = boardService.getBoardList();
		for(BoardDTO a : list) {
			System.out.println(a);
		}
		
		//5. 스프링 컨테이너 종료
		factory.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
