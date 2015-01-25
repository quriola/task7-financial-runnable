//Jiayi Zhu
//jiayiz
//08-600
//Dec 10, 2014

package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("favorite_id")
public class FavoriteBean {

	private int favorite_id;
	private int user_id;
	private String url;
	private String comment;
	private int click_count;

	public int getFavorite_id() {
		return favorite_id;
	}

	public void setFavorite_id(int favorite_id) {
		this.favorite_id = favorite_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getClick_count() {
		return click_count;
	}

	public void setClick_count(int click_count) {
		this.click_count = click_count;
	}

	public void addCount() {
		click_count++;

	}

}
