var auth_vue = auth_vue || {}
auth_vue = {
	join_head:()=>{
		return '<head>'+
        '    <meta charset="utf-8">'+
        '    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">'+
        '    <meta name="description" content="">'+
        '    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">'+
        '    <meta name="generator" content="Jekyll v3.8.5">'+
        '    <title>Checkout example · Bootstrap</title>'+
        '    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/checkout/">'+
        '    <!-- Bootstrap core CSS -->'+
        '<link href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">'+
        '    <style>'+
        '      .bd-placeholder-img {'+
        '        font-size: 1.125rem;'+
        '        text-anchor: middle;'+
        '        -webkit-user-select: none;'+
        '        -moz-user-select: none;'+
        '        -ms-user-select: none;'+
        '        user-select: none;'+
        '      }'+
        '      @media (min-width: 768px) {'+
        '        .bd-placeholder-img-lg {'+
        '          font-size: 3.5rem;'+
        '        }'+
        '      }'+
        '    </style>'+
        '    <!-- Custom styles for this template -->'+
        '    <link href="https://getbootstrap.com/docs/4.3/examples/checkout/form-validation.css" rel="stylesheet">'+
        '  </head>'
	},
	join_body: ()=>{
		return '<div class="container" >'+
        '  <div class="py-5 text-center">'+
        '    <img class="d-block mx-auto mb-4" src="/web/resources/img/wego.png" alt="" width="72" height="72">'+
        '    <h2>WeGo</h2>'+
        '  </div>'+
        '  <div class="row">'+
        '    <div class="col-md-4 order-md-2 mb-4">'+
        '      <h4 class="d-flex justify-content-between align-items-center mb-3">'+
        '        <span class="text-muted">Your cart</span>'+
        '        <span class="badge badge-secondary badge-pill">3</span>'+
        '      </h4>'+
        '      <ul class="list-group mb-3">'+
        '        <li class="list-group-item d-flex justify-content-between lh-condensed">'+
        '          <div>'+
        '            <h6 class="my-0">Product name</h6>'+
        '            <small class="text-muted">Brief description</small>'+
        '          </div>'+
        '          <span class="text-muted">$12</span>'+
        '        </li>'+
        '        <li class="list-group-item d-flex justify-content-between lh-condensed">'+
        '          <div>'+
        '            <h6 class="my-0">Second product</h6>'+
        '            <small class="text-muted">Brief description</small>'+
        '          </div>'+
        '          <span class="text-muted">$8</span>'+
        '        </li>'+
        '        <li class="list-group-item d-flex justify-content-between lh-condensed">'+
        '          <div>'+
        '            <h6 class="my-0">Third item</h6>'+
        '            <small class="text-muted">Brief description</small>'+
        '          </div>'+
        '          <span class="text-muted">$5</span>'+
        '        </li>'+
        '        <li class="list-group-item d-flex justify-content-between bg-light">'+
        '          <div class="text-success">'+
        '            <h6 class="my-0">Promo code</h6>'+
        '            <small>EXAMPLECODE</small>'+
        '          </div>'+
        '          <span class="text-success">-$5</span>'+
        '        </li>'+
        '        <li class="list-group-item d-flex justify-content-between">'+
        '          <span>Total (USD)</span>'+
        '          <strong>$20</strong>'+
        '        </li>'+
        '      </ul>'+
        '      <form class="card p-2">'+
        '        <div class="input-group">'+
        '          <input type="text" class="form-control" placeholder="Promo code">'+
        '          <div class="input-group-append">'+
        '            <button type="submit" class="btn btn-secondary">Redeem</button>'+
        '          </div>'+
        '        </div>'+
        '      </form>'+
        '    </div>'+
        '    <div class="col-md-8 order-md-1">'+
        '      <h4 class="mb-3">회원 가입</h4>'+
        '      <form class="needs-validation" novalidate="">'+
        '        <div class="row">'+
        '          <div class="col-md-6 mb-3">'+
        '            <label for="uid">아이디</label>'+
        '            <input type="text" class="form-control" id="uid" placeholder="최대 3글자" value="" required="">'+
        '            <div class="invalid-feedback">'+
        '              Valid first name is required.'+
        '            </div>'+
        '          </div>'+
        '          <div class="col-md-6 mb-3">'+
        '            <label for="dupl_check">ID 중복체크 </label>'+
        '            <input type="text" class="form-control" id="dupl_check" placeholder="" value="" required="">'+
        '            <div class="invalid-feedback">'+
        '              Valid last name is required.'+
        '            </div>'+
        '          </div>'+
        '        </div>'+
        '        <div class="mb-3">'+
        '          <label for="pwd">비밀번호</label>'+
        '          <div class="input-group">'+
        '            <div class="input-group-prepend">'+
        '            </div>'+
        '            <input type="text" class="form-control" id="pwd" placeholder="" required="">'+
        '            <div class="invalid-feedback" style="width: 100%;">'+
        '              Your username is required.'+
        '            </div>'+
        '          </div>'+
        '        </div>'+
        '        <div class="mb-3">'+
        '          <label for="uname">이름 <span class="text-muted"></span></label>'+
        '          <input type="text" class="form-control" id="uname" placeholder="">'+
        '          <div class="invalid-feedback">'+
        '            Please enter a valid email address for shipping updates.'+
        '          </div>'+
        '        </div>'+
        '        <div class="mb-3">'+
        '          <label for="birth">생일</label>'+
        '          <input type="text" class="form-control" id="birth" placeholder="" required="">'+
        '          <div class="invalid-feedback">'+
        '            Please enter your shipping address.'+
        '          </div>'+
        '        </div>'+
        '        <div class="mb-3">'+
        '          <label for="gender">성별 <span class="text-muted"></span></label>'+
        '          <input type="text" class="form-control" id="gender" placeholder="">'+
        '        </div>'+
        '        <div class="row">'+
        '          <div class="col-md-5 mb-3">'+
        '            <label for="tel">연락처</label>'+
        '             <input type="text" class="form-control" id="tel" placeholder="">'+
        '            </select>'+
        '            <div class="invalid-feedback">'+
        '              Please select a valid country.'+
        '            </div>'+
        '          </div>'+
        '          <div class="col-md-4 mb-3">'+
        '            <div class="invalid-feedback">'+
        '              Please provide a valid state.'+
        '            </div>'+
        '          </div>'+
        '          <div class="col-md-3 mb-3">'+
        '            <label for="pettype">반려동물종류</label>'+
        '            <input type="text" class="form-control" id="pettype" placeholder="" required="">'+
        '            <div class="invalid-feedback">'+
        '              Zip code required.'+
        '            </div>'+
        '          </div>'+
        '        </div>'+
        '        <hr class="mb-4">'+
        '        <hr class="mb-4">'+
        '        <h4 class="mb-3">Payment</h4>'+
        '       <div class="d-block my-3">'+
        '          <div class="custom-control custom-radio">'+
        '            <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked="" required="">'+
        '            <label class="custom-control-label" for="credit">Credit card</label>'+
        '          </div>'+
        '          <div class="custom-control custom-radio">'+
        '            <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required="">'+
        '            <label class="custom-control-label" for="debit">Debit card</label>'+
        '          </div>'+
        '          <div class="custom-control custom-radio">'+
        '            <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required="">'+
        '            <label class="custom-control-label" for="paypal">PayPal</label>'+
        '          </div>'+
        '        </div>'+
        '        <div class="row">'+
        '          <div class="col-md-6 mb-3">'+
        '            <label for="cc-name">Name on card</label>'+
        '            <input type="text" class="form-control" id="cc-name" placeholder="" required="">'+
        '            <small class="text-muted">Full name as displayed on card</small>'+
        '            <div class="invalid-feedback">'+
        '              Name on card is required'+
        '            </div>'+
        '          </div>'+
        '          <div class="col-md-6 mb-3">'+
        '            <label for="cc-number">Credit card number</label>'+
        '            <input type="text" class="form-control" id="cc-number" placeholder="" required="">'+
        '            <div class="invalid-feedback">'+
        '              Credit card number is required'+
        '            </div>'+
        '          </div>'+
        '        </div>'+
        '        <div class="row">'+
        '          <div class="col-md-3 mb-3">'+
        '            <label for="cc-expiration">Expiration</label>'+
        '            <input type="text" class="form-control" id="cc-expiration" placeholder="" required="">'+
        '            <div class="invalid-feedback">'+
        '              Expiration date required'+
        '            </div>'+
        '          </div>'+
        '          <div class="col-md-3 mb-3">'+
        '            <label for="cc-cvv">CVV</label>'+
        '            <input type="text" class="form-control" id="cc-cvv" placeholder="" required="">'+
        '            <div class="invalid-feedback">'+
        '              Security code required'+
        '            </div>'+
        '          </div>'+
        '        </div>'+
        '        <hr class="mb-4">'+
        '        <div id="btn_join"></div>'+
        '      </form>'+
        '    </div>'+
        '  </div>'+
        '  <footer class="my-5 pt-5 text-muted text-center text-small">'+
        '    <p class="mb-1">WeGo</p>'+
        '    <ul class="list-inline">'+
        '      <li class="list-inline-item"><a href="#">Privacy</a></li>'+
        '      <li class="list-inline-item"><a href="#">Terms</a></li>'+
        '      <li class="list-inline-item"><a href="#">Support</a></li>'+
        '    </ul>'+
        '  </footer>'+
        '</div>'
	},
	login_head : x=>{
		return '  <meta charset="UTF-8">'+
		'  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">'+
		'  <title>Document</title>'+
		'  <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/checkout/">'+
		'  <head>  '+
		 '<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">'+
		'  <link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">'+
		'    <meta charset="utf-8">'+
		'    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">'+
		'    <meta name="description" content="">'+
		'    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">'+
		'    <meta name="generator" content="Jekyll v3.8.5">'+
		'    <title>Signin Template · Bootstrap</title>'+
		'    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sign-in/">'+
		'    <!-- Bootstrap core CSS -->'+
		'    <style>'+
		'      .bd-placeholder-img {'+
		'        font-size: 1.125rem;'+
		'        text-anchor: middle;'+
		'        -webkit-user-select: none;'+
		'        -moz-user-select: none;'+
		'        -ms-user-select: none;'+
		'        user-select: none;'+
		'      }'+
		'      @media (min-width: 768px) {'+
		'        .bd-placeholder-img-lg {'+
		'          font-size: 3.5rem;'+
		'        }'+
		'      }'+
		'    </style>'+
		'    <!-- Custom styles for this template -->'+
		'    <link href="/web/resources/css/signin.css" rel="stylesheet">'+
		'  </head>'
	},
	login_body : x=>{
		return ' <form id = "form_join" class="form-signin">'+
		'    <img class="mb-4" src="/web/resources/img/bootstrap-solid.svg" alt="" width="72" height="72">'+
		'    <h1 class="h3 mb-3 font-weight-normal">로그인</h1>'+
		'    <label for="inputEmail" class="sr-only">Email address</label>'+
		'    <input type="text" id="uid" class="form-control" placeholder="Email address" required="" autofocus="">'+
		'    <label for="inputPassword" class="sr-only">Password</label>'+
		'    <input type="password" id="pwd" class="form-control" placeholder="Password" required="">'+
		'    <div class="checkbox mb-3">'+
		'      <label>'+
		'      <a id = "a_go_join" href="#">회원가입</a>'+
		'      </label>'+
		'      <label>'+
		'      <a id = "a_go_admin" href="#">관리자모드</a>'+
		'      </label>'+
		'    </div>'+
		'    <div id="btn_login"></div>'+
		'    <p class="mt-5 mb-3 text-muted">WeGo</p>'+
		'  </form>'
	
	},
	mypage_head : x=>{
		return '<meta charset="UTF-8">'+
		'  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">'+
		'  <title>Document</title>'+
		'  <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/checkout/">'+
		'  <head>  '+
		 '<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">'+
		'  <link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">'+
		'    <meta charset="utf-8">'+
		'    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">'+
		'    <meta name="description" content="">'+
		'    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">'+
		'    <meta name="generator" content="Jekyll v3.8.5">'+
		'    <title>Signin Template · Bootstrap</title>'+
		'    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sign-in/">'+
		'    <!-- Bootstrap core CSS -->'+
		'    <style>'+
		'      .bd-placeholder-img {'+
		'        font-size: 1.125rem;'+
		'        text-anchor: middle;'+
		'        -webkit-user-select: none;'+
		'        -moz-user-select: none;'+
		'        -ms-user-select: none;'+
		'        user-select: none;'+
		'      }'+
		'      @media (min-width: 768px) {'+
		'        .bd-placeholder-img-lg {'+
		'          font-size: 3.5rem;'+
		'        }'+
		'      }'+
		'    </style>'+
		'    <!-- Custom styles for this template -->'+
		'    <link href="https://getbootstrap.com/docs/4.3/examples/checkout/form-validation.css" rel="stylesheet">'+
		'  </head>'
	},
	mypage_body : x=>{
		return '<body class="d-flex flex-column h-100">'+
		'<main role="main" class="flex-shrink-0">'+
		'  <div class="container">'+
		'    <h1 class="mt-5">MyPage</h1>'+
		'    <p class="lead">아이디 : '+x.uid+'</p>'+
		'    <p>비밀번호 : '+ x.pwd+'</p>'+
		'    <p>이름 : '+x.uname+'</p>'+
		'    <p>생년월일 : '+x.birth+'</p>'+
		'    <p>성별 : '+x.gender+'</p>'+
		'    <p>연락처 : '+x.tel+'</p>'+
		'    <p>반려동물 종류 : '+x.pettype+'</p>'+
		'  </div>'+
		'</main>'+
		'</body>'
	}
};