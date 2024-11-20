package bronze4.num04589;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 놈의 무리 수를 변수 groupNum에 할당
		int groupNum = Integer.parseInt(in.readLine());
		
		// write() 메서드를 사용해 정해진 제목 줄을 출력
		out.write("Gnomes:\n");
		
		// while 반복문을 사용해 각 놈 무리를 순회
		while (groupNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 각 놈의 수염 길이를 각 변수에 할당
			int firstGnome = Integer.parseInt(st.nextToken());
			int secondGnome = Integer.parseInt(st.nextToken());
			int thirdGnome = Integer.parseInt(st.nextToken());
			
			// 해당 놈 무리가 수염의 길이에 따라 순서대로 줄을 서 있는지 여부를 변수 isOrdered에 할당
			boolean isOrdered = (firstGnome <= secondGnome && secondGnome <= thirdGnome) ||
					(firstGnome >= secondGnome && secondGnome >= thirdGnome);
			
			// 해당 놈 무리가 수염의 길이에 따라 순서대로 줄을 서 있는지 여부를 출력
			out.write((isOrdered) ? "Ordered" : "Unordered");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력 
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}