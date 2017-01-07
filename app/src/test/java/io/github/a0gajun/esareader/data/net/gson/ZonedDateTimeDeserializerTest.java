package io.github.a0gajun.esareader.data.net.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.jakewharton.threetenabp.AndroidThreeTen;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeParseException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.lang.reflect.Type;

import io.github.a0gajun.esareader.ApplicationTestCase;

import static org.mockito.BDDMockito.given;

/**
 * Created by Junya on 1/7/17.
 */
public class ZonedDateTimeDeserializerTest extends ApplicationTestCase {

    @Mock JsonElement jsonElement;
    @Mock Type type;
    @Mock JsonDeserializationContext deserializationContext;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deserialize() throws Exception {
        final String validDate = "2017-01-09T12:01:51+09:00";
        given(jsonElement.getAsJsonPrimitive()).willReturn(new JsonPrimitive(validDate));

        ZonedDateTime result = new ZonedDateTimeDeserializer().deserialize(jsonElement, type, deserializationContext);

        assertThat(result.getYear(), is(2017));
        assertThat(result.getMonthValue(), is(1));
        assertThat(result.getDayOfMonth(), is(9));
        assertThat(result.getHour(), is(12));
        assertThat(result.getMinute(), is(1));
        assertThat(result.getSecond(), is(51));
        final ZoneId zoneId = ZoneId.systemDefault();
        assertThat(result.getOffset(), is(ZoneOffset.from(ZonedDateTime.now(zoneId))));
        assertThat(result.getZone(), is(zoneId));
    }

    @Test(expected = DateTimeParseException.class)
    public void deserializeException() {
        final String invalidDate = "2014-aa";
        given(jsonElement.getAsJsonPrimitive()).willReturn(new JsonPrimitive(invalidDate));

        new ZonedDateTimeDeserializer().deserialize(jsonElement, type, deserializationContext);
    }
}