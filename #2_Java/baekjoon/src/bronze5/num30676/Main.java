package bronze5.num30676;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 별빛의 파장을 변수 wavelength에 할당
		int wavelength = Integer.parseInt(in.readLine());
		
		// 해당 별의 색이 빨간색인 경우 'Red' 출력
		if (wavelength >= 620) {
			out.write("Red");
			
		// 해당 별의 색이 주황색인 경우 'Orange' 출력
		} else if (wavelength >= 590) {
			out.write("Orange");
		
		// 해당 별의 색이 노란색인 경우 'Yellow' 출력
		} else if (wavelength >= 570) {
			out.write("Yellow");
		
		// 해당 별의 색이 초록색인 경우 'Green' 출력
		} else if (wavelength >= 495) {
			out.write("Green");
		
		// 해당 별의 색이 파란색인 경우 'Blue' 출력
		} else if (wavelength >= 450) {
			out.write("Blue");
			
		// 해당 별의 색이 남색인 경우 'Indigo' 출력
		} else if (wavelength >= 425) {
			out.write("Indigo");
			
		// 해당 별의 색이 보라색인 경우 'Violet' 출력
		} else {
			out.write("Violet");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}