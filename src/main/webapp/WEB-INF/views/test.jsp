<?xml version="1.0" encoding="ISO-8859-1" ?>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page isELIgnored="false"%>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
<html xmlns="http://www.w3.org/1999/xhtml">  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />  
<title>Insert title here</title>  
</head>  
<body>  
Hi,  
<c:out value="${name}" />  
<br />  
It works!  
<br />  
<a href="/index.jsp">Back</a>  
</body>  
</html>