import com.recrosoftware.api.telegram.bot.model.inline.InlineQueryResult;
import com.recrosoftware.api.telegram.bot.model.inline.InlineQueryResultArticle;
import com.recrosoftware.api.telegram.bot.model.inline.InputTextMessageContent;
import com.recrosoftware.api.telegram.bot.request.inline.AnswerInlineQuery;
import com.recrosoftware.utils.validation.BeanValidator;
import com.recrosoftware.utils.validation.ValidationError;
import com.recrosoftware.utils.validation.exception.ValidationProcessingException;

import java.util.ArrayList;
import java.util.List;

public class FieldTest {
    public static void main(String[] args) {
        List<InlineQueryResult<?>> results = new ArrayList<>();

        results.add(new InlineQueryResultArticle()
                .setId("123")
                .setTitle("Title")
                .setInputMessageContent(new InputTextMessageContent()
                        .setMessageText("Text")));

        AnswerInlineQuery method = new AnswerInlineQuery()
                .setInlineQueryId("1234")
                .setResults(results);

        try {
            BeanValidator.validate(method);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ValidationProcessingException ex) {
            for (ValidationError validationError : ex.getValidationErrors()) {
                System.out.println(String.format("%s\t: %s", validationError.getField(), validationError.getReason()));
            }
        }

        System.out.println("DONE");
    }
}
