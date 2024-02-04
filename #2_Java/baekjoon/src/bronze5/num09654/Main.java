package bronze5.num09654;

// 필요한 패키지 불러오기
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedWriter 객체를 불러와 변수 out에 할당
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// write() 메서드를 사용해 나부 행성의 함대 정보를 출력
		out.write("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE\n");
		out.write("N2 Bomber      Heavy Fighter  Limited    21        \n");
		out.write("J-Type 327     Light Combat   Unlimited  1         \n");
		out.write("NX Cruiser     Medium Fighter Limited    18        \n");
		out.write("N1 Starfighter Medium Fighter Unlimited  25        \n");
		out.write("Royal Cruiser  Light Combat   Limited    4         ");
		
		// close() 메서드를 사용해 BufferedWriter 객체 종료
		out.close();
	}
}