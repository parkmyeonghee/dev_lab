package com.cookie;

import org.apache.log4j.Logger;

import com.vo.ExamineeVO;
import com.vo.RightAnswerVO;
import com.vo.TakeVO;
public class OnLineTestLogic {
	Logger logger = Logger.getLogger(OnLineTestLogic.class);
/*****************************************************************************************
 * ���� ���� ó�� �� ä���ϱ� ����
 * @param ����� ��ȣ
 * @return ������� �� ����
 ****************************************************************************************/
	public ExamineeVO marking(ExamineeVO peVO, TakeVO ptVO){
		ExamineeVO reVO = null;
		OnLineTestDao testDao = new OnLineTestDao();
		//����� ó�� ����� ���� ���� ����
		int tiResult =0;
		//���� ���� ���� ���� ����� ���� ���� ����
		//1�̸� ä�� ���� �Ϸ�
		//0�̸� ä�� ����
		int euResult =0;
		//insert�ۼ�
		tiResult=testDao.takeInsert(ptVO); //����� INSERTó��
		//select�� �ۼ�(���� �ڵ忡 ���� ���� �˻�)
		logger.info(ptVO.getExam_cd());
		RightAnswerVO rraVO=testDao.getRightAnswer(ptVO.getExam_cd()); //���� ���� SELECTó��
		//select�� �ۼ�(���� �ڵ�� ����� ��ȣ ���ǰ˻�)
		/************************��������************************************
		 * ä���ϴ� ������ �ڹ� �ڵ尡 �ƴ� SQL������ �� �� ���� ������?
		 *********************************************************************/
		/*
		 * select exam_cd, test_no,take1,take2,take3,take4,take5
		 * from take
		 * where eaxm_cd ='t_20170111
		 * and test_no='2017010001
		 */
		//�ۼ��� ������� ���� ���������� insert�� �Ǹ� ����� ���̺� ������ �ʿ� ����
		//�Ķ���ͷ� �Ѿ�� ptVO�� ���
		//ä���ϱ� ����
		int daps[] = new int[5];
		int takes[] = new int[5];
		if(rraVO != null){ //������ ���� �迭�� ���� �ʱ�ȭ
			daps[0]=rraVO.getAnswer1();
			daps[1]=rraVO.getAnswer2();
			daps[2]=rraVO.getAnswer3();
			daps[3]=rraVO.getAnswer4();
			daps[4]=rraVO.getAnswer5();
			logger.info("����"+daps[0]+daps[1]+daps[2]+daps[3]+daps[4]);
		}
		if(tiResult==1){
			takes[0] =ptVO.getTake1();
			takes[1] =ptVO.getTake2();
			takes[2] =ptVO.getTake3();
			takes[3] =ptVO.getTake4();
			takes[4] =ptVO.getTake5();
			logger.info("�䳻�� ����"+takes[0]+takes[1]+takes[2]+takes[3]+takes[4]);
		}
		TakeVO rtVO=testDao.getTake(ptVO);//����� ���� SELECTó��
		// ä������(�������μ���)- �߰�
		//���� ��������:60��
		//���� ����:20��
		//��������: Ȥ�� sql�� ������ ó�� �� �� ������?
		int cnt =0; //���� ����
		int bscore =20; //���� ����
		int score=0; //���û��� ������ ��� ����
		int pscore =60;
		String decision ="���հ�";
		for(int i=0;i<daps.length;i++){
			for(int j=0;j<takes.length;j++){
				if(i==j){ //�迭�� �ε����� ����? - ���� �����Դϴ�.
					if(daps[i]==takes[j]){ //��
						++cnt;
					}
				}
			}
		}
		//���û� ���� ��� �ϱ�
		score = bscore*cnt;
		//�հ� ���� ���
		if(score>=pscore){
			decision ="�հ�";
		}else{
			decision="���հ�";
		}
		peVO.setDecision(decision); //�հ� ���հ��� ���
		peVO.setScore(score);
		peVO.setTake_yn("1");//���� :1 �̸� ���� 0�̸� ������
		//update��(�ش� ������� ���� ��������)
		/*
		 * update examinee
		 		set decision ='�հ�' -- or '���հ�'
		  		,score =80
		  		,take_yn=1
		 		where test_no ='2017010001'
		 */
		euResult=testDao.examineeUpdate(peVO);//���� ���� ���� ���� ���� UPDATEó��
		//����� �������� ó�� ���� SELECTó��
		//���� ���� ��� ������ ��ȸ�ϱ�
		//�Ʒ� �޼ҵ�� ����ó�� �ϴ� check SQL���� ���� �غ���
		reVO=testDao.testLogin(peVO);
		logger.info("���� ��ȣ:"+reVO.getTest_no());
		logger.info("����:"+reVO.getT_name());
		logger.info("�������:"+reVO.getDecision());
		logger.info("����:"+reVO.getScore());
		logger.info("���ÿ���:"+reVO.getTake_yn());
		return reVO;
	}

	public ExamineeVO testLogin(ExamineeVO peVO) {
		logger.info("testLogin ȣ�� ����");
		ExamineeVO reVO = null;
		OnLineTestDao testDao = new OnLineTestDao();
		reVO=testDao.testLogin(peVO);
		return reVO;
	}
}

