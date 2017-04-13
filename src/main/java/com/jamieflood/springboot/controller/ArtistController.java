package com.jamieflood.springboot.controller;

import java.io.IOException;

import org.apache.commons.lang3.text.WordUtils;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArtistController {

	private final Logger logger = LoggerFactory.getLogger(ArtistController.class);
	
	private final static String WIKIPEDIA = "http://en.wikipedia.org/wiki/";
	private final static String DISCLAIMER_MESSAGE = "Description provided by " + WIKIPEDIA;
	private final static String NO_INFO = "There is no information available for this artist at " + WIKIPEDIA;
	
	private final static String DESCRIPTION = "description";
	private final static String DISCLAIMER = "disclaimer";
	

	@RequestMapping(value = "/artist", method = RequestMethod.GET)
	public ModelAndView artist(@RequestParam("artist") String artist, Model model) {
		// redirect to change URL e.g artist/mac%20demarco
		return new ModelAndView("redirect:/artist/" + artist);
	}

	@RequestMapping(value = "/artist/{artist}", method = RequestMethod.GET)
	public String artistDisplay(@PathVariable String artist, Model model) throws IOException {

		logger.info("Displaying artist page : " + artist);

		artist = artist.replace("_", " ");
		model.addAttribute("artist", artist);

		artist = WordUtils.capitalize(artist);
		artist = artist.replace(" ", "_");

		try {
			Document doc = Jsoup.connect(WIKIPEDIA + artist).timeout(10 * 1000).get();
			Elements contentDiv = doc.select(".mw-content-ltr p");

			// not entirely correct way of doing this - will not always work
			// more used just to demonstrated the Jsoup functionality
			// e.g. search for 'blur'
			if (contentDiv.first().text().contains("may refer to")) {
				model.addAttribute(DESCRIPTION, Jsoup.connect(WIKIPEDIA + artist + "_(band)").timeout(10 * 1000).get()
						.select(".mw-content-ltr p").first().text());
				model.addAttribute(DISCLAIMER, DISCLAIMER_MESSAGE + artist + "_(band)");
			} else {
				model.addAttribute(DESCRIPTION, contentDiv.first().text());
				model.addAttribute(DISCLAIMER, DISCLAIMER_MESSAGE + artist);
			}
		} catch (HttpStatusException e) {
			model.addAttribute(DESCRIPTION, NO_INFO + artist);
		}

		return "artist";
	}

}
