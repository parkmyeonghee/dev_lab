function sendRequest(request, url) {
  request.onreadystatechange = serveDrink;
  request.open("GET", url, true);
  request.send(null);
}

function getSize(){
	var sizeGroup = document.forms[0].size;
	for(i=0;i<sizeGroup.length;i++){
		if(sizeGroup[i].checked == true){
			return sizeGroup[i].value;
		}
	}
}

function getBeverage(){
  var beverageGroup = document.forms[0].beverage;
  for (i=0; i<beverageGroup.length; i++) {
    if (beverageGroup[i].checked == true) {
      return beverageGroup[i].value;
    }
  }  
}

function orderCoffee() {
  var name = document.getElementById("name").value;
  //alert("name : "+name);
  var beverage = getBeverage();
  var size = getSize();

  coffeemakerStatusDiv1 = 
   document.getElementById("coffeemaker1-status");
  var status = getText(coffeemakerStatusDiv1);
  if (status == "Idle") {
	alert("Idle1");
    replaceText(coffeemakerStatusDiv1, "Brewing " + name + "'s " +
                size + " " + beverage);
    document.forms[0].reset();
    var url = "coffeemaker.jsp?name=" + name +
                             "&size=" + size +
                             "&beverage=" + beverage +
                             "&coffeemaker=1";
    sendRequest(request1, url);
  } else {
    coffeemakerStatusDiv2 =
      document.getElementById("coffeemaker2-status");
    status = getText(coffeemakerStatusDiv2);
    if (status == "Idle") {
      replaceText(coffeemakerStatusDiv2, "Brewing " + name + "'s " +
                  size + " " + beverage);
      document.forms[0].reset();
    var url = "coffeemaker.jsp?name=" + name +
                             "&size=" + size +
                             "&beverage=" + beverage +
                             "&coffeemaker=2";
      sendRequest(request2, url);
    } else {
      alert("Sorry! Both coffee makers are busy. " +
            "Try again later.");
    }
  }
}

function serveDrink() {
	  //serveDrink�� �ֹ��� ������� Ŀ�ǰ� �� �Ǿ������� �˷��ְ� Ŀ�Ǹ���Ŀ�� ���¸�
	  //idle�� ����ϴ�.
  if (request1.readyState == 4) {
    if (request1.status == 200) {
      var response = request1.responseText;
      var whichCoffeemaker = response.substring(0, 1);
      var name = response.substring(1, response.length);
      if (whichCoffeemaker == "1") {
        coffeemakerStatusDiv1 = 
          document.getElementById("coffeemaker1-status");
        replaceText(coffeemakerStatusDiv1, "Idle");
      } else {
        coffeemakerStatusDiv2 = 
          document.getElementById("coffeemaker2-status");
        replaceText(coffeemakerStatusDiv2, "Idle");
      }
      alert(name + ", your coffee is ready!");
      request1 = createRequest();
    } else 
      alert("Error! Request status is " + request1.status);
  } else if (request2.readyState == 4) {
    if (request2.status == 200) {
      var response = request2.responseText;
      var whichCoffeemaker = response.substring(0, 1);
      var name = response.substring(1, response.length);
      if (whichCoffeemaker == "1") {
        coffeemakerStatusDiv1 = 
          document.getElementById("coffeemaker1-status");
        replaceText(coffeemakerStatusDiv1, "Idle");
      } else {
        coffeemakerStatusDiv2 = 
          document.getElementById("coffeemaker2-status");
        replaceText(coffeemakerStatusDiv2, "Idle");
      }
      alert(name + ", your coffee is ready!");
      request2 = createRequest();
    } else 
      alert("Error! Request status is " + request2.status);
  }
}
function replaceText(el, text) {
	  if (el != null) {
		alert("replaceText:"+el);
	    clearText(el);
	    var newNode = document.createTextNode(text);
	    el.appendChild(newNode);
	  }
	}

	function clearText(el) {
	  if (el != null) {
	    if (el.childNodes) {
	      for (var i = 0; i < el.childNodes.length; i++) {
	        var childNode = el.childNodes[i];
	        el.removeChild(childNode);
	      }
	    }
	  }
	}

	function getText(el) {
	  var text = "";
	  if (el != null) {
	    if (el.childNodes) {
	      for (var i = 0; i < el.childNodes.length; i++) {
	        var childNode = el.childNodes[i];
	        if (childNode.nodeValue != null) {
	          text = text + childNode.nodeValue;
	        }
	      }
	    }
	  }
	  return text;
	}