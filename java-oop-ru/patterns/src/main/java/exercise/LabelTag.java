package exercise;

// BEGIN
public class LabelTag implements TagInterface {
private String tag;
private TagInterface childObj;

    public LabelTag(String tag, TagInterface childObj) {
        this.tag = tag;
        this.childObj = childObj;
    }

    @Override
    public String render() {
        return "<label>" + tag + childObj.render() + "</label>";
    }
}
// END
