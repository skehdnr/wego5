package com.wego.web.test;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler2 {
	public static void main(String[] args) {
		try {
			Document rawData = Jsoup.connect("http://www.pensionnara.co.kr/main.php").timeout(10*1000).get();
			Elements artist = rawData.select("[class=nmarea2]");
			List<String> artist2 = new ArrayList<>();
			for (Element e : artist) {
				artist2.add(e.text());
			}
			System.out.println(artist2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
