$(document).ready(function(){ //문서가 완전히 로드됨, dom 구축 완료(브라우저가 웹페이지 요소들을 완전히 로드, js코드 실행)	
    $('#login-btn').click(function(){
    	console.log('으하하핳');
    	login();
    	return false;
    });
});

function login(){
	var actionUrl = document.querySelector('#loginForm').action;
	const url = new URL(actionUrl).pathname;
	var loginId = document.querySelector('#loginId').value;
	var loginPassword = document.querySelector('#loginPassword').value;
	var custData =  { 'loginId':loginId, 'loginPassword':loginPassword}//JSON형태의 데이터
	var result = "";
	//body: new URLSearchParams -> URL 인코딩된 문자열 형태로 데이터를 전달 + json형식으로 값을 전달 하고 싶다면 Content type 'application/x-www-form-urlencoded;charset=UTF-8'로 설정
	console.log(loginId);
	console.log(loginPassword);

    fetch( url , {
    	method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: //JSON 데이터를 문자열로 변환하여 body에 설정
        	JSON.stringify(custData)
    }).then(function(response){ 
    	console.log("jsonData 전체: " + response);
    	return response.json();  //서버 응답을 JSON 형태로 변환
    })
    .then(function(data) {
    	console.log("resp에서 넘어옴: " +data)
    	result = data.login_result;
    	
    	console.log("result값: "+result); // 성공 시 처리
    
        if (result === "true") {
            console.log("로그인 성공");
            alert("로그인 성공!")
            $("#loginForm").submit();
            
        } else if(result === "false") {
            console.log("로그인 실패");
            alert('로그인 실패!');
        }
    })
    .catch(error => { console.log("무슨일이야ㅜㅠㅜㅠㅜ", error); 
    });	
 }