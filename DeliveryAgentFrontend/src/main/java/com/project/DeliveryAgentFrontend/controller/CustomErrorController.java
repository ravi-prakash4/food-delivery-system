package com.project.DeliveryAgentFrontend.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController  {
	@RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		String errorIntro=new String("Oh Snap! Something Went Wrong");
		String errorMsg =new String();
		ModelAndView errorPage = new ModelAndView("errorPage");
	    if (status != null) {
	    	Integer errorCode=Integer.valueOf(status.toString());
	    	switch (errorCode) {
			case 403 :errorMsg="Error 403 : You are not authorized to view the page you are looking for"; break;
			case 404 :errorMsg="Error 404 : The page you are looking for does not exist."; break;
			default:errorMsg="There was an error with error code : "+errorCode;break;
			}
	    }
	    else {
	    	errorMsg="There was an unknown error";
	    }
	    errorPage.addObject("errorMsg", errorMsg);
	    errorPage.addObject("errorIntro",errorIntro);
        return errorPage;
    }
}
