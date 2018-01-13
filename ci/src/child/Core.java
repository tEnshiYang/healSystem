package child;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Child;

import dao.db;

public class Core {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		distruByAge();
//		System.out.println(getAgeAndShengaos());
	
	}
	public static List<Child> getChild(){
		List<Child> res = new ArrayList<Child>();
		Connection conn=db.getConnection();
		  String sql = "select * from child_data_avg";
		    PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		       
		     
		        ResultSet rs = pstmt.executeQuery();
//		      System.out.println(Double.parseDouble("16.9999999"));
		        while(rs.next()){
		        	  Child tChild=new Child( 
			    		   rs.getString("name"),rs.getString("birth").substring(0,2),rs.getString("tiwen"),
			    		   rs.getString("tizhong"),rs.getString("BMI"),
			    		   rs.getString("shengao")
			    		   );
		        	  res.add(tChild);
		        	
		        
		        }
		    
		        pstmt.close();
		        conn.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return res;
	}

//	//将数据库信息按年龄存到各自list中
//	public static void distruByAge(){
//		Connection conn=db.getConnection();
//		  String sql = "select * from child_data_avg";
//		    PreparedStatement pstmt;
//		    try {
//		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
//		       
//		     
//		        ResultSet rs = pstmt.executeQuery();
////		      System.out.println(Double.parseDouble("16.9999999"));
//		        while(rs.next()){
//		        	  Child tChild=new Child( 
//			    		   rs.getString("name"),rs.getString("birth"),rs.getString("tiwen"),
//			    		   rs.getString("tizhong"),rs.getString("BMI"),
//			    		   rs.getString("shengao")
//			    		   );
////		        	  res.add(new ageAndBmi(rs.getString("birth").substring(0,2), rs.getString("BMI")));
////		        	  System.out.println(res);
//		        	  int age=Integer.valueOf(rs.getString("birth").substring(0, 2))/12;
//		        	  switch(age){
//			        	  case 2:
//			        		  two.add(tChild);
//			        		  break;
//			        	  case 3:
//			        		  three.add(tChild);
//			        		  break;
//			        	  case 4:
//			        		  four.add(tChild);
//			        		  break;
//			        	  case 5:
//			        		  five.add(tChild);
//			        		  break;
//			        	  case 6:
//			        		  six.add(tChild);
//			        		  break;
//		        	  }
//		        	
//		        }
//		     
////		        for (int i = 0; i < three.size(); i++) {
////		            System.out.println(three.get(i));
////		        }
////		        System.out.println(rs.getString("tiwen"));
//		     
//		        pstmt.close();
//		        conn.close();
//		    } catch (SQLException e) {
//		        e.printStackTrace();
//		    }
//	}

}
