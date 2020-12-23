package com.MySteam.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MySteam.domain.User;
import com.MySteam.service.UserService;
import com.MySteam.service.impl.UserServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡview��jsp�е�����
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//����service����в���
		UserService userService=new UserServiceImpl();
		User user=userService.login(username, password);
		//�ж��û����������Ƿ���ȷ�����������ת
		if(user!=null){
		    response.sendRedirect("index.jsp");//��Ӧ�ض���
		}else{
			//������ʾ��Ϣ
			request.setAttribute("msg", "�û��������벻��ȷ��");
			//����ת��(������ʽ���ܻ�ȡAttribute����ʾ��Ϣ)
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}
}
