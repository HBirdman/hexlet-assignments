package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
class PairedTag extends Tag{
String text;
List<Tag> tagChildren;

    public PairedTag(
            String name, Map<String, String> attributes,
            String text, List<Tag> tagChildren
    ) {
        super(name, attributes);
        this.text = text;
        this.tagChildren = tagChildren;
    }

    @Override
    public String toString() {
        String attributesResult = "";
        String childrenResult = "";
        if (!attributes.isEmpty()) {
            StringBuilder attribute = new StringBuilder(" ");
            attributes.forEach((key, value) ->
                    attribute.append(key).append("=\"").append(value).append("\" "));
            attributesResult = attribute.deleteCharAt(attribute.length() - 1).toString();
        }
        if (!tagChildren.isEmpty()) {
            StringBuilder children = new StringBuilder();
            for (var child : tagChildren) {
                children.append(child.toString());
            }
            childrenResult = children.toString();
        }
        return "<" + name + attributesResult + ">" + childrenResult + text + "</" + name + ">";
    }
}
// END
