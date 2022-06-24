package org.arsal.utility;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class LocalDateAdapterUtility extends TypeAdapter<LocalDate> {

    private static final String DATE_FORMAT_PATTERN = "yyyy/MM/dd";

    @Override
    public void write(final JsonWriter jsonWriter, final LocalDate localDate ) throws IOException {
        jsonWriter.value(localDate.toString());
    }

    @Override
    public LocalDate read( final JsonReader jsonReader ) throws IOException {
        return LocalDate.parse(jsonReader.nextString(), DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN));
    }
}
