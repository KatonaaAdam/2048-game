<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

<title>2048 5x5</title>

<link rel="stylesheet" href="../css/gameField.css">

</head>

<body align="center" style="margin:50px" >



<canvas id="canvas" width="500px" height="500px" align="center" style="border:2px solid black; text-align=center"></canvas>
<form action="../GameController" method="post">
<button type="submit" id="eredmeny" class="btn" onclick="get()" style="display:none">Eredmeny</button>
<input name="input" type="text" id="input" style="display:none"></input>
<input name="input2" type="text" id="input2" style="display:none"></input>
</form>
<h1><time>00:00:00</time></h1>

</body>
<script>
var eredmeny =document.getElementById("eredmeny");
    function get(){
        document.getElementById("input").value=lvl;

    }



var lvl=0;

canvas=document.getElementById("canvas");
ctx=canvas.getContext('2d');
var meret=5;
var dis=[[0,0,0,0,0],[0,0,0,2,0],[0,0,0,0,0],[2,0,0,0,0],[0,0,0,0,0]];
var color=["gray","rgb(250,200,200)","rgb(240,200,160)","rgb(160,120,150)","cyan","blue","rgb(0,0,100)","rgb(0,200,0)","rgb(0,50,0)","rgb(150,100,50)","rgb(100,150,50)","rgb(200,0,0)"];
function display(){

console.log(dis);

for(var j=0;j<meret;j++)
for(var i=0;i<meret;i++)
{

//color to be decided by dis[i][j]
if(dis[i][j]!=0)
ctx.fillStyle=color[Math.log2(dis[i][j])];
else{
ctx.fillStyle="rgb(230,230,230)";}
ctx.fillRect(i*100+2,j*100+2,96,96);

if(dis[i][j]!=0){
ctx.font = "20px Comic Sans MS";
ctx.fillStyle = "black";
ctx.textAlign = "center";
ctx.fillText(dis[i][j], i*100+50,j*100+60);
}

}

}

function right(){

for(var i=0;i<meret;i++)
{
//get it
var ar=[0,0,0,0,0];
var vr=[];
for(var j=0;j<meret;j++){
if(dis[j][i]!=0)
vr.push(dis[j][i]);

ar[j]= dis[j][i];
}

//reverse the vr
var tr=[];
for(var k=vr.length-1;k>=0;k--)
{
   tr.push(vr[k]);
}

for(var k=0;k<vr.length;k++)
vr[k]=tr[k];


// vr.length determines the total number of actual characters.
// change the vr

var l=vr.length;
if(l>1){
if(l==2){
if(vr[0]==vr[1]){
vr[0]=2*vr[0];
vr[1]=0;
}
}
else if(l==3){
if(vr[0]==vr[1]){
vr[0]=2*vr[0];
vr[1]=vr[2];
vr[2]=0;
}
else if(vr[1]==vr[2]){
vr[1]=2*vr[1];
vr[2]=0;
}
}
else{
if(vr[0]==vr[1]){
if(vr[2]==vr[3]){
vr[0]=2*vr[0];
vr[1]=2*vr[2];
vr[2]=0;
vr[3]=0;
}

else{
vr[0]=2*vr[0];
vr[1]=vr[2];
vr[2]=vr[3];
vr[3]=0;
}

}
else if(vr[1]==vr[2]){
vr[1]=2*vr[2];
vr[2]=vr[3];
vr[3]=0;
}
else if(vr[2]==vr[3]){
vr[3]=2*vr[2];
vr[3]=0;
}

}
}


for(var k=0;k<meret-l;k++)
vr.push(0);

//reverse vr again;
tr=[];
for(var k=vr.length-1;k>=0;k--)
{
   tr.push(vr[k]);
}

for(var k=0;k<vr.length;k++)
vr[k]=tr[k];

for(var k=0;k<meret;k++)
dis[k][i]=vr[k];




}


}
function down(){

for(var i=0;i<meret;i++)
{
//get it
var ar=[0,0,0,0,0];
var vr=[];
for(var j=0;j<meret;j++){
if(dis[i][j]!=0)
vr.push(dis[i][j]);

ar[j]= dis[i][j];
}

//reverse the vr
var tr=[];
for(var k=vr.length-1;k>=0;k--)
{
   tr.push(vr[k]);
}

for(var k=0;k<vr.length;k++)
vr[k]=tr[k];


// vr.length determines the total number of actual characters.
// change the vr

var l=vr.length;
if(l>1){
if(l==2){
if(vr[0]==vr[1]){
vr[0]=2*vr[0];
vr[1]=0;
}
}
else if(l==3){
if(vr[0]==vr[1]){
vr[0]=2*vr[0];
vr[1]=vr[2];
vr[2]=0;
}
else if(vr[1]==vr[2]){
vr[1]=2*vr[1];
vr[2]=0;
}
}
else{
if(vr[0]==vr[1]){
if(vr[2]==vr[3]){
vr[0]=2*vr[0];
vr[1]=2*vr[2];
vr[2]=0;
vr[3]=0;
}

else{
vr[0]=2*vr[0];
vr[1]=vr[2];
vr[2]=vr[3];
vr[3]=0;
}

}
else if(vr[1]==vr[2]){
vr[1]=2*vr[2];
vr[2]=vr[3];
vr[3]=0;
}
else if(vr[2]==vr[3]){
vr[2]=2*vr[2];
vr[3]=0;
}

}
}


for(var k=0;k<meret-l;k++)
vr.push(0);

//reverse vr again;
tr=[];
for(var k=vr.length-1;k>=0;k--)
{
   tr.push(vr[k]);
}

for(var k=0;k<vr.length;k++)
vr[k]=tr[k];

for(var k=0;k<meret;k++)
dis[i][k]=vr[k];




}


}

