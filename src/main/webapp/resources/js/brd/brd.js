"use strict"
var brd = brd||{}
brd = (()=>{
	let _, js, brd_vue_js, $userid
	let init =()=>{
		 _ = $.ctx()
        js = $.js()
        brd_vue_js = js+'/vue/brd_vue.js'
        $userid = $.user()
	}
	let onCreate = () =>{
		init()
		$.getScript(brd_vue_js).done(()=>{
			setContentView()
			$('<a>',{
	        	href : '#',
	        	click : e=>{
		        	e.preventDefault()
		        	write()
	        },
	        text : '글쓰기'
		})
		.addClass('nav-item')
		.appendTo('#go_write')
	})
		
	}
	let setContentView=(d)=>{
			$('head').html(brd_vue.brd_head({css: $.css(), img: $.img()}))
	        $('body').addClass('text-center')
	        .html(brd_vue.brd_body(d))
	        $('#recent_updates .media').remove()
	        $('#recent_updates .d-block').remove()
	        $('#recent_updates').append('<h1>등록된 글이 없습니다.</h1>')
	}
	/*+' <input type="reset" class="btn btn-danger" style="float:right;width:100px;margin-right:10px" value="CANCEL"/>'
	+'<input name="write" type="submit" class="btn btn-primary" style="float:right;width:100px;margin-right:10px" value="SUBMIT"/>'*/
	let write=()=>{
		alert('글쓰기클릭')
		$('#recent_updates').html(brd_vue.brd_write())
		$('#writer').val($userid)
		$('#suggestions').remove()
		/*$('<button>',{
			text : '글쓰기',
			click : e =>{
				e.preventDefault();
				alert('글쓰기 성공')
			}
		}).addClass("btn btn-danger")
          .appendTo('#btn_write')*/
		$('<input>',{
			style:"float:right;width:100px;margin-right:10px",
			value:"취소"
		}).addClass("btn btn-danger")
          .appendTo('#write_form')
          .click(()=>{
        	  
          })
        $('<input>',{
        	type:"submit",
        	style:"float:right;width:100px;margin-right:10px",
        	value:"글쓰기"
        }).addClass("btn btn-primary")
          .appendTo('#write_form')
          .click(()=>{
        	$.ajax ({
        		url : _+'/articles/',
        		type : '',
        		data : JSON.stringify(data),
        		dataType : 'json',
        		contentType : 'application/json',
        		success : ()=>{},
        		error : ()=>{}
        	})
          })
	}
	return {onCreate}
})()