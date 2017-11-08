package com.mvc;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;
/***********************************************************************************
 * �н���ǥ
 *1.Annotation�� ����ϱ� ���� �ʿ��� ������ �� �� �ִ�.
 *2.Spring Container�� ���� �����Ǿ�� �ϴ� Bean�� �����ϱ� ���� ����� �� 
 *�ִ� Annotation�� ������ �˰� Ȱ���� �� �ִ�.
 *Dependency Injection�� ���� ����� �� �ִ� Annotation�� ������ �˰� 
 *Ȱ���� �� �ִ�.
 *4.Bean �� Life Cycle�� �����ϴ� Annotation�� ������ �����ϰ� Ȱ���� �� �ִ�.
 *
 *Spring Bean���� �� AOP,Transaction ���� ����� ����ϰ��� �� ��
 *�ʿ��� �Ӽ����� XML�� �̿��Ͽ� ����
 *���� ����
 *����ϰ� ������ �Ӽ� ���� ���ϵ�� ���� �ý��� ���� �� ���������� ������
 *�ʷ��� ���ɼ��� ���� ����
 *
 *�ذ���
 *��κ��� ���¼ҽ� �������� CoC(Convention Over Configuration)��� ����Ʈ����
 *���� �з������� �����Ͽ� �ִ��� ������ ���̰� �ּ����� ������
 *Annotation�� �̿��Ͽ� �� �� �ֵ��� �����ϰ� �ִ�.
 *
 *Dependency Injection
 *@Autowired
 *���δٸ� Bean���� Dependency Injection ���Ǹ� ���� Annotation
 *Spring�� �������̱� ������ ������ �� �ִ� ��ġ�� @Resoure���� �پ��ϰ�,
 *������ Dependency Injection�� �ʿ��� ��쿡 �����մϴ�.
 *
 *@Autowired�� required�Ӽ�
 *�⺻������ @Autowired�� ����� �Ӽ��� �ʼ��̱� ������ �ش� Bean�� �����ؾ� ������
 *required�Ӽ��� false�� �����ϴ� ��쿡�� �ش�Ǵ� Bean�� ã�� ���ϴ���
 *������ �߻����� �ʰ� ��
 *
 *@Autowired - @Qualifier
 *�⺻������ @Autowired �� type-driven injection ���·� �����Ͽ� @Autowired��
 *���� �Ǿ��� ��� Spring Container�� �ش� Bean�� ã�� �� Ŭ������ type�� �������� �˻�
 *�̶� Dependency Injection�� ������ ��� ���ؼ��� @Qualifier�� �ʿ�
 *
 *Stereotype Annotation
 *Spring������ ���̾� ���� ������Ҹ� �����Ͽ� Annotation�� ����� ���� ����
 *Spring���� ���̾�� ������Ҹ� �����Ͽ� ����ϴ� Annotation����
 *@Service,@Repository,@Controller�� �ֽ��ϴ�.
 *1)@Service:����Ͻ� ������ ó���ϴ� Ŭ������ �����ϴµ� ����մϴ�.
 *2)@Repository:������ ���� ������ ó���ϴ� Ŭ������ �����ϴµ� ���.
 *3)@Controller:���������̼� ���̾ �����ϴ� ControllerŬ������ �����ϴµ� ���
 *Spring MVC����� ��쿡�� ���� Ȱ�밡��.
 *
 *Ʈ������ ���Ĺ��� �����ϱ�
 *REQUIRED:������ Ʈ������� �����ϸ� ���� Ʈ����ǿ��� ����Ǹ� 
 *				������ Ʈ������� �������� ������ ���ο� Ʈ������� �߻�
 *REQUIRES_NEW:������ Ʈ������� ������� �ʰ� ���ο� Ʈ������� �������� ����
 *SUPPORTS:���� Ʈ������� �����ϸ� ���� Ʈ����ǿ��� ����Ǹ� ������
 					Ʈ������� �������� ������ Ʈ����� ���� ����ȴ�.
*NOT_SUPPORTED:���� Ʈ������� �����ص� Ʈ����� ���� ����ȴ�.
*NEVER:���� Ʈ������� �����ϸ� ���ܸ� �߻���Ű�� ����Ʈ������� �������� ������
			Ʈ����� ���� ����ȴ�.
*NESTED:���� Ʈ������� �����ϸ� ��ø�� Ʈ������� ����Ǹ� ������ Ʈ�������
*			�������� ������ REQUIRED�� �����ϰ� ����ȴ�.
 **********************************************************************************/
