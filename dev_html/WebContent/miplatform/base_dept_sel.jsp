<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.sql.*,com.util.DBConnectionMgr" %>
    <%@ page import="com.tobesoft.platform.*" %>
    <%@ page import="com.tobesoft.platform.data.*" %>
    <%!
	public String rsGet(ResultSet rs,String id) throws Exception
	{
	if(rs.getString(id)==null) return"";
	else return rs.getString(id);
	}
%>
    <%
    //자바에서 일어난 에러메시지들을 마이플랫폼 화면에서 확인할때
    VariableList vl = new VariableList(); //마이플랫폼에서 제공객체
    //마이플랫폼에서 제공하는 Dataset을 담을 수 있는 객체 제공
    DatasetList dl = new DatasetList();
    String char_set="utf-8";
    //JBDC API를 활용하여 DB연동하기
    /********************JDBC connection*********************************/
    Connection con =null;
    PreparedStatement pstmt=null;
    ResultSet rs = null;
    DBConnectionMgr dbMgr = new DBConnectionMgr();
    StringBuilder sql = new StringBuilder(); //String은 덩어리로 들어가고
    //이 아이는 원본이 바뀌는 구조 하나씩 쪼개져서 들어간다.
    sql.append("select deptno,dname,loc From dept");
    try{
    con =dbMgr.getConnection();
    pstmt=con.prepareStatement(sql.toString());
    rs=pstmt.executeQuery();
    /************************Dataset 생성*******************************/
    Dataset ds_dept = new Dataset("ds_dept",char_set);
    /************************Dataset header초기화*******************************/
    ds_dept.addColumn("deptno",ColumnInfo.CY_COLINFO_INT,10);
    ds_dept.addColumn("dname",ColumnInfo.CY_COLINFO_STRING,40);
    ds_dept.addColumn("loc",ColumnInfo.CY_COLINFO_STRING,40);
    while(rs.next()){
    	int row =ds_dept.appendRow();//1개의 로우를 추가해 준다. dataset안에 로우 하나를 할당
    	//그래야지 값을 담을 수 있기 때문이지.
    	ds_dept.setColumn(row, "deptno", new Variant(rsGet(rs, "deptno")));
    	ds_dept.setColumn(row, "dname", new Variant(rsGet(rs, "dname")));
    	ds_dept.setColumn(row, "loc", new Variant(rsGet(rs, "loc")));
    }
    /***************생성된 DataSet을 DataSetList 추가*************************/
    dl.addDataset("ds_dept",ds_dept);
    /***************변수를 VariableList에 추가*************************/
    vl.addStr("ErrorCode", "0");
    vl.addStr("ErrorMsg", "SUCCESS");
    }catch(SQLException se){
    	
    }catch(Exception e){
    	
    }finally{
    	DBConnectionMgr.freeConnection(con, pstmt,rs);
    }
    /***************결과 xml생성 및 Wed Server로 보내기 ****************/
    out.clear();
    out=pageContext.pushBody();
    out.clearBuffer();
    PlatformResponse pRes=
    		new  PlatformResponse(response
    				,PlatformRequest.XML
    				,char_set);
    pRes.sendData(vl,dl);
    %>
