package com.gcxy.jk.shixunyi.annotation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * json参数时间格式化为LocalDateTime
 * @author hujinghua
 * @date 2022/8/31 17:12
 */
class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @SneakyThrows
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext){
        if (StringUtils.isEmpty(jsonParser.getText())) {
            return null;
        }
        return Instant
                .ofEpochSecond(Long.parseLong(jsonParser.getText()))
                .atZone(ZoneOffset.ofHours(8))
                .toLocalDateTime();
    }

}

