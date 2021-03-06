package vidur.codeclan.projectx.POJO;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bookmark {

    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("objects")
    @Expose
    private List<BookmarkObject> objects = null;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public List<BookmarkObject> getObjects() {
        return objects;
    }

    public void setObjects(List<BookmarkObject> objects) {
        this.objects = objects;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

}
