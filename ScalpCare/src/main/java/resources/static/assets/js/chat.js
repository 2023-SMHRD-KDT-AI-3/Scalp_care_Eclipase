// 채팅 만들기

// 1. 필요한 HTML 요소 가져오기
const chatting = $('div.container.chat');
const message = $("#message");
const sendBtn = $("#sendBtn");

// 2. 데이터 양식 만들기
const username = $("#user").html();

// Gson으로 보내기 위한 양식 만들어 두기
let chat = {
	"email" : username,
	"chat" : "",
};

// 3. WebSocket과 연결
// WebSocket과 정상적으로 연결 되었을 때 실행
function onOpen(){
	console.log("연결성공!");
}

// WebSocket과의 연결이 끊어졌을 때 실행
function onClose(){
	console.log("연결종료!");
}

// Message를 전달 받았을 때 실행
function onMessage(msg){
	// msg : 전달 받은 메세지가 담기는 객체
	// msg.data → json형태의 객체로 넘어옴
	console.log(msg.data);	
	
	// json → javascript 객체
	var json = JSON.parse(msg.data);
	
	otherChatting(json);
}


// WebSocket 객체 생성하기(연결하기)
// new WebSocket("WebSocket을 연결하기 위한 URL") → "ws://~~~"
const socket = new WebSocket("ws://localhost:8089/chat") // ChatConfig에서 지정한 URLMapping
// 이벤트 설정
socket.onopen = onOpen;
socket.onclose = onClose;
socket.onmessage = onMessage;

// 4. JSP 페이지의 채팅내용 초기화 해주기
loadChat();
 
function loadChat(){
	
	// 1) 예시 내용 지우기
	chatting.html("");
	
	// 2) 이전의 채팅 내용 불러오기(비동기 통신)
	// ajax를 이용해서 요청
}

// 5. 채팅(메세지) 보내기
sendBtn.on("click",send)

function send(){
	
	// 1) 메세지 포맷 완성하기
	chat.chat = message.val();
	
	var json = JSON.stringify(chat); // Javascript Object → JSON String
	
	// 2) 메세지 전송
	socket.send(json);
	message.val(""); // 메세지창 초기화
	
	// 3) 내 채팅 출력하기
	myChatting(chat);	
	
}

function myChatting(data){
	
	// 1) 집어넣을 div 코드 만들기
	var div = `
		<div class="mychat">
			<p>${data.chat}</p>
		</div>
	`;
	
	// 2) chatting에 div를 추가
	chatting.append(div);
	
	// 3) chatting scroll 항상 맨 밑으로 유지
	// .scrollTop("위치") → 스크롤의 윗부분을 "위치"에 맞춘다.
	// .chatting[0].scrollHeight → 채팅의 [0]번째(맨 밑)의 scrollHeight(스크롤높이)에 맞춘다.
	chatting.scrollTop(chatting[0].scrollHeight);
}
	
function otherChatting(data){
	
	// 1) 집어넣을 div 코드 만들기
	var div = `
		<div class="other">
			<p>${data.email} : </P>
			<p>${data.chat}</p>
		</div>
	`;
	
	// 2) chatting에 div를 추가
	chatting.append(div);
	
	// 3) chatting scroll 항상 맨 밑으로 유지
	// .scrollTop("위치") → 스크롤의 윗부분을 "위치"에 맞춘다.
	// .chatting[0].scrollHeight → 채팅의 [0]번째(맨 밑)의 scrollHeight(스크롤높이)에 맞춘다.
	chatting.scrollTop(chatting[0].scrollHeight);
	}


