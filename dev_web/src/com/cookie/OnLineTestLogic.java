package com.cookie;

import org.apache.log4j.Logger;

import com.vo.ExamineeVO;
import com.vo.RightAnswerVO;
import com.vo.TakeVO;
public class OnLineTestLogic {
	Logger logger = Logger.getLogger(OnLineTestLogic.class);
/*****************************************************************************************
 * 시험 응시 처리 및 채점하기 구현
 * @param 수험생 번호
 * @return 판정결과 및 점수
 ****************************************************************************************/
	public ExamineeVO marking(ExamineeVO peVO, TakeVO ptVO){
		ExamineeVO reVO = null;
		OnLineTestDao testDao = new OnLineTestDao();
		//답안지 처리 결과를 담을 변수 선언
		int tiResult =0;
		//시험 판정 정보 수정 결과를 담을 변수 선언
		//1이면 채점 정상 완료
		//0이면 채점 실패
		int euResult =0;
		//insert작성
		tiResult=testDao.takeInsert(ptVO); //답안지 INSERT처리
		//select문 작성(문제 코드에 대한 조건 검색)
		logger.info(ptVO.getExam_cd());
		RightAnswerVO rraVO=testDao.getRightAnswer(ptVO.getExam_cd()); //정답 정보 SELECT처리
		//select문 작성(문제 코드와 수험생 번호 조건검색)
		/************************도전과제************************************
		 * 채점하는 로직을 자바 코드가 아닌 SQL문으로 할 수 있지 않을까?
		 *********************************************************************/
		/*
		 * select exam_cd, test_no,take1,take2,take3,take4,take5
		 * from take
		 * where eaxm_cd ='t_20170111
		 * and test_no='2017010001
		 */
		//작성한 답안지에 대해 정상적으로 insert가 되면 답안지 테이블 가져올 필요 없이
		//파라미터로 넘어온 ptVO를 사용
		//채점하기 구현
		int daps[] = new int[5];
		int takes[] = new int[5];
		if(rraVO != null){ //정답을 담을 배열에 대한 초기화
			daps[0]=rraVO.getAnswer1();
			daps[1]=rraVO.getAnswer2();
			daps[2]=rraVO.getAnswer3();
			daps[3]=rraVO.getAnswer4();
			daps[4]=rraVO.getAnswer5();
			logger.info("내답"+daps[0]+daps[1]+daps[2]+daps[3]+daps[4]);
		}
		if(tiResult==1){
			takes[0] =ptVO.getTake1();
			takes[1] =ptVO.getTake2();
			takes[2] =ptVO.getTake3();
			takes[3] =ptVO.getTake4();
			takes[4] =ptVO.getTake5();
			logger.info("답내놔 ㅅㅂ"+takes[0]+takes[1]+takes[2]+takes[3]+takes[4]);
		}
		TakeVO rtVO=testDao.getTake(ptVO);//답안지 정보 SELECT처리
		// 채점로직(업무프로세스)- 추가
		//판정 기준점수:60점
		//문항 점수:20점
		//개선사항: 혹시 sql문 만으로 처리 할 수 없을까?
		int cnt =0; //맞힌 갯수
		int bscore =20; //문항 점수
		int score=0; //응시생의 점수를 담는 변수
		int pscore =60;
		String decision ="불합격";
		for(int i=0;i<daps.length;i++){
			for(int j=0;j<takes.length;j++){
				if(i==j){ //배열의 인덱스가 같니? - 같은 문항입니다.
					if(daps[i]==takes[j]){ //정
						++cnt;
					}
				}
			}
		}
		//응시생 점수 계산 하기
		score = bscore*cnt;
		//합격 여부 담기
		if(score>=pscore){
			decision ="합격";
		}else{
			decision="불합격";
		}
		peVO.setDecision(decision); //합격 불합격을 담기
		peVO.setScore(score);
		peVO.setTake_yn("1");//색인 :1 이면 응시 0이면 미응시
		//update문(해당 수험생에 대해 정보수정)
		/*
		 * update examinee
		 		set decision ='합격' -- or '불합격'
		  		,score =80
		  		,take_yn=1
		 		where test_no ='2017010001'
		 */
		euResult=testDao.examineeUpdate(peVO);//시험 응시 판정 정보 수정 UPDATE처리
		//수험생 시험응시 처리 정보 SELECT처리
		//시험 응시 결과 정보를 조회하기
		//아래 메소드는 인증처리 하는 check SQL문을 재사용 해보자
		reVO=testDao.testLogin(peVO);
		logger.info("수험 번호:"+reVO.getTest_no());
		logger.info("성명:"+reVO.getT_name());
		logger.info("판정결과:"+reVO.getDecision());
		logger.info("점수:"+reVO.getScore());
		logger.info("응시여부:"+reVO.getTake_yn());
		return reVO;
	}

	public ExamineeVO testLogin(ExamineeVO peVO) {
		logger.info("testLogin 호출 성공");
		ExamineeVO reVO = null;
		OnLineTestDao testDao = new OnLineTestDao();
		reVO=testDao.testLogin(peVO);
		return reVO;
	}
}

