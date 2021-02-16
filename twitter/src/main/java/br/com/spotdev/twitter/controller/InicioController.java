package br.com.spotdev.twitter.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class InicioController {

	@GetMapping("/executar")
	public ResponseEntity<String> inicio()  {
		File arquivo = new File("log_java.txt");
		if (!arquivo.exists()) {
			try {
				arquivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		List<String> log = new ArrayList<>();
		try {
			Document doc2 = Jsoup.connect("https://twitter.com/i/api/2/search/adaptive.json?include_profile_interstiti"
					+ "al_type=1&include_blocking=1&include_blocked_by=1&include_followed_by=1&incl"
					+ "ude_want_retweets=1&include_mute_edge=1&include_can_dm=1&include_can_media_t"
					+ "ag=1&skip_status=1&cards_platform=Web-12&include_cards=1&include_ext_alt_tex"
					+ "t=true&include_quote_count=true&include_reply_count=1&tweet_mode=extended&in"
					+ "clude_entities=true&include_user_entities=true&include_ext_media_color=true&i"
					+ "nclude_ext_media_availability=true&send_error_codes=true&simple_quoted_tweet="
					+ "true&q=luci&tweet_search_mode=live&count=20&query_source=typed_query&pc=1&spel"
					+ "ling_corrections=1&ext=mediaStats%2ChighlightedLabel HTTP/1.1")
					.validateTLSCertificates(false)
				    .header("Host", "twitter.com")
				    .header("Connection", "close")
				    .header("sec-ch-ua", ";Not A Brand\";v=\"99\", \"Chromium\";v=\"88")
				    .header("x-twitter-client-language", "pt")
				    .header("x-csrf-token", "5e1c809263087c01a3ed05e950371463")
				    .header("sec-ch-ua-mobile", "?0")
				    .header("authorization", "Bearer AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA")
				    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36")
				    .header("x-guest-token", "1361807288781185026")
				    .header("x-twitter-active-user", "yes")
				    .header("Accept", "*/*")
				    .header("Sec-Fetch-Site", "same-origin")
				    .header("Sec-Fetch-Mode", "cors")
				    .header("Sec-Fetch-Dest", "empty")
				    .referrer("https://twitter.com/search?q=luci&src=typed_query&f=live")
				    .header("Accept-Encoding", "gzip, deflate")
				    .header("Accept-Language", "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7")
				    .cookie("personalization_id", "v1_FBuaXHaVrwLBpS4nbhT80A==")
				    .cookie("guest_id", "v1%3A161351512341530581")
				    .cookie("ct0", "5e1c809263087c01a3ed05e950371463")
				    .cookie("_sl", "1")
				    .cookie("gt", "1361807288781185026")
				    .cookie("_twitter_sess", "BAh7CSIKZmxhc2hJQzonQWN0aW9uQ29udHJvbGxlcjo"
				    		+ "6Rmxhc2g6OkZsYXNo%250ASGFzaHsABjoKQHVzZWR7ADoPY3JlYXRlZF9h"
				    		+ "dGwrCDsU%252F6x3AToMY3NyZl9p%250AZCIlMTE4Y2YxNTg4MjA1NTA3Y"
				    		+ "WI1NjkwODVkMGQ4OWU1ZTM6B2lkIiU3NTM4%250AZTFhNDExN2Q4NDY3Zj"
				    		+ "ZlZmUwZWY0ODU5NDRmMg%253D%253D--97f35f2cd01823e78485747868"
				    		+ "0af1e29ea8e6c7")
					.cookie("_ga", "GA1.2.350501248.1613515134")
					.cookie("_gid", "GA1.2.1905327451.1613515134")
				    .ignoreContentType(true)
				    .proxy("127.0.0.1", 8080)
				    .ignoreHttpErrors(true)
				    .ignoreContentType(true)
				    .get();
			log.add("inicio");
			System.out.println("ini");
			log.add("> " + doc2.data());
			System.out.println(doc2);
			System.out.println("fim");
			log.add("final");
			Files.write(Paths.get(arquivo.getPath()), log, StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok().body("OK");
	}
}
