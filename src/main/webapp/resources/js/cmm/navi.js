var navi = navi ||{}
navi = (()=>{
	const WHEN_ERR = '호출하는 JS 파일을 찾지 못했습니다.'
	let _, js, css,img,auth_vue_js,brd_js,router_js,$userid,navi_vue_js
	let init =x=>{
		_ = x._
	    js = x.js
	    css = x.css
	    img = x.img
        auth_vue_js = js+'/vue/auth_vue.js'
        navi_vue_js = js+'/vue/navi_vue.js'
        brd_js = js+'/brd/brd.js'
        router_js = js+'/cmm/router.js'
        $userid = $.user()
	}
	let onCreate=x=>{
		init(x)
		setContnetView()
	}
	let setContnetView=()=>{
		$('<a>',{
        	href : '#',
        	 text : '글쓰기'
		})
		.addClass('nav-iink')
		.appendTo('#menu_write')
        .click ( e=>{
	        	e.preventDefault()
	        	$.getScript(brd_js,()=>{
	        		brd.write()
	        	})
        })
	
	$('<a>',{
		href : '#',
		text : '로그아웃'
	})
	.addClass('nav-iink')
	.appendTo('#menu_logout')
	.click ( e=>{
	        	e.preventDefault()
	        	$.getScript(brd_js,()=>{
	        		brd.write()
	        	})
        })
	}
	return{onCreate}
	
})()