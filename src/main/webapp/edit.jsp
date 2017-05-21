<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:home>
<jsp:attribute name="header">
	<%-- include ckeditor library --%>
	<script src="//cdn.ckeditor.com/4.6.2/standard/ckeditor.js"></script>
</jsp:attribute>

<jsp:body>
	<style>
		tbody {
			vertical-align: top;
		}
		tbody tr td {
			background-color: #ffffff;
		}
	</style>

	<form>
		<textarea name="editor1" id="editor1" rows="10" cols="100">
                This is my textarea to be replaced with CKEditor.
            </textarea>
            <button id="btnSave">Save</button>
	</form>
<script>
	CKEDITOR.replace('editor1');
	var text = '${text}';
	var editor = CKEDITOR.instances['editor1'];
	editor.setData(text);
	$('#btnSave').click(function (e) {
		e.preventDefault();
		$.post('/upload', {  
			content: $(CKEDITOR.instances['editor1'].getData()).text()
		})
		.done(function (result) {
			alert(result);
			location.reload();
		})
		.fail(function() {
		   	alert( "error" );
		});
		//alert((CKEDITOR.instances['editor1'].getData()).text());
	});
	
	
</script>
</jsp:body>

</t:home>