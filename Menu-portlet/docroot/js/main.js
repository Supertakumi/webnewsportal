
/*function openportlet(){
	//alert('hello world!');
	Liferay.Portlet.add({
		portletId: AddNewPortlet}
		);
}*/

var addPortletOnPage = function(portletId){
	 Liferay.Portlet.add({
	  portletId: portletId
	 });
	};

function add(){

var plid = themeDisplay.getPlid();

var portletId = 'sport';

var onComplete = null;

var beforePortletLoaded = null;

var portletOptions = {

beforePortletLoaded: beforePortletLoaded,

onComplete: onComplete,

plid: plid,

portletId: portletId,

};

Liferay.Portlet.add(portletOptions);

}


function f(){
document.getElementById("p1").style.display = "block";
document.getElementById("bmenu").style.visibility= "visible";
//document.getElementById("p1").style.opacity ="0.2";

}

function hideIt(event){
	event.stopPropagation(); //cancel bubbling

	   ele = event.target || event.srcElement;
	   if (ele.id === "p1"){  
	      document.getElementById(ele.id).style.display = "none";
	   }
}


function doSomething(e) {
	if (!e) var e = window.event;
	var tg = (window.event) ? e.srcElement : e.target;
	if (tg.nodeName != 'DIV') return;
	var reltg = (e.relatedTarget) ? e.relatedTarget : e.toElement;
	while (reltg != tg && reltg.nodeName != 'BODY')
		reltg= reltg.parentNode;
	if (reltg== tg) return;
	// Mouseout took place when mouse actually left layer
	// Handle event
}