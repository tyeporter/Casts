package com.tyeporter.casts.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.tyeporter.casts.model.Episode;
import com.tyeporter.casts.model.Podcast;
import com.tyeporter.casts.model.Search;
import com.tyeporter.casts.service.CastsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class CastsController {

	// =========================================================
    // Autowired Properties
    // =========================================================

	@Autowired
	CastsServiceImpl service;

	// =========================================================
    // Properties
    // =========================================================

	private Category category;
	private int categoryId;
	private List<Episode> episodes;
	private Episode currentEpisode;
	private HashMap<String, Episode> pageResults = new HashMap<>();
	private List<Podcast> podcastSearchResults;

	// =========================================================
    // Enums
    // =========================================================

	enum Category {
		SCIENCE("Science"),
		HEALTH("Health"),
		POLITICS("Politics"),
		SPIRITUALITY("Spirituality"),
		SPORTS("Sports"),
		RELATIONSHIPS("Relationships");

		private String stringValue;

		Category(String stringValue) { this.stringValue = stringValue; }

		public String getStringValue() {
			return stringValue;
		}

		public String getCategoryMessage() {
			return "The latest conversations about " + this.getStringValue().toLowerCase() + " and more, featuring some of your favorite publishers.";
		}
	}

	enum Page {
		CATEGORY_PAGE("category_page"),
		EPISODE_PAGE("episode_page"),
		SEARCH_PAGE("search_page");

		private String fileName;

		Page(String fileName) { this.fileName = fileName; }

		public String getFileName() {
			return fileName;
		}
	}

	// =========================================================
    // GET Mappings
    // =========================================================

	@GetMapping({"/", "", "/science", "/Science"})
	public String getHome(Model model) {
		this.category = Category.SCIENCE;
		this.categoryId = 107;
		this.fetchEpisodes();
		this.setupViewModelForCategoryPage(model);
		return Page.CATEGORY_PAGE.getFileName();
	}

	@GetMapping({"/health", "/Health"})
	public String getNutrition(Model model) {
		this.category = Category.HEALTH;
		this.categoryId = 88;
		this.fetchEpisodes();
		this.setupViewModelForCategoryPage(model);
		return Page.CATEGORY_PAGE.getFileName();
	}

	@GetMapping({"/politics", "/Politics"})
	public String getPolitics(Model model) {
		this.category = Category.POLITICS;
		this.categoryId = 216;
		this.fetchEpisodes();
		this.setupViewModelForCategoryPage(model);
		return Page.CATEGORY_PAGE.getFileName();
	}

	@GetMapping({"/spirituality", "/Spirituality"})
	public String getReligion(Model model) {
		this.category = Category.SPIRITUALITY;
		this.categoryId = 70;
		this.fetchEpisodes();
		this.setupViewModelForCategoryPage(model);
		return Page.CATEGORY_PAGE.getFileName();
	}

	@GetMapping({"/sports", "/Sports"})
	public String getSports(Model model) {
		this.category = Category.SPORTS;
		this.categoryId = 77;
		this.fetchEpisodes();
		this.setupViewModelForCategoryPage(model);
		return Page.CATEGORY_PAGE.getFileName();
	}

	@GetMapping({"/relationships", "/Relationships"})
	public String getLove(Model model) {
		this.category = Category.RELATIONSHIPS;
		this.categoryId = 245;
		this.fetchEpisodes();
		this.setupViewModelForCategoryPage(model);
		return Page.CATEGORY_PAGE.getFileName();
	}

	@GetMapping({"/search", "/Search"})
	public String getSearch(Model model) {
		this.setupViewModelForSearchPage(model);
		return Page.SEARCH_PAGE.getFileName();
	}

	@GetMapping("/ep")
	public String getEpisode(@RequestParam String id, Model model) {
		boolean preloaded = pageResults.containsKey(id);
		currentEpisode =  preloaded ? pageResults.get(id) : service.getEpisode(id);
		
		model.addAttribute("categories", Arrays.asList(Category.values()));
		model.addAttribute("selectedCategory", this.category);
		model.addAttribute("episode", currentEpisode);
		model.addAttribute("podcastTitle", preloaded 
			? currentEpisode.getPodcast().getTitleOriginal() 
			: currentEpisode.getPodcast().getTitle());
		model.addAttribute("episodeTitle", preloaded 
			? currentEpisode.getTitleOriginal() 
			: currentEpisode.getTitle());
		model.addAttribute("episodeDescription", preloaded 
		? currentEpisode.getDescriptionOriginal() 
		: currentEpisode.getDescription());

		return Page.EPISODE_PAGE.getFileName();
	}

	// =========================================================
    // POST Mappings
	// =========================================================
	
	@PostMapping("/search")
	public String submitSearch(@ModelAttribute("search") Search search) {
		if (search.getType().equals("podcast")) {
			this.service.searchPodcasts(search.getQuery().toLowerCase().replaceAll("\\s", "%20"));
		}
		
		// System.out.println(this.podcastSearchResults);
		return "redirect:/search";
	}

	// =========================================================
    // HELPER METHODS
	// =========================================================
	
	private void fetchEpisodes() {
		this.episodes = service.getEpisodes(this.category.getStringValue(), this.categoryId).getEpisodes();
		if (this.pageResults.size() > 0) { this.pageResults.clear(); }
		for (Episode episode : episodes) { pageResults.put(episode.getId(), episode); }
	}

	private void setupViewModelForCategoryPage(Model model) {
		model.addAttribute("categories", Arrays.asList(Category.values()));
		model.addAttribute("selectedCategory", this.category);
		model.addAttribute("episodes", this.episodes);
	}

	private void setupViewModelForSearchPage(Model model) {
		model.addAttribute("categories", Arrays.asList(Category.values()));
		model.addAttribute("selectedCategory", this.category);
		model.addAttribute("search", new Search());
	}

}