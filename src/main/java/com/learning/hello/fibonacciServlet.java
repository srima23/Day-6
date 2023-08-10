package com.learning.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.io.*;

/**
 * Servlet implementation class fibonacciServlet
 */
public class fibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private static int fibonacci(int n) {
		    if (n == 0) {
		      return 1;
		    } else if (n == 1) {
		      return 1;
		    } else {
		      return fibonacci(n-1) + fibonacci(n-2);
		    }
		  }
    	   private static List<Integer> fibonacciSeq(int n) {
    		    List<Integer> fibonacciSeries = new ArrayList<>();
    		    for (int i = 0; i < n; i++) {
    		        fibonacciSeries.add(fibonacci(i));
    		    }
    		    return fibonacciSeries;
    		}
    	     
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
			  PrintWriter out = response.getWriter();
			  response.setContentType("text/html");
		      if(request.getParameter("n")=="") {
		    	  
		      out.println("This cant be empty! Please give a value");
     	      return;
		      }
		      else {
		    	  int limit=Integer.valueOf(request.getParameter("n"));
		          out.println(String.format("<p>%s</p>", fibonacciSeq(limit)));
		      }
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    	
		 PrintWriter out = response.getWriter();
	      if(request.getParameter("formLimit")==null) {
	    	  
	      out.println("This cant be empty!  Please give a value");
	      return;}
	      else {
	    	  int limit=Integer.valueOf(request.getParameter("formLimit"));
	          out.println(String.format("<p>%s</p>", fibonacciSeq(limit)));
	      }
}
}
		    
		  