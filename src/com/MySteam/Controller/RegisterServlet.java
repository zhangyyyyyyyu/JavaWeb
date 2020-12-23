package com.MySteam.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MySteam.service.UserService;
import com.MySteam.service.impl.UserServiceImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //��ȡǰ������
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		String role=request.getParameter("role");
		//�ж���������������Ƿ�һ��
		if(password.equals(password2)){
			UserService userService=new UserServiceImpl();
			boolean flag=userService.register(username,password,role);
			//�ж��Ƿ��ظ����û���
			if(flag){
				response.sendRedirect("Login.jsp");
			}else{
				request.setAttribute("msg", "���û����Ѵ���,����������!");//����������Ϣ
				request.getRequestDispatcher("Register.jsp").forward(request, response);//����ת��
			}
		}else{
			request.setAttribute("msg", "������������벻һ��,����������!");//����������Ϣ
			request.getRequestDispatcher("Register.jsp").forward(request, response);//����ת��
		}
		
	}

}
