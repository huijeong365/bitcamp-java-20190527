package com.eomcs.lms.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

// 서버쪽의 BoardDao를 대행할 프록시 객체를 정의한다.
// => 클라이언트는 이 프록시 객체를 통하여
//    서버쪽의 BoardDao 객체를 사용할 것이다.
// => 보통 서비스를 제공하는 서버쪽에서 프록시 객체를 만들어
//    클라이언트 개발자에게 배포한다.
// => 이런 방식으로 프로그램을 개발할 때 이점은, 
//    클라이언트 개발자가 서버와 어떻게 통신해야 하는지 알 필요가 없다는 것이다.
// => 즉 서버쪽과 통신하는 코드를 캡슐화 하여 감추고, 대신 메서드를 통해 단순화 시키는 기법이다.
//    이런 설계 기법을 "프록시 패턴(proxy pattern)" 이라 한다.

// 프록시 패턴
// => 프록시 역할을 수행할 클래스는 실제 일을 하는 클래스와 같은 규칙을 따라야 한다.
// 
public class LessonDaoProxy implements LessonDao {

  String host;
  int port;

  public LessonDaoProxy(String host, int port) {
    this.host = host;
    this.port = port;
  }

  @Override
  public int insert(Lesson lesson) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF("/lesson/add");
      out.writeObject(lesson);
      out.flush();

      if (!in.readUTF().equals("ok"))
        throw new Exception(in.readUTF());

      return 1;
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Lesson> findAll() throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF("/lesson/list");
      out.flush();

      if (!in.readUTF().equals("ok"))
        throw new Exception(in.readUTF());

      return (List<Lesson>)in.readObject();
    }
  }

  @Override
  public Lesson findBy(int no) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF("/lesson/detail");
      out.writeInt(no);
      out.flush();

      if (!in.readUTF().equals("ok"))
        throw new Exception(in.readUTF());

      return (Lesson)in.readObject();
    }
  }

  @Override
  public int update(Lesson lesson) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF("/lesson/update");
      out.writeObject(lesson);
      out.flush();

      if (!in.readUTF().equals("ok"))
        throw new Exception(in.readUTF());

      return 1;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      out.writeUTF("/lesson/delete");
      out.writeInt(no);
      out.flush();

      if (!in.readUTF().equals("ok"))
        throw new Exception(in.readUTF());

      return 1;
    }
  }


//  public static void main(String[] args) throws Exception {
//    LessonDaoProxy daoProxy = new LessonDaoProxy("localhost", 8888);

//    // 입력 테스트
//    Lesson lesson = new Lesson();
//    lesson.setNo(100);
//    lesson.setContents("okokok");
//
//    daoProxy.insert(lesson);
//    System.out.println("입력성공!");

//    // 조회 테스트
//    Lesson lesson = daoProxy.findBy(100);
//    System.out.println(lesson);
    
 // 목록 조회 테스트
//  List<Lesson> lessons = daoProxy.findAll();
//  for (Lesson lesson : lessons) {
//    System.out.println(lesson);
//  }
  
//  // 변경 테스트
//  Lesson lesson = new Lesson();
//  lesson.setNo(100);
//  lesson.setContents("오호라.. 그렇군요!");
//  
//  daoProxy.update(lesson);
//  
//  Lesson lesson2 = daoProxy.findBy(100);
//  System.out.println(lesson2);
  
  
//  // 삭제 테스트
//  daoProxy.delete(100);
//  System.out.println("삭제 완료!");


//  }



}
