# 🎯 프리코스 2주차 과제 - 자동차 경주

> 내용이 추가 또는 수정될 수 있다.

## 🚀 기능 구현 목록
> - 기능 작동 순서대로 작성한다.
>
> - 스스로 판단한 내용은 (`판단`) 이라고 표시한다.
>   - 판단한 내용에 대한 이유를 설명한다.
>
> - 기능을 구현했다면 해당 기능 목록에 체크한다.

### 1. 사용자로부터 경주할 자동차의 이름을 입력받는다.
- [x] 사용자에게 자동차 이름 입력 메시지를 출력한다.
- [x] 사용자로부터 경주할 자동차의 이름을 입력받는다.

### 2. 경주할 자동차 이름에 대한 입력값을 검증한다.
- [x] 입력값이 null 또는 빈 문자열(공백만 존재하는 경우 포함)이면 에외를 발생시킨다. (`판단`: 사용자의 입력 실수 고려)
- [x] 입력값 양쪽의 공백을 제거한다. (`판단`: 사용자의 입력 실수 고려)

### 3. 검증된 입력값을 쉼표로 분리해 각 자동차 이름을 검증한다.
- [x] 입력값을 쉼표로 분리해 각 자동차 이름을 얻는다.
- [x] 각 자동차 이름 양쪽의 공백을 제거한다. (`판단`: 사용자의 입력 실수 고려)
- 각 자동차 이름의 검증 기준
  - [x] 자동차 이름이 빈 문자열(공백만 존재하는 경우 포함)이면 예외를 발생시킨다. (`판단`: 사용자의 입력 실수 고려)
  - [x] 자동차 이름이 중복되면 예외를 발생시킨다. (`판단`: 이름의 고유성 유지)
  - [x] 자동차 글자 수가 5를 초과하면 예외를 발생시킨다.

### 4. 검증된 이름을 각 자동차에 부여해 자동차 리스트를 생성한다.
- [x] 고유한 이름을 가진 자동차를 생성한다.
- [x] 자동차 리스트를 생성한다.

### 5. 사용자로부터 시도할 횟수를 입력받는다.
- [x] 사용자에게 시도할 횟수 입력 메시지를 출력한다.
- [x] 사용자로부터 시도할 횟수를 입력받는다.

### 6. 시도할 횟수에 대한 입력값을 검증한다.
- [x] 입력값이 null 또는 빈 문자열(공백만 존재하는 경우 포함)이면 에외를 발생시킨다. (`판단`: 사용자의 입력 실수 고려)
- [x] 입력값 양쪽의 공백을 제거한다. (`판단`: 사용자의 입력 실수 고려)
- 시도할 횟수 검증 기준
  - [x] 자연수가 아니면 예외를 발생시킨다. (`판단`: '시도할 횟수'라는 역할에 맞는 숫자 반영)
  - [x] 10,000을 초과하는 값이면 예외를 발생시킨다. (`판단`: 실세계 측면 - 현실적인 숫자 반영, 구현 측면 - 메모리 사용량 고려)

### 7. 입력받은 시도할 횟수(라운드)만큼 자동차 경주를 진행하는 동시에 과정을 출력한다.
- [x] 라운드만큼 자동차 경주를 진행한다.
  - [x] 라운드마다 각 자동차는 랜덤 숫자를 생성한다.
  - [x] 숫자가 4 이상이면 전진(move), 아니면 아무 것도 하지 않는다.
- [x] 진행하는 과정에서 나오는 결과를 라운드가 끝날때 마다 출력한다. (`판단` 사용자에게 진행 과정을 실시간으로 보여주기 위함)

### 8. 자동차 경주가 끝나면 우승자를 출력한다.
- [x] 가장 많이 전진한 자동차들을 모아 리스트로 만든다.
- [x] 우승자를 출력한다.


## 🔍 테스트 코드 구현 목록
> 테스트가 정상적으로 통과하면 해당 테스트 목록에 체크한다.

1. ApplicationTest
### 정상 입력
- [x] 단독 우승 케이스
  - [x] 자동차 2대, 시도할 횟수 1
  - [x] 자동차 2대, 시도할 횟수 2
  - [x] 자동차 3대, 시도할 횟수 1
- [x] 공동 우승 케이스
  - [x] 자동차 2대, 시도할 횟수 1
  - [x] 자동차 3대, 시도할 횟수 2
- [x] 다양한 유형의 자동차 이름
  - [x] 숫자로만 이루어진 자동차 이름 (`판단` 이름의 확장성)
  - [x] 기호로만 이루어진 자동차 이름 (`판단` 이름의 확장성)
  - [x] 문자, 숫자, 기호로 이루어진 자동차 이름 (`판단` 이름의 확장성)
