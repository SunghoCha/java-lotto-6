package lotto.View;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 정규식테스트() {
        String NUMBERS_REGEX = "^([\\d],){5}+([\\d]){1}$";
        Pattern pattern = Pattern.compile(NUMBERS_REGEX);
        Matcher matcher = pattern.matcher("1,2,4,5,6,8");
        assertThat(matcher.find()).isTrue();
    }

}