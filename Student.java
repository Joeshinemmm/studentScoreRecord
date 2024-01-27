package classapplic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Student {
    private String myName;
    private int kor;
    private int eng;
    private int math;
    public Student(String myName, int kor, int eng, int math) {
        this.myName = myName;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    public String getMyName() {
        return myName;
    }
    public void setMyName(String myName) {
        this.myName = myName;
    }
    public int getKor() {
        return kor;
    }
    public void setKor(int kor) {
        this.kor = kor;
    }
    public int getEng() {
        return eng;
    }
    public void setEng(int eng) {
        this.eng = eng;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public  int getTotal() {
        return (this.kor + this.eng + this.math);
    }

    public double getAvg() {
        double avg = (double) this.getTotal() / 3;
        BigDecimal dec = new BigDecimal(avg);
        return dec.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

}
