"use strict";
function Session(x) {
	sessionStorage.setItem('ctx',x);
	sessionStorage.setItem('css',x+'/resources/css');
	sessionStorage.setItem('img',x+'/resources/img');
	sessionStorage.setItem('js',x+'/resources/js');
	return{
		ctx : ()=>{return sessionStorage.getItem('ctx');},
		js : ()=>{return sessionStorage.getItem('js');},
		css : ()=>{return sessionStorage.getItem('css');},
		img : ()=>{return sessionStorage.getItem('img');}
	}
	}
function User(u) {
	sessionStorage.setItem('uid',u.uid);
	sessionStorage.setItem('uname',u.uname);
	return{
		uid : ()=>{return sessionStorage.getItem('uid');},
		uname : ()=>{return sessionStorage.getItem('uname');}
	
}
}