function up(){

for(var i=0;i<meret;i++)
{
//get it
var ar=[0,0,0,0,0];
var vr=[];
for(var j=0;j<meret;j++){
if(dis[i][j]!=0)
vr.push(dis[i][j]);

ar[j]= dis[i][j];
}

// vr.length determines the total number of actual characters.
// change the vr

var l=vr.length;
if(l>1){
if(l==2){
if(vr[0]==vr[1]){
vr[0]=2*vr[0];
vr[1]=0;
}
}
else if(l==3){
if(vr[0]==vr[1]){
vr[0]=2*vr[0];
vr[1]=vr[2];
vr[2]=0;
}
else if(vr[1]==vr[2]){
vr[1]=2*vr[1];
vr[2]=0;
}
}
else{
if(vr[0]==vr[1]){
if(vr[2]==vr[3]){
vr[0]=2*vr[0];
vr[1]=2*vr[2];
vr[2]=0;
vr[3]=0;
}

else{
vr[0]=2*vr[0];
vr[1]=vr[2];
vr[2]=vr[3];
vr[3]=0;
}

}
else if(vr[1]==vr[2]){
vr[1]=2*vr[2];
vr[2]=vr[3];
vr[3]=0;
}
else if(vr[2]==vr[3]){
vr[2]=2*vr[3];
vr[3]=0;
}

}
}


for(var k=0;k<meret-l;k++)
vr.push(0);

for(var k=0;k<meret;k++)
dis[i][k]=vr[k];




}


}



