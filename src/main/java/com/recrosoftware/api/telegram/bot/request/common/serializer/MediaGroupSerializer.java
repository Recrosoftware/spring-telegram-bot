package com.recrosoftware.api.telegram.bot.request.common.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.recrosoftware.api.telegram.bot.model.InputMedia;
import com.recrosoftware.api.telegram.bot.request.common.CustomSerializer;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class MediaGroupSerializer implements CustomSerializer<List<InputMedia<?>>> {
    @Override
    public List<BodyPart> serialize(String fieldName, List<InputMedia<?>> element) {
        List<BodyPart> bodyParts = new ArrayList<>();

        ArrayNode mediaNode = new ObjectMapper().createArrayNode();
        for (InputMedia inputMedia : element) {
            mediaNode.add(inputMedia.getRequestBody());
            BodyPart inputMediaBody = inputMedia.getFileBody();
            if (inputMediaBody != null) {
                bodyParts.add(inputMediaBody);
            }
        }

        bodyParts.add(new FormDataBodyPart(fieldName, mediaNode, MediaType.APPLICATION_JSON_TYPE));
        return bodyParts;
    }
}
