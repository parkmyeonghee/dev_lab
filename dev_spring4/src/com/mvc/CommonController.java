package com.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vo.ZipCodeVO;

@Controller
@RequestMapping(value="/common")
public class CommonController{
Logger logger = Logger.getLogger(CommonController.class);
@Autowired
public CommonLogic commonLogic =null;
@RequestMapping(value="getZipCodeList.kosmo")
public String getZipCodeList(ModelMap pMap,@ModelAttribute ZipCodeVO zVO){
	logger.info("getzipcodeList ȣ�� ����");
	List<Map<String,Object>> zipList=commonLogic.getZipCodeList(zVO);
	//webContent/common/jSonZipCodeList.jsp
	//�����ȣ ��ȸ����� ���Ȼ� �߿��� ������ �ƴϹǷ�
	//WebContent�Ʒ� ����
	pMap.addAttribute("zipList",zipList);
	return "forward:./jSonZipCodeList.jsp" ; //WEB-INF/jsp/.jsp
}

}