function left(){

for(var i=0;i<meret;i++)
{
//get it
var ar=[0,0,0,0,0];
var vr=[];
for(var j=0;j<meret;j++){
if(dis[j][i]!=0)
vr.push(dis[j][i]);

ar[j]= dis[j][i];
}
// vr.length determines the total number of actual characters.
// change the vr

var l=vr.length;
if(l>1){
if(l==2){
if(vr[0]==vr[1]){
vr[0]=2*vr[0];
vr[1]=0;
}
}
else if(l==3){
if(vr[0]==vr[1]){
vr[0]=2*vr[0];
vr[1]=vr[2];
vr[2]=0;
}
else if(vr[1]==vr[2]){
vr[1]=2*vr[1];
vr[2]=0;
}
}
else{
if(vr[0]==vr[1]){
if(vr[2]==vr[3]){
vr[0]=2*vr[0];
vr[1]=2*vr[2];
vr[2]=0;
vr[3]=0;
}

else{
vr[0]=2*vr[0];
vr[1]=vr[2];
vr[2]=vr[3];
vr[3]=0;
}

}
else if(vr[1]==vr[2]){
vr[1]=2*vr[2];
vr[2]=vr[3];
vr[3]=0;
}
else if(vr[2]==vr[3]){
vr[2]=2*vr[2];
vr[3]=0;
}

}
}

for(var k=0;k<meret-l;k++)
vr.push(0);

for(var k=0;k<meret;k++)
dis[k][i]=vr[k];

}

}

display();

var disable=0;
function gameover(){
document.getElementById("input2").value=t;
console.log(t);

clearTimeout(t);
ctx.font = "50px Comic Sans MS";
ctx.fillStyle = "red";
ctx.textAlign = "center";
ctx.fillText("GAME OVER!!", 200,180);
disable=1;

eredmeny.style.display="inline";
ctx.fillStyle = "green";
ctx.textAlign="center";
ctx.font="30px Comic Sans MS";


var count=0;
for(var i=0;i<meret;i++)
for(var j=0;j<meret;j++)
{
if(dis[i][j]==2){
count+=0;
}else{
count+=dis[i][j];}


//console.log(lvl)
console.log("dis :"+dis[i][j]);

if(dis[i][j]>lvl){
lvl=dis[i][j]
console.log("lvl :"+lvl);
}else{
lvl=lvl;
}


}


ctx.fillText("Your Score is "+count.toString(),200,220);
 levelLabel.innerHTML ="Level: "+lvl;
}


window.addEventListener('keydown', function (e) {
    if(disable==1)
	   return;


    key = e.keyCode;
    if(key==37){
    	e.preventDefault();
    	left();
    }
    if(key==38){
    	e.preventDefault();
    	up();
    }
    if(key==39){
    	e.preventDefault();
    	right();
    }
    if(key==40){
    	e.preventDefault();
    	down();
    }

	//if everything is full.
	var count=0;
	for(var i=0;i<meret;i++)
	for(var j=0;j<meret;j++){
		if(dis[i][j]==0)
		{   count++;
 		}

	}

	if(count==0)
	{gameover();
	 return;
	}

	else{
	var n=Math.floor(Math.random()*25);
	for(;n<32;n++){
	  m=n%25;
	if(dis[Math.floor(m/5)][m%5]==0)
	{dis[Math.floor(m/5)][m%5]=2;
	  break;
	}
	}


	}

	/*else{
	//select a random
    var v=Math.floor(Math.random()*16);
	count=0;
	while(1){
	count++;
	if(dis[Math.floor(v/4)][v%4]==0){
	{dis[Math.floor(v/4)][v%4]=2;
	 break;
	}
	}

	if(count==5){
	for(var m=0;m<4;m++)
	for(var n=0;n<4;n++)
	if(dis[m][n]==0)
	dis[m][n]=2;

	}

	}
	}*/


	display();

});


var h1 = document.getElementsByTagName('h1')[0],
    start = document.getElementById('start'),
    stop = document.getElementById('stop'),
    clear = document.getElementById('clear'),
    seconds = 0, minutes = 0, hours = 0,
    t;

function add() {
    seconds++;
    if (seconds >= 60) {
        seconds = 0;
        minutes++;
        if (minutes >= 60) {
            minutes = 0;
            hours++;
        }
    }

    h1.textContent = (hours ? (hours > 9 ? hours : "0" + hours) : "00") + ":" + (minutes ? (minutes > 9 ? minutes : "0" + minutes) : "00") + ":" + (seconds > 9 ? seconds : "0" + seconds);

    timer();
}
function timer() {
    t = setTimeout(add, 1000);
}
timer();

</script>
</html>