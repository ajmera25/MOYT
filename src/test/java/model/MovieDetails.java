package model;

public class MovieDetails {
	
	String wiki_url ="";
	String wiki_image="";
	String wiki_directors=null;
	String imdb_url="";
	String imdb_image="";
	String imdb_directors=null;
	String movie_Id=null;
	String movie_name = "";
	String platformMode = "";
	
	public String getPlatform() {
		return platformMode;
	}

	public void setPlatform(String platform) {
		this.platformMode = platform;
	}

	public MovieDetails(String movieId) {
		this.movie_Id = movieId;
	}
	
	public String getWiki_url() {
		return wiki_url;
	}
	public String getWiki_image() {
		return wiki_image;
	}
	public String getWiki_directors() {
		return wiki_directors;
	}
	public String getImdb_url() {
		return imdb_url;
	}
	public String getImdb_image() {
		return imdb_image;
	}
	public String getImdb_directors() {
		return imdb_directors;
	}
	public String getMovie_Id() {
		return movie_Id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setWiki_url(String wiki_url) {
		this.wiki_url = wiki_url;
	}
	public void setWiki_image(String wiki_image) {
		this.wiki_image = wiki_image;
	}
	public void setWiki_directors(String wiki_directors) {
		this.wiki_directors = wiki_directors;
	}
	public void setImdb_url(String imdb_url) {
		this.imdb_url = imdb_url;
	}
	public void setImdb_image(String imdb_image) {
		this.imdb_image = imdb_image;
	}
	public void setImdb_directors(String imdb_directors) {
		this.imdb_directors = imdb_directors;
	}
	public void setMovie_Id(String movie_Id) {
		this.movie_Id = movie_Id;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	
	
	

}
