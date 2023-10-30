# 기능 요구 사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

# 기능 구현 목록

## 게임
### 입력
- [ ] 사용자는 자동차 이름을 입력할 수 있다.
  - [x] 이름은 쉼표(,)를 기준으로 구분한다.
    - [x] 쉼표 뒤에 공백은 무시한다.
  - [ ] 이름은 5자 이하만 가능하다.
- [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있다.
### 라운드 생성
- [ ] 사용자의 이동 횟수 입력 값에 따라 라운드를 생성한다.
### 출력
- [ ] 라운드마다 자동차의 이동 유무 결과를 츨력한다.
  - [ ] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
  - 완료 기준: 모든 라운드 종료
  - 우승 기준: 가장 멀리 이동한 자동차
  - [ ] 우승자는 한 명 이상일 수 있다.
  - [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

## 자동차
- [ ] 사용자 입력에 따라 각 자동차에 이름을 부여할 수 있다.
- [ ] 주어진 횟수 동안 각 자동차는 전진 또는 멈출 수 있다.
  - 전진 조건
    - [ ] 각 자동차는 라운드마다 한 번 0에서 9 사이에서 무작위 값을 생성한다.
    - [ ] 생성한 무작위 값이 4 이상일 경우 전진한다.
  - 멈춤 조건
    - [ ] 각 자동차는 라운드마다 전진 조건을 만족하지 못하면 멈춰있는 상태를 유지한다.

## 모델 검증
- [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
  - [ ] 자동차 이름을 5글자 초과하여 입려하면 상기 예외가 발생한다.
  - [ ] 이동 횟수를 아라비아 숫자 형태 이외의 형태로 입력하면 상기 예외가 발생한다.