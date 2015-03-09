//function f()
//{
	//document.getElementById('d1').style.border="2px solid grey";
	//$("#d1").css("border-bottom-color", "#083e55");
	
	//ert("Page is loaded");
	//$('.mm').css('size', '100px');
  //document.getElementByClassName('mm').style.border="2px solid grey";
//	 document.getElementByClassName('newportlet-portlet').getElementByClassName('.portlet').style.border="1px solid grey";
//}



function load(cssClassName)
{
	
	document.getElementById('div-style').style.height="150px";
	//document.getElementById('div-style').style.width="300px";
	//document.getElementById('td1').style.opacity=0.9;
	
	var func = function () { document.getElementById('td1').style.opacity=0.9;};
	setTimeout(func, 200);
	
	var func1 = function () { document.getElementById('td2').style.opacity=0.9;};
	setTimeout(func1, 200);
	//alert("Page is loaded");
	var func2 = function () { document.getElementById('td3').style.opacity=0.9;};
	setTimeout(func2, 200);
	
	var func3 = function () { document.getElementById('td4').style.opacity=0.9;};
	setTimeout(func3, 400);
	
	var func4 = function () { document.getElementById('td5').style.opacity=0.9;};
	setTimeout(func4, 400);
	
	var func5 = function () { document.getElementById('div-style').style[boxshadow]='5px 5px 5px #888888';};
	setTimeout(func5, 700);
		
}

function regload()
{
	
	document.getElementById('reg1').style.height="310px";
	//document.getElementById('div-style').style.width="300px";
	//document.getElementById('td1').style.opacity=0.9;
	
	var func = function () { document.getElementById('rf').style.opacity=0.9;};
	setTimeout(func, 200);
	
	var func = function () { document.getElementById('tr1').style.opacity=0.9;};
	setTimeout(func, 300);
	
	var func1 = function () { document.getElementById('tr2').style.opacity=0.9;};
	setTimeout(func1, 450);
	//alert("Page is loaded");
	var func2 = function () { document.getElementById('tr3').style.opacity=0.9;};
	setTimeout(func2, 550);
	
	var func3 = function () { document.getElementById('tr4').style.opacity=0.9;};
	setTimeout(func3, 650);
	
	var func4 = function () { document.getElementById('tr5').style.opacity=0.9;};
	setTimeout(func4, 800);
	
	var func5 = function () { document.getElementById('tr6').style.opacity=0.9;};
	setTimeout(func5, 900);
	
	var func6 = function () { document.getElementById('tr7').style.opacity=0.9;};
	setTimeout(func6, 900);
	
	var func7 = function () { document.getElementById('tr8').style.opacity=0.9;};
	setTimeout(func7, 1350);
	
	
	var func5 = function () { document.getElementById('reg1').style[boxshadow]='5px 5px 5px #888888';};
	setTimeout(func5, 700); 
	
}



function signin(signinForm){
	
	var email = document.signinForm.email.value;
	var check_email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
	var password = document.signinForm.password.value;
	
	var flag= new Array();
	
    document.getElementById('email').style.border="1px solid grey";
    document.getElementById('password').style.border="1px solid grey";
	

	if((email=="") || (!check_email.test(email)))
    {
		  document.getElementById('email').style.border="1px solid red";
		  flag[0]=0;
    }
	
	else
   	{
    	 document.getElementById('email').style.border="1px solid grey";
    	 flag[0]=1;
   	}


    if((password==""))
    {
    	document.getElementById('password').style.border="1px solid red"; 
    	flag[1]=0;
    }
    
    else
   	{
    	 document.getElementById('password').style.border="1px solid grey";
    	 flag[1]=1;
   	}


    if((flag[0] == 1) && (flag[1] == 1))
    {
        return true;
    }
    else 
    {
        return false;
    }
   
    

}

function check(){
		
	var value = document.getElementById('gender').value;	
		
	if(value!=0)
    {
        document.getElementById('gender').style.color="black";
    }
	
}

function checkD(){
	
	var value = document.getElementById('dob').value;	
		
	if(value!=0)
    {
        document.getElementById('dob').style.color="black";
    }
	
}

function checkM(){
	
	var value = document.getElementById('month').value;	
		
	if(value!=0)
    {
        document.getElementById('month').style.color="black";
    }
	
}

function checkY(){
	
	var value = document.getElementById('year').value;	
		
	if(value!=0)
    {
        document.getElementById('year').style.color="black";
    }
	
}