- [x] 자동차 이름 입력값 공백 처리
  - [x] 자동차 이름 입력값 양쪽 공백 제거 (`판단` 사용자의 입력 실수 고려)
  - [x] 입력값을 쉽표로 구분한 각 자동차의 양쪽 공백 제거 (`판단` 사용자의 입력 실수 고려)
  - [x] 각 자동차 이름 중간에 있는 공백은 제거하지 않음 (`판단` 중간 공백 또한 이름의 일부)

### 예외 발생
- [x] 유효하지 않은 입력 오류
  - [x] 자동차 이름으로 `""` 입력 (`판단` 사용자의 입력 실수 고려)
  - [x] 자동차 이름으로 `" "` 입력 (`판단` 사용자의 입력 실수 고려)
  - [x] 자동차 이름으로 `"pobi,,woni"` 입력 (`판단` 사용자의 입력 실수 고려)
  - [x] 자동차 이름으로 `",pobi,woni,"` 입력 (`판단` 사용자의 입력 실수 고려)
  - [x] 시도할 횟수로 `""` 입력 (`판단` 사용자의 입력 실수 고려)
  - [x] 시도할 횟수로 `" "` 입력 (`판단` 사용자의 입력 실수 고려)
- [x] 자동차 이름 길이 오류
  - [x] 이름 중간 공백 없이 길이가 5를 초과하는 경우
  - [x] 이름 중간 공백과 함께 길이가 5를 초과하는 경우 (`판단` 중간 공백 또한 이름의 일부)
- [x] 자동차 이름 중복 오류 (`판단`: 이름의 고유성 유지)
- [x] 시도할 횟수 형식 오류
  - [x] 숫자가 아닌 문자는 허용하지 않는다. (`판단`: '시도할 횟수'라는 역할에 맞는 숫자 반영)
  - [x] 음수는 허용하지 않는다. (`판단`: '시도할 횟수'라는 역할에 맞는 숫자 반영)
  - [x] 0은 허용하지 않는다. (`판단`: '시도할 횟수'라는 역할에 맞는 숫자 반영)
  - [x] 실수는 허용하지 않는다. (`판단`: '시도할 횟수'라는 역할에 맞는 숫자 반영)
- [x] 시도할 횟수 최댓값 초과 오류(`판단`: 실세계 측면 - 현실적인 숫자 반영, 구현 측면 - 메모리 사용량 고려)


2. model.InputParserTest
- [x] 자동차 이름 입력값 공백 검증 기능에 대한 테스트
- [x] 자동차 이름 입력값 쉼표로 분리하는 기능에 대한 결과값 테스트
- [x] 시도할 횟수 입력값 공백 검증 기능에 대한 테스트
- [x] 시도할 횟수 입력값 숫자 형식 검증 기능에 대한 테스트
- [x] 시도할 횟수 입력값 최댓값 초과 검증 기능에 대한 테스트
- [x] 시도할 횟수 양수로 변환하는 기능에 대한 테스트

3. model.domain.CarTest
- [x] 자동차 이름 공백 검증 기능에 대한 테스트
- [x] 자동차 이름 길이 검증 기능에 대한 테스트

4. model.domain.CarsTest
- [x] 자동차 이름 중복 검증 기능에 대한 테스트
- [x] 자동차 리스트를 저장하는 Cars 객체 생성 기능에 대한 테스트

## ✅ 요구 사항 체크
### 과제 진행 요구 사항
- [x] 미션은 자동차 경주 저장소를 포크하고 클론하는 것으로 시작한다.
- [x] 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- [x] Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
    - [x] AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.

