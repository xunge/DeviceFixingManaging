	 function goPage(pos)
	 {
		 var page=document.getElementById("page");
		 page.value=pos;
		 document.forms[1].submit();
	 }	  
	function doQuery()   //提交表单
		{
				document.forms[1].submit();
		}

		function goPagePrev(p) {
			var page = document.getElementById("page");
			var integer = parseInt(p);
			integer--;
			page.value = integer;


			document.forms[1].submit();
		}


		function goPageNext(p) {
			var page = document.getElementById("page");
			var integer = parseInt(p);
			integer++;
			page.value = integer;
			document.forms[1].submit();
		}