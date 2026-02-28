package tech.trainning.trainningspringvalidation.dtos.serializers;


import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ser.std.StdSerializer;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DoubleSerializer extends StdSerializer<Double> {

    public DoubleSerializer() {
        super(Double.class);
    }

    @Override
    public void serialize(Double value, JsonGenerator gen, SerializationContext provider) throws JacksonException {
        if (value == null) {
            gen.writeNull();
            return;
        }

        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.of("pt", "BR"));
        DecimalFormat df = new DecimalFormat("#,##0.00", dfs);

        gen.writeString(df.format(value));
    }
}

