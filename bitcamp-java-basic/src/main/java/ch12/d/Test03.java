// 잘못된 값을 넣었을 때 무시하지 않고 강력하게 오류를 알리기!
package ch12.d;

public class Test03 {

  public static void main(String[] args) {
    
    Patient3 p = new Patient3();
    p.setName("김영희");
    p.setAge(20);
    p.setHeight(60);
    p.setWeight(157);
    p.setGender(Patient.WOMAN);
    
    System.out.println(p);
    
    // 환자를 컴퓨터에서 다루려면 위해 데이터화 해야 한다.
    // Patient는 이럴 목적으로 정의한 클래스이다.
    // 이렇게 Patient의 경우처럼 컴퓨터에서 다루기 위해 데이터화하여 정의하는 것을
    // "추상화"라 부른다.
    // 꼭 데이터만 해당하는 것은 아니다.
    // MemberHandler 클래스의 경우처럼 특정 업무를 정의하는 것도
    // "추상화"라 부른다.
    // => 즉 실세계의 객체(예: 사람, 물건, 업무 등)를 컴퓨터에서 다룰 수 있도록 
    //    클래스로 정의하는 행위를 "추상화"라 부른다.
    Patient3 p2 = new Patient3();
    p2.setName("이철희");
    p2.setAge(300); // 캡슐화를 무너뜨를 수 있는  유효하지 않은 값을 넣으면 오류 발생!
    p2.setWeight(-50); // 캡슐화를 무너뜨를 수 있는  유효하지 않은 값을 넣으면 오류 발생!
    p2.setHeight(400); // 캡슐화를 무너뜨를 수 있는  유효하지 않은 값을 넣으면 오류 발생!
    p2.setGender(3); // 캡슐화를 무너뜨를 수 있는  유효하지 않은 값을 넣으면 오류 발생!
    
    System.out.println(p2);
    

  }

}
