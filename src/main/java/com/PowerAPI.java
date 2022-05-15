package com;
import com.Item;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/PowerAPI")
public class PowerAPI extends HttpServlet{
	
	private static final long serialVersionUID =1L;
	Item powerobj = new Power();
	
	public PowerAPI()
	{
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
			 System.out.println("requets recieved");
		String output = itemobj.insertItem(request.getParameter("reportID"),
			 request.getParameter("usage"),
			request.getParameter("powerCuts"),
			request.getParameter("weather"));
			 
			response.getWriter().write(output);
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
			 Map paras = getParasMap(request);
			 
			 String output = itemobj.updateItem(Integer.parseInt(paras.get("hidreportIDSave").toString()),
					 paras.get("reportID").toString(),paras.get("usage").toString(),paras.get("powerCuts").toString(),paras.get("weather").toString());
			 
			response.getWriter().write(output);
	} 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			 Map paras = getParasMap(request);
			 
			 String output = itemobj.deleteItem(paras.get("reportID").toString().trim());
			 System.out.println(paras.get("reportID").toString());
			 response.getWriter().write(output);
	}
	private static Map getParasMap(HttpServletRequest request)
	{
		Map<String, String> map = new HashMap<String, String>();
		
		try
		{
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ?
			scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			
			String[] params = queryString.split("&");
			for (String param : params)
			{ 
	
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
	 }
	catch (Exception e)
	 {
	 }
	return map;
	}
}