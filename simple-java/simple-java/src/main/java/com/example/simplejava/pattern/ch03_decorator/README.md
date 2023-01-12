### 테코레이터 패턴(Decorator Pattern)

객체에 추가 요소를 동적으로 더할 수 있다.
서브클래스를 만들 때보다 훨씬 유연하게 기능을 확장할 수 있다.

기존 클래스 코드를 바꾸지 않고 새로운 임무를 추가할 수 있다.

### 데코레이터 

데코레이터의 슈퍼 클래스는 자신이 장식하고 있는 객체의 슈퍼클래스와 같다.  
한 객체를 여러 데코레이터로 감쌀 수 있다.  
자신이 장식하고 있는 객체에게 행동을 위임하는 일 말고 추가 작업을 수행할 수 있다.

### 디자인 원칙

OCP(Open-Closed Principle): 클래스는 확장에는 열려 있어야 하지만 변경에는 닫혀 있어야 한다.

### Java I/O

데코레이터 기반으로 만들어졌다.

### 데코레이터 패턴의 단점

복잡함, 구성 요소를 초기화하는 데 필요한 코드도 복잡함 -> Java I/O 생각
특정 형식에 의존하는 코드에 데코레이터를 적용하기 어려움