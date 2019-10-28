package com.wego.web.brd;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Articles {
	private String artseq,image,uid,commants,msg,rating,boardType,title,content;
}