function reg(regForm)
{    
	 var fName = document.regForm.fName.value;
	
	 var lName = document.regForm.lName.value;
	 
    var email = document.regForm.email.value;
    var check_email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
   
    var password = document.regForm.password.value;
    var check_pass = /^[A-Za-z0-9 ]{6,10}$/;
    
    var repassword = document.regForm.repassword.value;
    
    var date = document.regForm.dob.selectedIndex;
    var month = document.regForm.month.selectedIndex;
    var year = document.regForm.year.selectedIndex;
    
   var gender = document.regForm.gender;
   
   var flag = new Array();
   
  
 
    if(fName=="")
    {
    	document.getElementById('fName').style.border="1px solid red";
    	//document.getElementById('l1').style.color="red";    
    	flag[0]=0;
   	 }
    
    else
   	{
    	 document.getElementById('fName').style.border="1px solid grey";
    	 flag[0]=1;
   	}

    if(lName=="")
    {
    	document.getElementById('lName').style.border="1px solid red";
    	//document.getElementById('l1').style.color="red";    
    	flag[1]=0;
   	 }

    else
   	{
    	 document.getElementById('lName').style.border="1px solid grey";
    	 flag[1]=1;
   	}


    if((email=="") || (!check_email.test(email)))
    {
    	document.getElementById('email').style.border="1px solid red";
    	//document.getElementById('l1').style.color="red";    
    	flag[2]=0;
   	 }
    
    else
   	{
    	 document.getElementById('email').style.border="1px solid grey";
    	 flag[2]=1;
   	}


    if((password=="") || (!check_pass.test(password)))
    {
    	document.getElementById('password').style.border="1px solid red"; 
    	flag[3]=0;
    
    }
    
    else
   	{
    	 document.getElementById('password').style.border="1px solid grey";
    	 flag[3]=1;
   	}

    
    if((password!=repassword) || (repassword=="") )
    {
        document.getElementById('repassword').style.border="1px solid red";    
        flag[4]=0;
    }
    
    else
   	{
    	 document.getElementById('repassword').style.border="1px solid grey";
    	 flag[4]=1;
   	}

    
    if(date==0)  
    {
        document.getElementById('dob').style.border="1px solid red";
        flag[5]=0;
    }
    
    else
   	{
    	 document.getElementById('dob').style.border="1px solid grey";
    	 flag[5]=1;
   	}

    
    if(month==0)
    {
        document.getElementById('month').style.border="1px solid red"; 
        flag[6]=0;
    }

    else
   	{
    	 document.getElementById('month').style.border="1px solid grey";
    	 flag[6]=1;
   	}

    if(year==0)
   	{
        document.getElementById('year').style.border="1px solid red";  
        flag[7]=0;
   	}

    else
   	{
    	 document.getElementById('year').style.border="1px solid grey";
    	 flag[7]=1;
   	}
    
    if ((!gender[0].checked) && (!gender[1].checked))
    {
    	document.getElementById('d1').style.borderRadius = '3em';
    	document.getElementById('d2').style.borderRadius = '3em';

    	document.getElementById('d1').style.border="1px solid red";
    	document.getElementById('d2').style.border="1px solid red";  
    	flag[8]=0;
    }

    else
   	{
    	 document.getElementById('d1').style.border="1px solid #f9f9f9";
    	 document.getElementById('d2').style.border="1px solid #f9f9f9";
    	 flag[8]=1;
   	}
 

    if((flag[0] == 1) && (flag[1] == 1) && (flag[2] == 1) && (flag[3] == 1) && (flag[4] == 1) && (flag[5] == 1) && (flag[6] == 1) && (flag[7] == 1) && (flag[8] == 1))
    {
        return true;
    }
    else 
    {
        return false;
    }
}

/*function SetOpacity(j){                  
//getElementById.style.opacity = opacity / 100;
document.getElementById('reg1').style.opacity=j;
}
function regload(){ 


    var timer = 0;
    if (i < j) { 
    	
    	for (var i=0; i <= 8; i++) {
    		j=j+0.10;
    	    (function(opacity) {
    	        setTimeout(function() {SetOpacity(j);}, 100);
    	    });
    	    
    	 }
    }           
}*/
/*function ff(j)
{
document.getElementById('reg1').style.opacity=j;
}

function regload()
{
//alert("Page is loaded");
//var reg=document.getElementById('reg1');
//var func4 = function () { reg.style.opacity=0.9;};
//setTimeout(func4, 100);

var i=0;
//var func;
var j=0;
for(i=0;i<4;i++)
{
	j=j+0.25;
	
	//ff = function(){  reg.style.opacity=j; };

	if(j !=4)
		{
			setTimeout(function() {ff(j);}, 700);
		
		}
}
}*/
