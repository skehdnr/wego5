"use strict"
var brd = brd ||{}
brd = (()=>{
	let _, js, brd_vue_js
	let init =()=>{
		_ = $.ctx()
        js = $.js()
        brd_vue_js = js+'/vue/brd_vue.js'
	}
	let onCreate=()=>{
		init()
		setContentView()
	}
	let setContentView=()=>{
		$.getScript(brd_vue_js,()=>{
			$('head').html(brd_vue.brd_head({css: $.css(), img: $.img()}))
	        $('body').addClass('text-center')
	        .html(brd_vue.brd_body({css: $.css(), img: $.img()}))
		})
	}
	return {onCreate}
})()