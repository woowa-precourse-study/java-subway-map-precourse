package subway;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

class ApplicationTest extends NsTest {

    @BeforeEach
    void setUp() {
        StationRepository.clear();
        LineRepository.clear();
    }


    @Test
    void 역_조회_정상테스트() {
        assertSimpleTest(() -> {
            run("1","3","Q");
            assertThat(output()).contains("## 역 목록" ,
                    "[INFO] 교대역" ,
                    "[INFO] 양재역" ,
                    "[INFO] 매봉역");
        });
    }

    @Test
    void 노선_등록_정상테스트() {
        assertSimpleTest(() -> {
            run("2","1","5호선","교대역","매봉역","Q");
            assertThat(output()).contains("[INFO] 지하철 노선이 등록되었습니다.");
        });
    }

    @Test
    void 노선_삭제_정상테스트() {
        assertSimpleTest(() -> {
            run("2","1","5호선","교대역","매봉역","Q");
            assertThat(output()).contains("[INFO] 지하철 노선이 등록되었습니다.");
        });
    }

    @Test
    void 노선_조회_정상테스트() {
        assertSimpleTest(() -> {
            run("2","3","Q");
            assertThat(output()).contains("## 노선 목록" ,
                    "[INFO] 2호선" ,
                    "[INFO] 3호선" ,
                    "[INFO] 신분당선");
        });
    }

    @Test
    void 지하철노선도출력_정상테스트() {
        assertSimpleTest(() -> {
            run("4","Q");
            assertThat(output()).contains("## 지하철 노선도" ,
                    "[INFO] 2호선" ,
                    "[INFO] ---",
                    "[INFO] 교대역" ,
                    "[INFO] 강남역" ,
                    "[INFO] 역삼역");
        });
    }

    @Test
    void 구간등록_정상테스트() {
        assertSimpleTest(() -> {
            run("3","1","2호선","잠실역","2","Q");
            assertThat(output()).contains("[INFO] 구간이 등록되었습니다.");
        });
    }


    /**
     *
     * 예외테스트
     *
     * **/


    @Test
    void 노선에_등록된_역_삭제_줄가_예외_테스트() {
        assertThatThrownBy(() ->
                runException("1","2","매봉역")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


    @Test
    void 역_이름_두글자이하_예외_테스트() {
        assertThatThrownBy(() ->
                runException("1","1","아")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 역_중복등록__예외_테스트() {
        assertThatThrownBy(() ->
                runException("1","1","매봉역")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}