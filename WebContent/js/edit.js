window.onload = function() {
	tableI();
};
function deleteTips(id) {
	if (confirm("确定删除？")) {
		window.location.href = "NewsDelete?id=" + id;
	}
}
function editOkOnclick(id, obj) {
	var type = obj.parentNode.previousElementSibling.previousElementSibling.previousElementSibling.firstElementChild;
	var title = obj.parentNode.previousElementSibling.previousElementSibling.firstElementChild;
	var date = obj.parentNode.previousElementSibling.firstElementChild;
	
	obj.previousSibling.style.display = 'inline-block';
	obj.style.display = 'none';
	
	var newsType = type.value;
	var newsTitle = title.value;
	var newsDate = date.value;
	
	window.location.href = "NewsUpdata?id=" + id +"&newsType=" + newsType + "&newsTitle=" + newsTitle + "&newsDate=" + newsDate;
}
function tableI() {
	var newsTable = document.getElementById('newsTable');
	var TableTr = newsTable.children[0].children;
	var edit = document.getElementsByClassName('edit');
	var editOk = document.getElementsByClassName('editOk');
	for (let i = 0; i < edit.length; i++) {
		edit[i].onclick = function() {
			edit[i].style.display = 'none';
			editOk[i].style.display = 'inline-block';
			TableTr[i + 1].cells[0].innerHTML = '<input id="type' + i
					+ '" type="text" value="'
					+ TableTr[i + 1].cells[0].children[0].innerHTML + '"/>';
			var type = document.getElementById('type' + i);

			TableTr[i + 1].cells[1].innerHTML = '<input id="title' + i
					+ '" type="text" value="'
					+ TableTr[i + 1].cells[1].innerHTML + '"/>';
			var title = document.getElementById('title' + i);

			TableTr[i + 1].cells[2].innerHTML = '<input id="date' + i
					+ '" type="text" value="'
					+ TableTr[i + 1].cells[2].innerHTML + '"/>';
			var date = document.getElementById('date' + i);

			/*editOk[i].onclick = function() {
				edit[i].style.display = 'inline-block';
				editOk[i].style.display = 'none';
				TableTr[i + 1].cells[0].innerHTML = '<span>' + type.value
						+ '</span>';
				TableTr[i + 1].cells[1].innerHTML = title.value;
				TableTr[i + 1].cells[2].innerHTML = date.value;
			}*/
		}
	}
}

function tableAT() {
	var newsTable = document.getElementById('newsTable');
	var TableTr = newsTable.children[0].children;
	var trNodeNew = newsTable.insertRow(TableTr.length);
	for (let i = 0; i < 3; i++) {
		trNodeNew.insertCell(i);
		trNodeNew.cells[i].innerHTML = '&nbsp;';
	}
	trNodeNew.cells[0].innerHTML = '<span>&nbsp;</span>';
	trNodeNew.insertCell(3);
	trNodeNew.cells[3].innerHTML = '<img src="img/edit.png" class="edit"><img class="editOk" src="img/ok.png">&nbsp;&nbsp;<img class="delete1" src="img/delete.png">';
	tableI();
	tableD();
}
