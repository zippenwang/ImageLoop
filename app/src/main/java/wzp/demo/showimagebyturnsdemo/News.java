package wzp.demo.showimagebyturnsdemo;

import java.io.Serializable;

/**
 * Created by wzp on 2017/6/14.
 */

public class News implements Serializable{

    private String imageUrl;
    private String title;
    private String content;
    private String contentUrl;

    public News(String imageUrl, String title, String content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
    }

    public News(String imageUrl, String contentUrl) {
        this.imageUrl = imageUrl;
        this.contentUrl = contentUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }
}
