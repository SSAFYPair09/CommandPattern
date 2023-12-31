function createListHeader() {
	let ihtml = [];
	let idx = 0;
	
	
	ihtml[idx++] = "<table><tr>";
	ihtml[idx++] = "<th>제목</th>";
	ihtml[idx++] = " <th>작성자</th>";
	ihtml[idx++] = " <th>작성일</th>";
	ihtml[idx++] = " <th>조회수</th>";
	ihtml[idx++] = "</tr>";
	
	return ihtml.join("");
}

async function listPost() {
	const root = document.getElementById("root");
	
	root.innerHTML = "";
	
	let ihtml = createListHeader();
	
	let body = {
			sign: "listPost"
	};
	
	body = JSON.stringify(body);
	let json = null;
	await fetch("/CommandPattern/main", { method: "post", body })
		.then((res) => res.text())
		.then((res) => {
			console.log(res);
			json = JSON.parse(res);
		});
	
	let ihtml2 = "";
	for(let elem of json["posts"]) {
		ihtml2 += "<tr>";
		ihtml2 += "<td>" + elem["title"] + "</td>";
		ihtml2 += " <td>" + elem["author"] + "</td>";
		ihtml2 += " <td>" + elem["created_at"] + "</td>";
		ihtml2 += " <td>" + elem["visited"] + "</td>";
		ihtml2 += "</tr>";
	}
	
	root.innerHTML = "<pre>" + ihtml + ihtml2 + "</table></pre>";
}

document.getElementById("listPageLoad").onclick = listPost;