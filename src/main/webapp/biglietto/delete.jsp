<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionebiglietti.model.Biglietto"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Elimina Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Visualizza biglietto da eliminare</h5>
					    </div>
					     <% Biglietto bigliettoInPagina = (Biglietto)request.getAttribute("delete_biglietto_attr"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Partenza:</dt>
							  <dd class="col-sm-9"><%=bigliettoInPagina.getPartenza() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Destinazione:</dt>
							  <dd class="col-sm-9"><%=bigliettoInPagina.getDestinazione() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo:</dt>
							  <dd class="col-sm-9"><%=bigliettoInPagina.getPrezzo() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data:</dt>
							  <dd class="col-sm-9"><%=bigliettoInPagina.getData()!=null? new SimpleDateFormat("dd/MM/yyyy").format(bigliettoInPagina.getData()):"N.D."  %></dd>
					    	</dl>
					    	
					    </div>
					</div>	   	 
					<form method="post" action="ExecuteEliminaBigliettoServlet" class="row g-3" novalidate="novalidate">
						<input type = "hidden" name = "idBiglietto" value = "<%= bigliettoInPagina.getId() %>">
					    <div class='card-footer'>
					        <a href="ListArticoliServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
					        <button type = "submit" name = "deleteSubmit" value = "deleteSubmit" id = "deleteSubmit" class = "btn btn-primary">CONFERMA</button>
					    </div>
					<!-- end card -->
					</form>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>