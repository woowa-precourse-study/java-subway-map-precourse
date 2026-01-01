package subway;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

//    @DisplayName("사용자 지정 구분자 파싱 테스트")
//    @Test
//    void parsingMessage() {
//
//        assertThat(result).isEqualTo("1;2");
//        assertThat(delimiter.getTotalDelimiter()).contains(";");
//    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("Q");
            assertThat(output()).contains("원하는 기능을 선택하세요.");
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}