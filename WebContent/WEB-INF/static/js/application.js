

function turnPage(nowPage) 
{
	var urls = window.location.href;
	var site = urls.indexOf("?");
	
	if(site > 0)
	{
		urls = urls.substring(0,site);
	}
	//urls = urls+"?page.nowPage="+nowPage;
	
	urls = urls+"?nowPage="+nowPage;
	var queryJson = document.getElementById("queryJsonStr").value;
//	console.log(queryJson);
	if(queryJson!=null && queryJson!='')
	{
		urls = urls + "&queryJsonStr=" + encodeURIComponent(queryJson);
	}
	
	window.location.href = urls;
}
