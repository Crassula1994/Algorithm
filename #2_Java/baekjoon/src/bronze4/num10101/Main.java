package bronze4.num10101;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
 
    // main() 메서드 정의
    public static void main(String[] args) throws IOException {
     
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 삼각형의 각을 각 변수에 할당
		int angleA = Integer.parseInt(in.readLine());
		int angleB = Integer.parseInt(in.readLine());
		int angleC = Integer.parseInt(in.readLine());
		
		// 해당 삼각형이 정삼각형일 경우 'Equilateral' 출력
		if (angleA == 60 && angleB == 60 && angleC == 60) {
			out.write("Equilateral");
			
		// 삼각형이 아닌 경우 'Error' 출력
		} else if (angleA + angleB + angleC != 180) {
			out.write("Error");
			
		// 해당 삼각형이 이등변삼각형일 경우 'Isosceles' 출력
		} else if (angleA == angleB || angleA == angleC || angleB == angleC) {
			out.write("Isosceles");
		
		// 해당 삼각형에서 같은 각이 없는 경우 'Scalene' 출력
		} else {
			out.write("Scalene");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
}