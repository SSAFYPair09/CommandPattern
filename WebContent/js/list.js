function createListHeader() {
	let ihtml = [];
	let idx = 0;
	
	
	ihtml[idx++] = "<tr>";
	ihtml[idx++] = "<th>제목</th>";
	ihtml[idx++] = "<th>작성자</th>";
	ihtml[idx++] = "<th>작성일</th>";
	ihtml[idx++] = "<th>조회수</th>";
	ihtml[idx++] = "</tr>";
	
	return ihtml.join("");
}

window.onload = async () => {
	const root = document.getElementById("root");
	
	root.innerHTML = "";
	
	let ihtml = createListHeader();
	
	let body = {
			sign: "listPost"
	};
	
	let json = null;
	await fetch("/main", {method: "post", body})
	.then((res) => res.text())
	.then((res) =>
		json = JSON.parse(res);
	);
	
	let ihtml2 = "";
	for(let elem in json) {
		ihtml2 += "<tr>";
		ihtml2 += "<td>" + json["title"] + "</td>";
		ihtml2 += "<td>" + json["author"] + "</td>";
		ihtml2 += "<td>" + json["created_at"] + "</td>";
		ihtml2 += "<td>" + json["visited"] + "</td>";
		ihtml2 += "</tr>";
	}
	
	root.innerHTML = ihtml + ihtml2;
}

