package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    @Override
    public String toString() {
        String result = "";
        if (!attributes.isEmpty()) {
            StringBuilder attribute = new StringBuilder(" ");
            attributes.forEach((key, value) ->
                    attribute.append(key).append("=\"").append(value).append("\" "));
            result = attribute.deleteCharAt(attribute.length() - 1).toString();
        }
        return "<" + name + result + ">";
    }
}
// END
