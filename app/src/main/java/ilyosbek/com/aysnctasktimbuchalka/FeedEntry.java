package ilyosbek.com.aysnctasktimbuchalka;

public class FeedEntry {

    private String name;
    private String releaseDate;
    private String artist;
    private String image;
    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getImgUrl() {
        return image;
    }

    public void setImgUrl(String imgUrl) {
        this.image = imgUrl;
    }

    @Override
    public String toString() {
        return "\n" +
                "summary: " + summary + "\n" +
                "name: " + name + "\n" +
                "artist: " + artist + "\n" +
                "release date: " + releaseDate + "\n" +
                "image: " + image;

    }
}
