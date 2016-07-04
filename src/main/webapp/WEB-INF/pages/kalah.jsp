<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<style>
.button {
    background-color: white;
    border: none;
    color: white;
    padding: 32px 48px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}

.buttonBlack {
    background-color: white;
    color: black;
    border: 2px solid #555555;
}

.buttonBlack:hover {
    background-color: #555555;
    color: white;
}

.disabledBlue {
    background-color: #008CBA;
    opacity: 0.6;
    cursor: not-allowed;
}

.disabledGreen {
    background-color: #4CAF50;
    opacity: 0.6;
    cursor: not-allowed;
}

.kalahBlue {
    background-color: #008CBA;
    opacity: 0.6;
    cursor: not-allowed;
    font-size: 32px;
     padding: 96px 64px;
}

.kalahGreen {
    background-color: #4CAF50;
    opacity: 0.6;
    cursor: not-allowed;
    font-size: 32px;
     padding: 96px 64px;
}
</style>
</head>

<body>
	<h1 align="center">Kalah Game</h1>
	
		
	 <c:if test="${endOfGame != null}">
	 <h1 align="center">${endOfGame}</h1>
     </c:if>
	
	<form:form action="/kalah.htm" modelAttribute="state">
	
<h1 align="left">Player 1</h1>
		<table>
	
<c:if test="${not empty boardArray}">			
<table>



  <c:if test="${state.currentPlayer == 0}">
  <tr>
    <td></td>
     <td><a id="button5" href="kalah.htm?move=5" class="button buttonBlack">${boardArray[5]}</a></td>  
     <td><a id="button4" href="kalah.htm?move=4" class="button buttonBlack">${boardArray[4]}</a></td>  
     <td><a id="button3" href="kalah.htm?move=3" class="button buttonBlack">${boardArray[3]}</a></td>
     <td><a id="button2" href="kalah.htm?move=2" class="button buttonBlack">${boardArray[2]}</a></td>
     <td><a id="button1" href="kalah.htm?move=1" class="button buttonBlack">${boardArray[1]}</a ></td>
     <td><a id="button0" href="kalah.htm?move=0" class="button buttonBlack">${boardArray[0]}</a></td>
 	<td></td>
  </tr>
  </c:if>
  
    <c:if test="${state.currentPlayer == 1}">
  <tr>
   	<td></td>
    <td><a id="button5"  class="button disabledBlue">${boardArray[5]}</a></td> 
    <td><a id="button4" class="button disabledBlue">${boardArray[4]}</a></td> 
    <td><a id="button3" class="button disabledBlue">${boardArray[3]}</a></td>  
    <td><a id="button2" class="button disabledBlue">${boardArray[2]}</a></td>
    <td><a id="button1" class="button disabledBlue">${boardArray[1]}</a></td>
    <td><a id="button0"  class="button disabledBlue">${boardArray[0]}</a></td>
 	<td></td>
  </tr>
  </c:if>

  <tr>
   <td><a  id="button6" class="button kalahBlue">${boardArray[6]}</a ></td>
    <td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
   <td><a id="button13" class="button kalahGreen">${boardArray[13]}</a></td>
  </tr>
  

<c:if test="${state.currentPlayer == 0}">
 <tr>
    <td></td>
    <td><a id="button7" class="button disabledGreen">${boardArray[7]}</a></td>
    <td><a id="button8" class="button disabledGreen">${boardArray[8]}</a></td>
    <td><a id="button9" class="button disabledGreen">${boardArray[9]}</a></td>
    <td><a id="button10" class="button disabledGreen">${boardArray[10]}</a></td>
    <td><a id="button11" class="button disabledGreen">${boardArray[11]}</a></td>
     <td><a id="button12" class="button disabledGreen">${boardArray[12]}</a></td>
 	<td></td>
  </tr>
  
  </c:if>
  
  <c:if test="${state.currentPlayer == 1}">
 <tr>
    <td></td>
    <td><a id="button7" href="kalah.htm?move=8" class="button buttonBlack">${boardArray[7]}</a></td>
     <td><a id="button8" href="kalah.htm?move=8" class="button buttonBlack">${boardArray[8]}</a></td>
     <td><a id="button9" href="kalah.htm?move=9" class="button buttonBlack">${boardArray[9]}</a></td>
     <td><a id="button10" href="kalah.htm?move=10" class="button buttonBlack">${boardArray[10]}</a></td>
      <td><a id="button11" href="kalah.htm?move=11" class="button buttonBlack">${boardArray[11]}</a></td>
      <td><a id="button12" href="kalah.htm?move=12" class="button buttonBlack">${boardArray[12]}</a></td>
 	<td></td>
  </tr>
  
  </c:if>


  

  
</table>

</c:if>
			

			
		</table>
		<h1 align="right">Player 2</h1>
	
</form:form>

</body>
</html>
