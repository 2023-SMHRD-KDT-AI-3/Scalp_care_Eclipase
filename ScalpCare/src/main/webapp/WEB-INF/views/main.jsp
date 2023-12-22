<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header" class="alt">
						<a href="index.html" class="logo"><strong>Forty</strong> <span>by HTML5 UP</span></a>
						<nav>
							<!--Ex07. 로그인 한 상태라면 '게시판'버튼과 '개인정보수정', '로그아웃' 버튼을 출력하시오. -->
							<c:if test="${empty user}">
								<!-- 로그인이 되지 않음 -->
								<a href="#menu">로그인</a>							
							</c:if>
							<c:if test="${!empty user}">
								<!-- 로그인이 되었다면 -->
								<a id="goMsg">메세지</a>
								<a href="list">게시판</a>
								<a href="#">로그아웃</a>
							</c:if>
						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">	
						<ul class="links">
							<%--Ex07. 로그인 기능 만들기 : 사용자에게 정보를 입력받아 회원인지 아닌지 조회하는 기능을 만들어 봅시다. --%>
							<li><h5>로그인</h5></li>
								<form action="login" method="post">
									<li><input name="email" type="text"  placeholder="Email을 입력하세요"></li>
									<li><input name="pw" type="password"  placeholder="PW를 입력하세요"></li>
									<li><input type="submit" value="LogIn" class="button fit"></li>
								</form>
						</ul>
						<ul class="actions vertical">
							<%--Ex06. 회원가입 기능 만들기 : 사용자에게 정보를 입력받아 저장하는 기능을 만들어 봅시다. --%>
							<li><h5>회원가입</h5></li>
								<form action="join" method="post">
									<li><input name="email" type="text" placeholder="Email을 입력하세요"></li>
									<li><input name="pw" type="password" placeholder="PW를 입력하세요"></li>
									<li><input name="tel" type="text" placeholder="전화번호를 입력하세요"></li>
									<li><input name="address" type="text" placeholder="집주소를 입력하세요"></li>
									<li><input type="submit" value="JoinUs" class="button fit"></li>
								</form>
						</ul>
					</nav>			
				<!-- Banner -->
					<section id="banner" class="major">
						<div class="inner">
							<header class="major">
								<%--Ex07. 로그인 후 로그인 한 사용자의 세션아이디로 바꾸시오. ex)smart님 환영합니다 --%>
									<c:if test="${empty user}">
										<h1>로그인 한 세션아이디를 출력해주세요</h1>
									</c:if>
									<c:if test="${!empty user}">
										<h1>${user.email}</h1>
									</c:if>
							</header>
							<div class="content">
								<p>아래는 지금까지 배운 웹 기술들입니다.<br></p>
								<ul class="actions">
									<li><a href="#one" class="button next scrolly">확인하기</a></li>
								</ul>
							</div>
						</div>
					</section>

				<!-- Main -->
					<div id="main">

						<!-- One -->
							<section id="one" class="tiles">
								<article>
									<span class="image">
										<img src="images/pic01.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">HTML</a></h3>
										<p>홈페이지를 만드는 기초 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic02.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">CSS</a></h3>
										<p>HTML을 디자인해주는 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic03.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Servlet/JSP</a></h3>
										<p>Java를 기본으로 한 웹 프로그래밍 언어/스크립트 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic04.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">JavaScript</a></h3>
										<p>HTML에 기본적인 로직을 정의할 수 있는 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic05.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">MVC</a></h3>
										<p>웹 프로젝트 중 가장 많이 사용하는 디자인패턴</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic06.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Web Project</a></h3>
										<p>여러분의 최종프로젝트에 웹 기술을 활용하세요!</p>
									</header>
								</article>
							</section>
					<!-- Two -->
							<section id="two">
								<div class="inner" id="msgDiv">
									<header class="major">
										<h2>메세지 확인하기</h2>
									</header>
									<%-- chatting 기능을 만들어 봅시다! --%>
									<div class="container chat">
									
										<div class="other">
											<p>보낸사람 이름 :</p>
											<p>다른사람에게서 온 메세지</p>
										</div>
										
										<div class="mychat">
											<p>내가보낸 채팅</p>
										</div>
										
										<div class="other">
											<p>보낸사람 이름2 :</p>
											<p>다른사람에게서 온 메세지2</p>
										</div>
										
										
									</div>
									<%-- 채팅창 끝! --%>
								</div>
							</section>

					</div>

				<!-- Contact -->
					<section id="contact">
						<div class="inner">
							<section>
								<form>
									<div class="field">
										<label for="message">Message</label>
										<textarea  id="message" rows="6"></textarea>
									</div>
									<ul class="actions">
										<li><input id="sendBtn" type="button" value="Send Message" class="special" /></li>
										<li><input type="reset" value="Clear" /></li>
									</ul>
								</form>
							</section>
							
							<%--Ex07. 로그인 한 사용자의 정보로 변경해 봅시다. --%>
							<section class="split">
								<section>
									<div class="contact-method">
										<span class="icon alt fa-envelope"></span>
										<h3>Email</h3>
										<a id="user" href="#">${user.email}</a>
										<!-- 로그인 한 사용자의 이메일을 출력하시오 -->
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon alt fa-phone"></span>
										<h3>Phone</h3>
										<span>${user.tel}</span>
										<!-- 로그인 한 사용자의 전화번호를 출력하시오 -->
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon alt fa-home"></span>
										<h3>Address</h3>
										<span>${user.address}</span>
										<!-- 로그인 한 사용자의 집주소를 출력하시오 -->
									</div>
								</section>
							</section>					
						</div>
					</section>

				<!-- Footer -->
					<footer id="footer">
						<div class="inner">
							<ul class="icons">
								<li><a href="#" class="icon alt fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon alt fa-facebook"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon alt fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a href="#" class="icon alt fa-github"><span class="label">GitHub</span></a></li>
								<li><a href="#" class="icon alt fa-linkedin"><span class="label">LinkedIn</span></a></li>
							</ul>
							<ul class="copyright">
								<li>&copy; Untitled</li><li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
			<!-- 로그인 했을 때만 chat.js를 적용 -->
			<c:if test="${!empty user}">
				<script src="assets/js/chat.js"></script>
			</c:if>
			<script type="text/javascript">
				/* 혹시모를 에러를 방지하기 위해 문서가 모두 준비가 되면 함수 실행 */
				$(document).ready(function(){
					$("#goMsg").on("click", scrollMsg)	
					
				})
			
				function scrollMsg(){
					
					// 메세지 확인하기 div의 위치 정보
					// .offset() : div의 위치정보를 가져올 수 있다.
					let offset = $("#msgDiv").offset();
					
					// div의 위치로 스크롤 이동
					// $('html').css(scrollTop, offset.top);
					// .animate({스타일속성명 : 값}, 애니메이션 시간(단위 : ms))
					$('html').animate({"scrollTop" : offset.top}, 400);
					
				}
			
			</script>
	</body>
</html>

