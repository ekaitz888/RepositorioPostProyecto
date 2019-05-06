<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  import="modelo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ProductoModel myProduct = (ProductoModel) request.getAttribute("myProduct");%>
{<br>
"ProductoModel":[<br>		

<%for (int i=0;i<myProduct.getList().size();i++){%>
{<br>
"id_producto":<%=myProduct.getList().get(i).getId_producto() %>,<br>
"nombre":"<%=myProduct.getList().get(i).getNombre() %>",<br>
"precio": <%=myProduct.getList().get(i).getPrecio() %>,<br>
"id_filtros":<%=myProduct.getList().get(i).getId_filtro() %>,<br>
"imagen":"<%=myProduct.getList().get(i).getImagen() %>"<br>
},<br>
<%} %>
]<br>
}
</body>
</html>