@Service
public class BoardLogic {
	Logger logger = Logger.getLogger(BoardLogic.class);
	@Autowired(required=false)
	public BoardDao boardDao =null;
/***************************************************************************************
	 * �Խ��� �۾��� ����
	 * ������ ����� ���� ����Ʈ ȭ�鿡�� �۾��� ��ư�� ���ؼ� �̺�Ʈ�� ó���ǰ�
	 * ����� ����� ���� ������������ �亯 ��ư�� Ŭ������ �� ó���Ѵ�.
	 * �����϶��� �� ��ȣ�� �������� ���� ä���ϰ� b_group���� Max���� 1���� ������ ����ؾ� �Ѵ�.
	 * ����� ��쿡�� b_no�� ä���ϰ� b_group���� ������������ �Ѱܹ��� ������ ���.
	 * ����� ��� ȭ������ ���� b_step���� �޾Ƽ� ���� ���� �׷쿡 �� ū���� �����ϸ�
	 * ���ԵǴ� �� �Ʒ��� �ִ� ��۵��� b_step���� ���� 1�� ���� ������ update�ؾ���
	 * update�� �ۼ��غ���-������ ��� �ش���� ����� ��츸 ����
	 * UPDATE board_master
	 * 	SET b_step =b_step+1
	 * WHERE b_group=?(�󼼺��⿡�� hidden���� �޾ƿ� ��)
	 * AND b_step>?(�󼼺��⿡�� hidden���� �޾ƿ� ��)
	 * @param pbmVO
	 * @param pbsVO
	 * @return
	************************************************************************************/
	//Ʈ�����ó�� ����
@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor={DataAccessException.class})
@Pointcut(value="execution(* com.mvc.*Logic.*(..)")
	public int[] boardInsert(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
		int mresult =0;
		int sresult=0;
		int results[]=new int[2];
		try {
			//���?(read.jsp ȣ��)
			if(pbmVO.getB_no()>0){
				boardDao.bStepUpdate(pbmVO);
				pbmVO.setB_pos(pbmVO.getB_pos()+1);
				pbmVO.setB_step(pbmVO.getB_step()+1);
			}
			//����?(List.jsp) - �۹�ȣ ���� ä��
			else{
				int b_group =boardDao.getBgroup(pbmVO);
				pbmVO.setB_group(b_group);
				pbmVO.setB_pos(0);
				pbmVO.setB_step(0);
			}
			mresult = boardDao.boardMasterInsert(pbmVO);
			//÷�� ������ �����ϴ�?
			sresult=boardDao.boardSubInsert(pbsVO);
			if(pbsVO.getB_file().length()>0){
				sresult=boardDao.boardMasterDelete(pbmVO);
			}
		} catch (DataAccessException de) {
			//boardMasterInsert,boardInsert,bStepUpdate
			//DataAccessException�� �ش�� �� �ѹ�ó���ϱ� ���� �ڵ�(����)
			throw de;//�����������̳ʿ��� ������. �����������ӿ�ũ���� ����
		}
		results[0] =mresult;
		results[1]=sresult;
		return results;
	}

	public List<Map<String, Object>> getBoardList(BoardMasterVO pbmVO
									, HttpServletRequest req) {
		List<Map<String,Object>> boardList =null;
		int total=0;//��ü ���ڵ� ��
		if(req!=null){
			//��ü ī��Ʈ ��
			total=boardDao.totalRecord();
			HttpSession session =req.getSession();
			session.setAttribute("total", total);	
		}
		int page=0;//���� ����ڰ� �ٶ󺸴� ������ ��ȣ(1,2,...)
		//�� �������� ó�� �Ǵ� �ο�(ȭ��:pMap)
		int pageSize=0;
		if(pbmVO.getPage()>0)
			page=pbmVO.getPage();
		if(pbmVO.getPageSize()>0)
			pageSize=pbmVO.getPageSize();
		int start=0;//�������� ���۹�ȣ
		int end=0;//�������� �� ��ȣ
		if(page<0){
			start=((page-1)*pageSize)+1;
			end=page*pageSize;
			pbmVO.setStart(start);
			//total�� end���� ������ end��� total���� ��� �ּ���
			//�׷��� ������ end�� ��� �ּ��� 
			pbmVO.setEnd(end);
		if(end>total){
			pbmVO.setEnd(total);
		}
		else{
			pbmVO.setEnd(end);
		}
		}
		boardList=boardDao.getboardList(pbmVO);
		return boardList;
	}
	public int[] boardUpdate(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
		int mresult =0;
		int sresult=0;
		int results[] = new int[2];
		mresult = boardDao.boardMasterUpdate(pbmVO);
		//������ �ִ� ������ ���� ó�� �մϴ�.
		String filename = pbsVO.getOrg_file();
		String path="C:\\Users\\azaza\\Desktop\\dev_lab\\dev_spring4\\WebContent\\pds\\";
		String fullpath=path+filename;
		//�ش��ϴ� ������ ��ü�� �����
		File f = new File(fullpath);
		//�ش� ������ �����ϴ�?
		if(f.exists()){
			boolean isOk = f.delete();
			logger.info("��������"+isOk);
		}
		//f.delete() ȣ���ؼ� ������ ������ �� �ִ�.
		if(pbsVO.getB_file().length()>0){
		sresult=boardDao.boardSubUpdate(pbsVO);
		}
		results[0] =mresult;
		results[1]=sresult;
		return results;
	}

	public int[] boardDelete(BoardMasterVO pbmVO, BoardSubVO pbsVO) {
		int mresult =0;
		int sresult=0;
		int results[] = new int[2];
		mresult = boardDao.boardMasterDelete(pbmVO);
		sresult=boardDao.boardSubDelete(pbsVO);
		results[0] =mresult;
		results[1]=sresult;
		return results;
	}


}
