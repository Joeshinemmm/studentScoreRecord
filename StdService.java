package classapplic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class StdService {
    Scanner input = new Scanner(System.in);
    private Student[] stdArray;
    public StdService() {
        System.out.print("총 학생의 수는 몇명입니까? : ");
        int N = input.nextInt();
        input.nextLine();
        this.stdArray = new Student[N];
    }
    public void createStudent() {

        System.out.println("==학생을 생성합니다==");
        for (int i = 0; i < stdArray.length; i++) {
            System.out.print((i + 1) + "번째 학생 이름 : ");
            String myName = input.next();
            System.out.print((i + 1) + "번째 학생 국어점수 : ");
            int kor = input.nextInt();
            System.out.print((i + 1) + "번째 학생 영어점수 : ");
            int eng = input.nextInt();
            System.out.print((i + 1) + "번째 학생 수학점수 : ");
            int math = input.nextInt();

            Student st = new Student(myName, kor, eng, math);
            stdArray[i] = st;
        }

        System.out.println("==학생을 생성완료했습니다==");
        input.close();
    }
    public void printStudent() {
        Student temp = null;
        for (int i = stdArray.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (stdArray[j].getTotal() < stdArray[j + 1].getTotal()) {
                    temp = stdArray[j + 1];
                    stdArray[j + 1] = stdArray[j];
                    stdArray[j] = temp;
                }
            }
        }
        double sumAvg = 0;
        for (Student st : stdArray) {
            System.out.println("이름: " + st.getMyName() + ", " +
                    "국어: " + st.getKor() + ", " +
                    "수학: " + st.getMath() + ", " +
                    "영어: " + st.getEng() + ", " +
                    "총점: " + st.getTotal() + ", " +
                    "평균: " + st.getAvg() + "\n");
            sumAvg += st.getAvg();
        }
        double avgAvg = sumAvg / stdArray.length;
        BigDecimal dec1 = new BigDecimal(avgAvg);
        avgAvg =  dec1.setScale(2, RoundingMode.HALF_UP).doubleValue();

        System.out.println("전체 학생의 평균: " + avgAvg + "점");
    }


}
