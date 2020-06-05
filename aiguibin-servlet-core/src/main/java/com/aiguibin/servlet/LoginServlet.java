package com.aiguibin.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author AIguibin
 *
 */
@WebServlet(value= {"/loginServlet","/login","/example/save"})
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(".....doGet.....");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(".........doPost.........");
		try {
			JSONObject json01=new JSONObject();
			json01.put("date", "2019-05-22");
			json01.put("name", "林小虎");
			json01.put("address", "上海市宝山区大场镇祁华路160弄大华朗香花园37号楼1单元4楼401室");
			JSONObject json02=new JSONObject();
			json02.put("date", "2019-05-22");
			json02.put("name", "林小虎");
			json02.put("address", "上海市宝山区大场镇祁华路160弄大华朗香花园37号楼1单元4楼401室");
			JSONObject json03=new JSONObject();
			json03.put("date", "2019-05-22");
			json03.put("name", "林小虎");
			json03.put("address", "上海市宝山区大场镇祁华路160弄大华朗香花园37号楼1单元4楼401室");
			JSONObject json04=new JSONObject();
			json04.put("date", "2019-05-22");
			json04.put("name", "林小虎");
			json04.put("address", "上海市宝山区大场镇祁华路160弄大华朗香花园37号楼1单元4楼401室");
			
			JSONArray array=new JSONArray();
			array.add(json01);
			array.add(json02);
			array.add(json03);
			array.add(json04);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(array.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
