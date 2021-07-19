<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<head>
<jsp:include page="common/common-header.jsp"/>
    <link rel="stylesheet" href="../css/login.css">
    <title>Főoldal</title>


</head>
<body>
<h1><span style="color:Lightblue">2   </span><span style="color:Brown">0   </span>
<span style="color:Crimson">4   </span><span style="color:DarkGreen">8     </span>
<span style="color:DarkOrange">     G</span><span style="color:DarkSeaGreen">A</span>
<span style="color:DimGray">M</span><span style="color:IndianRed">E </span>
    </h1>
<div class="container">

        <div class="form-group">
        <label for="meret" style="font-size:30px; color:Azure" >Size </label>

        <form action="../FourFieldController" method="post">
                <button id="meret"  class="btn btn-primary">4x4 game field</button>

         </form>
        <form action="../FiveFieldController" method="post">
        <button id="meret"  class="btn btn-primary">5x5 game field</button>

        </form>
        <form action="../SixFieldController" method="post">
        <button id="meret"  class="btn btn-primary">6x6 game field</button>

         </form>
        <form action="../EightFieldController" method="post">
        <button id="meret"  class="btn btn-primary">8x8 game field</button>

         </form>
        </div>

<hr>
        <p id="leiras">A 2048 játék indításához kiválasztjuk a plyaméretet és a játék azonnal elindul.<br>
        A játék befejezése után az eredmény gombra katintva menthetjük el az eredményt és megtekinthetjük a többi végeredményt.
        </p>




</div>
</body>
</html>
