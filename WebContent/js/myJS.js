window.onload = customize;

function customize(){
	window.document.getElementById('extra').style.display = 'none';
}

function doQuery_getXML()
{
    window.document.getElementById('getXML').style.display = 'none';
    var q_str = document.getElementById('getXMLid').value; 
    var url = '/publications/basic';
    doAjax(url,q_str,'doQuery_back','get',0);
}

function doQuery_getJson()
{
    window.document.getElementById('getJson').style.display = 'none';
    var q_str = document.getElementById('getJsonid').value;
    doAjax('/publications/json',q_str,'doQuery_back','get',0);
}

function doQuery_getText()
{
    window.document.getElementById('getText').style.display = 'none';
    var q_str = document.getElementById('getTextid').value;
    doAjax('/publications/text',q_str,'doQuery_back','get',0);
}

function doQuery_getByKey()
{
    window.document.getElementById('getByKey').style.display = 'none';
    var q_str = 'id='+document.getElementById('getByKeyByid').value;
    doAjax('/publications/keys/{id}',q_str,'doQuery_back','post',0);
}

function doQuery_postJson()
{
    window.document.getElementById('postJson').style.display = 'none';
    var id = 'id='+document.getElementById('nameCreateNewPost').value;
    var title = 'title='+document.getElementById('titleCreateNewPost').value;
    var subject = 'subject='+document.getElementById('subjectCreateNewPost').value;
    var author = 'author='+document.getElementById('authorCreateNewPost').value;
    
    var q_str = id+title+subject+author;
    var url = '/publications/new';
   	
    doAjax(url,q_str,'doQuery_back','post',0);
}


function doQuery_updateJson()
{
    window.document.getElementById('updateJson').style.display = 'none';
    var id = 'id='+document.getElementById('nameUpdateNewPost').value;
    var title = 'title='+document.getElementById('titleUpdateNewPost').value;
    var subject = 'subject='+document.getElementById('subjectUpdateNewPost').value;
    var author = 'author='+document.getElementById('authorUpdateNewPost').value;
    
    var q_str = id+title+subject+author;
   	
    doAjax('/publications/updateExisting',q_str,'doQuery_back','post',0);
}


function doQuery_deleteJson()
{
    window.document.getElementById('deleteJson').style.display = 'none';
    var id = 'id='+document.getElementById('nameDeletePost').value;
   
    var q_str = id+title+subject+author;
   	
    doAjax('/publications/delete',q_str,'doQuery_back','post',0);
}


function doQuery_back(result)
{
	if (result.substring(0,5)=='error'){
	   window.document.getElementById('extra').style.display = 'block';
	   window.document.getElementById('extra').innerHTML="<p style='color:red;'><b>"+result.substring(6)+"</b></p>";
   }else{

	   window.document.getElementById('extra').style.display = 'block';
	   window.document.getElementById('extra').value=""+result;

   }
}
