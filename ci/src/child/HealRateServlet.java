package child;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Child;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HealRateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HealRateServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
//	public static void main(String[] args){
//		 List<Child> list = new ArrayList<Child>();
//	        list=Core.getChild();
//	        List<Integer> res = new ArrayList<Integer>();
//	        int a=0;//过轻人数
//	        int b=0;//健康人数
//	        int c=0;//超重人数
//	        int d=0;//肥胖人数
//	        for(int i=0;i<list.size();i++){
//	        	Double bmi=Double.valueOf(list.get(i).getBmi());
//	        	if(bmi<15.2){
//	        		a++;
//	        	}else if(bmi>=15.2&&bmi<16.8){
//	        		b++;
//	        	}else if(bmi>=16.8&&bmi<18){
//	        		c++;
//	        	}else{
//	        		d++;
//	        	}
//	        }
//	        res.add(a);
//	        res.add(b);
//	        res.add(c);
//	        res.add(d);
//	        System.out.println(res.get(1));
//	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();    //提供java-json相互转换功能的类
        List<Child> list = new ArrayList<Child>();
        list=Core.getChild();
        List<Integer> res = new ArrayList<Integer>();
        int a=0;//过轻人数
        int b=0;//健康人数
        int c=0;//超重人数
        int d=0;//肥胖人数
        for(int i=0;i<list.size();i++){
        	Double bmi=Double.valueOf(list.get(i).getBmi());
        	if(bmi<15.2){
        		a++;
        	}else if(bmi>=15.2&&bmi<16.8){
        		b++;
        	}else if(bmi>=16.8&&bmi<18){
        		c++;
        	}else{
        		d++;
        	}
        }
        res.add(a);
        res.add(b);
        res.add(c);
        res.add(d);
        String json = mapper.writeValueAsString(res);    //将list中的对象转换为Json格式的数组
//        
        System.out.println(json);
        
        //将json数据返回给客户端
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write(json);
	}

}
