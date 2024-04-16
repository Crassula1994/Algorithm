package bronze4.num06778;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 외계인의 더듬이와 눈의 수를 각 변수에 할당
		int antennaNum = Integer.parseInt(in.readLine());
		int eyeNum = Integer.parseInt(in.readLine());
		
		// 해당 외계인이 트로이 화성인의 조건에 해당하는 경우 'TroyMartian' 및 줄바꿈 출력
		if (antennaNum >= 3 && eyeNum <= 4) {
			out.write("TroyMartian");
			out.newLine();
		}
		
		// 해당 외계인이 블라드 토성인의 조건에 해당하는 경우 'VladSaturnian' 및 줄바꿈 출력
		if (antennaNum <= 6 && eyeNum >= 2) {
			out.write("VladSaturnian");
			out.newLine();
		}
		
		// 해당 외계인이 그래미 수성인의 조건에 해당하는 경우 'GremeMercurian' 및 줄바꿈 출력
		if (antennaNum <= 2 && eyeNum <= 3) {
			out.write("GraemeMercurian");
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}