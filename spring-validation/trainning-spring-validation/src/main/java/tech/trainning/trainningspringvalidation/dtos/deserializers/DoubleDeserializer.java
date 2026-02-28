package tech.trainning.trainningspringvalidation.dtos.deserializers;


import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.deser.std.StdDeserializer;

public class DoubleDeserializer extends StdDeserializer<Double> {

    public DoubleDeserializer() {
        super(Double.class);
    }

    @Override
    public Double deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        var tree = p.readValueAsTree();
        var nodeValue = tree.toString().replaceAll("\"", "");

        StringBuilder doubleStrBuilder = new StringBuilder();

        var lastDotIndex = nodeValue.lastIndexOf(".");
        var lastCommaIndex = nodeValue.lastIndexOf(",");

        if (lastCommaIndex > 0 && (lastDotIndex < lastCommaIndex)) {
            doubleStrBuilder = new StringBuilder();

            var doubleParcialValue = nodeValue.replaceAll("\\.", ",");
            var doubleSegment1 = doubleParcialValue.substring(0, lastCommaIndex);
            var doubleSegment2 = doubleParcialValue.substring(lastCommaIndex + 1);

            doubleStrBuilder.append(doubleSegment1.replaceAll(",", ""));
            doubleStrBuilder.append(".");
            doubleStrBuilder.append(doubleSegment2.replaceAll("\\.", ""));
        }

        if (lastDotIndex > lastCommaIndex) {
            doubleStrBuilder = new StringBuilder();

            var doubleParcialValue = nodeValue.replaceAll(",", ".");
            var doubleSegment1 = doubleParcialValue.substring(0, lastDotIndex);
            var doubleSegment2 = doubleParcialValue.substring(lastDotIndex + 1);

            doubleStrBuilder.append(doubleSegment1.replaceAll("\\.", ""));
            doubleStrBuilder.append(".");
            doubleStrBuilder.append(doubleSegment2.replaceAll(",", ""));
        }

        if (doubleStrBuilder.toString().isBlank()) {
            doubleStrBuilder.append(nodeValue);
        }

        return Double.valueOf(doubleStrBuilder.toString());
    }
}
