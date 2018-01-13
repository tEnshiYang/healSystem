package child;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Child;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        List<Child> list = new ArrayList<Child>();
        
        //����ѡ�������ơ��͡���������Ϊ�������Է�װ��һ��Product���ÿ��Product��Ķ��󶼿��Կ�����һ�����X������ֵ����������Y������ֵ���ļ���
//        list.add(new Child("����Ӣ","48��",36,17,16,105));
//     
//        list.add(new Child("��׼","0��",37,18,15,103));
        
        ObjectMapper mapper = new ObjectMapper();    //�ṩjava-json�໥ת�����ܵ���
        
        String json = mapper.writeValueAsString(list);    //��list�еĶ���ת��ΪJson��ʽ������
        
//System.out.println(json);
        
        //��json���ݷ��ظ��ͻ���
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write(json);    
    }
}