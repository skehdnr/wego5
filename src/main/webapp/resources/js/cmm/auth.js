"use strict";
var auth = auth || {}
auth = (()=>{
	const WHEN_ERR = '호출하는 JS 파일을 찾지 못했습니다.'
    let _, js, css, img, auth_vue_js, brd_js, router_js, cookie_js, adm_js
    let init =()=>{
    	_ = $.ctx()
		js = $.js()
		css = $.css()
		img = $.img()
        auth_vue_js = js+'/vue/auth_vue.js'
        brd_js = js+'/brd/brd.js'
        router_js = js + '/cmm/router.js'
        cookie_js = js + '/cmm/cookie.js'
        adm_js = js+'/adm/adm.js'
        
    }
    let onCreate =()=>{
        init()
        $.when(
        $.getScript(auth_vue_js),
        $.getScript(router_js),
        $.getScript(brd_js),
        $.getScript(cookie_js),
        $.getScript(adm_js)
        )
        .done(()=>{
           setContentView()
    		$('#a_go_join').click(e=>{
         		e.preventDefault()
	    	$.getScript(auth_vue_js)
	        $('head').html(auth_vue.join_head())
	        $('body').html(auth_vue.join_body())
	        $('#uid').keyup(()=>{
	        	if($('#uid').val().length>1){
	        		$.ajax({
	        	          url : _+'/users/'+$('#uid').val()+'/exist/',
	        	          contentType : 'application/json',
	        	          success : d =>{
	        	            if(d.msg === 'SUCCESS')
	        	            	$('#dupl_check')
	        	            	.val('사용가능한 ID 입니다')
	        	            	.css('color','green')
	        	            else
	        	            	$('#dupl_check')
	        	            	.val('사용중인 ID 입니다')
	        	            	.css('color','red')
	        	          },
	        	        })
	        	}
	        	
	        });
	            $('<button>',{
	                text : '회원가입',
	                href : '#',
	                click : e=>{
	                	e.preventDefault();
	                	join()
	                }
	            })
	            .addClass('btn btn-primary btn-lg btn-block')
	            .appendTo('#btn_join')
    		})
        }).fail(()=>{alert(WHEN_ERR)})
    }
    let setContentView =()=>{
    	$('head').html(auth_vue.login_head({css: $.css(), img: $.img()}))
        $('body').addClass('text-center')
        .html(auth_vue.login_body({css: $.css(), img: $.img()}))
        $('#uid').val('aaaa')
        $('#pwd').val('aaaa')
    	 login()
    	 access()
    }
    let join =()=>{
    	 let data =  {uid:$('#uid').val(),pwd:$('#pwd').val(),uname:$('#uname').val(),birth:$('#birth').val(),gender:$('#gender').val()
                 ,tel:$('#tel').val(),pettype:$('#pettype').val()}
        $.ajax({
	    	url : _+'/users/',
	    	type : 'POST',
	    	dataType : 'json',
	    	data : JSON.stringify(data),
	    	contentType : 'application/json',
	    	success : d => {
	    		alert('AJAX 성공 아이디: '+d.msg)
	    			if(d.msg === 'SUCCESS'){
	    				$('head').html(auth_vue.login_head({css: $.css(), img: $.img()}))
	    		        $('body').addClass('text-center')
	    		        .html(auth_vue.login_body({css: $.css(), img: $.img()}))
	    				login()
	    			}else
	    				alert('회원가입 실패')
	    	},
	    	error : e => {
	    		alert('AJAX 실패');
	    	}
    	})
    }
    let login =()=>{
        $('<button>',{
        	text : "로그인",
        	click : e => {
        		e.preventDefault()
		        $.ajax({
		          url : _+'/users/'+$('#uid').val(),
		          type : 'POST',
		          data : JSON.stringify({uid : $('#uid').val(), pwd : $('#pwd').val()}),
		          dataType : 'json',
		          contentType : 'application/json',
		          success: d =>{
		        	 /* $.extend(new User(d))*/
		        	  setCookie("USERID",d.uid)
          			  brd.onCreate()
      			},
		          error : e => {
			    	alert('Loign AJAX 실패');
		          }
		        })
        	}
        })
        .addClass("btn btn-lg btn-primary btn-block")
        .appendTo('#btn_login')
    }
    let mypage =(d)=>{ 
    	let x = {
    			uid : d.uid,
                pwd : d.pwd,
                uname : d.uname,
                birth : d.birth,
                gender : d.gender,
                tel : d.tel,
                pettype : d.pettype
    	}
    	$('head').html(auth_vue.mypage_head(x))
        $('body').html(auth_vue.mypage_body(x))
    }
    let existId = x=>{
    	$.ajax({
    		url : _+'/users/'+x+'/exist',
	    	type : 'GET',
	    	contentType : 'application/json',
	    	success : d => {
	    			if(d.msg === 'SUCCESS'){
	    				alert('가입 가능 아이디 입니다.')
	    			}else{
	    				alert('이미 존재하는 아이디 입니다.')
    				}
	    	}
    	})
    }
    let brd_home = ()=>{
    	$.getScript(brd_vue_js).done(()=>{
    		$('head').html(brd_vue.brd_head())
        	$('body')
        	.addClass('text-center')
        	.html(brd_vue.brd_body())
    	})
    }
    let access = () =>{
    	$('#a_go_admin').click(()=>{
    		admin.onCreate()
    		/*let ok = confirm('직원전용 입니다')
        	if(ok){
        		let eid = prompt('관리자ID를 입력해 주세요')
        		$.ajax({
        			url : _+'/admins'+$('#eid').val(),
        			type : 'POST',
        			data : {eid : eid , pwd : prompt('비밀번호를 입력해 주세요')},
        			dataType : 'json',
        			contentType : 'application/json',
        			success : d =>{
        				if(d==='SUCCESS'){
        					alert(eid+'님 환영합니다.')
        					admin.onCreate()
        				}else{
        					alert('접근 권한이 없습니다')
        					app.run(_)
        				}
        			},
        			error : e =>{
        				alert('로그인실패')
        			}
        		})
        	}*/	
    	})
    }
    return {onCreate, join, login}
})();