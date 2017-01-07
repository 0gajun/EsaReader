package io.github.a0gajun.esareader.data.net.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.lang.reflect.Type;

/**
 * Created by Junya on 1/7/17.
 */

public class ZonedDateTimeDeserializer implements JsonDeserializer<ZonedDateTime> {
    @Override
    public ZonedDateTime deserialize(JsonElement json, Type typeOfT,
                                     JsonDeserializationContext context) throws JsonParseException {
        return OffsetDateTime
                .parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                .atZoneSameInstant(ZoneId.systemDefault());
    }
}
