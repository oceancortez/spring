<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>

<!DOCTYPE html>
<html>
	<head>
		<!-- Meta, title -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta http-equiv="pragma" content="no-cache" />
    	<meta charset="utf-8">	
    	
    	<!-- css -->
    	<link rel="stylesheet" media="screen" href='<c:url value="/css/usuario.css"/>'/>
		<!-- Bootstrap -->
		<link rel="stylesheet" media="screen" href='<c:url value="/css/bootstrap/bootstrap.min.css"/>'/>
		 <link rel="stylesheet"  media="screen" href='<c:url value="/css/bootstrap/bootstrap-theme.css"/>'/>
		<link rel="stylesheet" media="screen" href='<c:url value="/css/bootstrap/datepicker.css"/>'/>
				
		<!-- DataTables -->
		<link rel="stylesheet" media="screen" href='<c:url value="/css/bootstrap/dataTables.bootstrap.css"/>'/>
		
    	<!-- jQuery -->
		<script type="text/javascript" src='<c:url value="/js/jquery/jquery.min.js"/>'></script>
				<!-- Font Awesome - Framework de icones -->
		<link rel="stylesheet"  href='<c:url value="/css/font-awesome.min.css"/>'/>
		<script type="text/javascript" src='<c:url value="/js/bootstrap/bootstrap.min.js"/>'></script>
		
	</head>
<body>	
	
	<!-- DataTables -->
    <script type="text/javascript" src='<c:url value="/js/jquery/jquery.dataTables.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/js/bootstrap/dataTables.bootstrap.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/js/jquery/jquery.dataTables.pipelining.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/js/jquery/jquery.doubleScroll.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>
	
<!-- Bootstrap -->
	
	
	
	<div id="apiBody" class="apiBody">
	
	
	<!-- Conteudo -->
	<decorator:body>
	teste
	</decorator:body>
	
	</div>	
</body>
</html>
