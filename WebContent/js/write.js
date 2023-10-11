function createInputBox() {
	let ihtml = [];
	let idx = 0;
	
	ihtml[idx++] = "<div><input id='제목' placeholder='제목'></input></div>";
	ihtml[idx++] = "<div><input id='작성자' placeholder='작성자'></input></div>";
	ihtml[idx++] = "<div><input id='작성일' placeholder='작성일'></input></div>";
	ihtml[idx++] = "<div><input id='조회수' placeholder='조회수'></input></div>";
	ihtml[idx++] = "<div><button id='글쓰기'>글쓰기</button></div>";

	return ihtml.join("");
}

function loadWritePage() {
	const root = document.getElementById("root");
	root.innerHTML = createInputBox();

	document.getElementById('글쓰기').onclick = writePost;
}

async function writePost() {
	let body = {
		sign: "writePost",
		title: document.getElementById('제목').value,
		author: document.getElementById('작성자').value,
		created_at: document.getElementById('작성일').value,
		visited: document.getElementById('조회수').value,

};

body = JSON.stringify(body);
let json = null;
await fetch("/CommandPattern/main", { method: "post", body })
	.then((res) => res.text())
	.then((res) => {
		console.log(res);
		json = JSON.parse(res);
	});

	if (json["success"] == true) {
		root.innerHTML = "<div>추가하였습니다</div>";
	}
	else {
		root.innerHTML = "<div>추가 실패..</div>";
	}
}

document.getElementById("writePageLoad").onclick = loadWritePage;