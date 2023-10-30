package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.DTO.CarDTO;
import racingcar.system.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class RoundTest {
    private final static int MOVEMENT_CONDITION = 5;
    private final static int INITIAL_POSITION = 0;
    private final static int ONE_MOVEMENT = 1;
    private final static int TEST_CAR_COUNT = 3;

    // RandomNumberGenerator의 대체 인터페이스 구현
    RandomNumberGenerator mockedGenerator = new RandomNumberGenerator() {
        @Override
        public int generate() {
            return MOVEMENT_CONDITION; // 항상 5를 반환
        }
    };

    @Test
    @DisplayName("라운드가 시작되면 자동차는 전진 조건에서 전진한다.")
    public void 라운드_시작_전진_조건() {
        // given
        // 테스트 자동차 생성
        List<Car> cars = new ArrayList<>();
        Car car = new Car("Test");
        car.setRandomNumberGenerator(mockedGenerator);
        cars.add(car);

        // 라운드 시작
        Round round = new Round();

        // when
        int beforeCarPosition = car.getPosition();
        round.startRace(cars);
        int afterCarPosition = car.getPosition();

        // then
        Assertions.assertAll(
                () -> assertThat(beforeCarPosition).isEqualTo(INITIAL_POSITION),
                () -> assertThat(afterCarPosition).isEqualTo(ONE_MOVEMENT),
                () -> assertThat(afterCarPosition).isGreaterThan(beforeCarPosition)
        );
    }

    @Test
    @DisplayName("라운드 종료 후 전진 조건의 자동차의 이름과 위치 확인")
    public void 라운드_종료_후_결과_반환() throws Exception {
        // given
        // 테스트 자동차 생성
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < TEST_CAR_COUNT; i++) {
            Car car = new Car("Test" + i);
            car.setRandomNumberGenerator(mockedGenerator);
            cars.add(car);
        }

        // when
        Round round = new Round();
        round.startRace(cars);
        List<CarDTO> roundResult = round.generateResult(cars);

        // then
        Assertions.assertAll(
                () -> assertThat(roundResult).size().isEqualTo(TEST_CAR_COUNT),
                () -> assertThat(roundResult)
                        .extracting("name", "position")
                        .contains(
                                tuple("Test0", 1),
                                tuple("Test1", 1),
                                tuple("Test2", 1)
                        )
        );
    }
}