### 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
- [x] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. 
- [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 
- [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. 
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

#### 입출력 요구 사항
##### 입력
- [x] 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
- [x] 시도할 횟수

##### 출력
- [x] 차수별 실행 결과
- [x] 단독 우승자 안내 문구
- [x] 공동 우승자 안내 문구

### 프로그래밍 요구 사항 1
- [x] JDK 21 버전에서 실행 가능해야 한다.
- [x] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [x] `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - [x] 기본적으로 Java Style Guide를 원칙으로 한다.

### 프로그래밍 요구 사항 2
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다. 
- [x] 3항 연산자를 쓰지 않는다. 
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
#### 라이브러리
- [x] camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다. 
  - [x] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
  - [x] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

## 📝 구현 코드 명세
| Class                     | Field&Method                                                 | Role(Responsibility)                                    |
|---------------------------|--------------------------------------------------------------|---------------------------------------------------------|
| controller.RaceController | public void run()                                            | 컨트롤러를 실행                                                |
|                           | private Cars getCars()                                       | 자동차이름을 입력받고 자동차 리스트를 반환                                 |
|                           | private Integer getRound(Cars cars)                          | 시도할 횟수를 입력받고 양수로 변환한 값을 반환                              |
|                           | private Cars runRaceEveryRound(Cars cars, Integer round)     | 매 라운드 경주를 실행하고 그 결과를 반환 후 출력                            |
|                           | private void showWinners(Cars cars)                          | 우승자를 선정해 출력                                             |
| model.domain.Car          | private final String name                                    | 자동차의 이름                                                 |
|                           | private int step                                             | 자동차가 전진한 거리                                             |
|                           | public void moveOrStay()                                     | 랜덤 숫자를 사용해 전진할지 결정                                      |
|                           | private void move()                                          | 한칸 앞으로 전진                                               |
|                           | private Integer generateRandomNumber()                       | 랜덤 숫자를 반환                                               |
|                           | public String getCurrentRace(String step)                    | 각 자동차의 한 라운드 경주 결과를 반환                                  |
|                           | public Integer getStepGreaterThan(Integer step)              | 인자로 받은 값보다 큰 step을 가졌으면 그 값을 반환(우승자 선정시 최댓값을 알기 위한 메서드) |
|                           | public boolean isWinner(Integer maxStep)                     | 우승자인지 확인                                                |
|                           | public void addTo(List<String> winnerList)                   | 우승자 리스트에 이름을 전달                                         |
| model.domain.Cars         | private final List<Car> cars                                 | 자동차 리스트                                                 |
|                           | public static Cars CarsFrom(List<String> carNames)           | 자동차 리스트를 생성하는 정적 팩토리 메서드                                |
|                           | public List<Car> getCars()                                   | 출력을 위해 자동차 리스트를 반환                                      |
|                           | public Cars conductRound()                                   | 매 라운드를 진행                                               |
|                           | public List<Car> getWinningCars()                            | 우승자를 선정해 우승자 리스트를 반환                                    |
|                           | public Integer getMaxStep()                                  | step의 최댓값을 반환                                           |
| model.domain.WinningCars  | private final List<Car> winningCars                          | 우승자 리스트                                                 |
|                           | public static WinningCars winningCarsFrom(Cars cars)         | 우승자 리스트를 생성하는 정적 팩토리 메서드                                |
|                           | public String getWinners()                                   | 출력을 위해 우승자 리스트를 문자열로 변환 후 반환                            |
| model.InputParser         | private static InputParser inputParserObj                    | 싱글톤 패턴 구현을 위한 객체 참조값을 저장하는 변수                           |
|                           | private String input                                         | 사용자 입력값 저장하는 변수                                         |
|                           | public static InputParser carNamesInputParserFrom(String input) | 자동차 이름 입력값을 저장하는 정적 팩토리 메서드                             |
|                           | public static InputParser roundInputParserFrom(String input) | 시도할 횟수 입력값을 저장하는 정적 팩토리 메서드                             |
|                           | private static InputParser getInputParser(String input)      | InputParser 객체 생성 및 반환                                  |
|                           | public List<String> getSplitCarNames()                       | 자동차 이름 입력값을 쉼표로 분리해 리스트로 반환                             |
|                           | public Integer getRound()                                    | 시도할 횟수 입력값을 양수로 변환 후 반환                                 |
| service.RaceService       | public Cars generateCars(String carNames)                    | 자동차 이름 입력값을 받아 자동차 리스트를 생성 및 반환                         |
|                           | public Integer generateRound(String round)                   | 시도할 횟수 입력값을 받아 양수로 변환 후 반환                              |
|                           | public Cars runRace(Cars cars)                               | 매 라운드 경주를 진행 후 결과를 반환                                   |
|                           | public WinningCars decideWinners(Cars cars)                  | 우승자를 선정 후 결과를 반환                                        |
| util.Converter            | public static Integer convertStringToNumber(String input)    | 문자를 숫자로 변환                                              |
| util.Validator            | public static void validateNullOrBlank(String input)         | 입력값이 null 또는 공백인지 검증                                    |
|                           | public static void validateCarNameLength(String CarName)     | 자동차 이름의 길이 검증                                           |
|                           | public static void validateUniqueCarName(List<String> carNames) | 자동차 이름의 중복 검증                                           |
|                           | public static void validateNumber(String input)              | 시도할 횟수 입력값의 형식 검증                                       |
|                           | public static void validateExceedMax(String input)           | 시도할 횟수 입력값의 최댓값 초과 여부 검증                                |
| view.InputView            | public static String readUserInput()                         | 사용자로부터 값을 입력 받음                                         |
| view.OutputView           | public static void printCarNamesRequest()                    | 자동차 이름을 입력해달라는 메시지 출력                                   |
|                           | public static void printRoundRequest()                       | 시도할 횟수를 입력해달라는 메시지 출력                                   |
|                           | public static void printMessageBeforeRace()                  | 실행 결과 메시지 출력                                            |
|                           | public static void printRace(Cars cars)                      | 경주 진행 결과 출력                                             |
|                           | public static void printWinners(WinningCars winningCars)     | 우승자 출력                                                  |
| constant.Constant         | DELIMITER, RESULT_DELIMITER 등                                | 로직에 필요한 여러 상수                                           |
| constant.ErrorMessage     | INVALID_INPUT_ERROR, CAR_NAME_LENGTH_ERROR 등                 | 에러 메시지 상수                                               |
|                           | public String getErrorMessage()                              | 에러 메시지를 반환                                              |