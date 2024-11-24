package bronze1.num15947;

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
		
		// 각 노래의 가사 순서를 저장할 배열 lyrics 초기화
		String[] lyrics = {
				"baby", "sukhwan", "tururu", "turu", "very", "cute", "tururu",
				"turu", "in", "bed", "tururu", "turu", "baby", "sukhwan"
		};
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 단어의 순서를 변수 targetOrder에 할당
		int targetOrder = Integer.parseInt(in.readLine()) - 1;
		
		// 입력 받은 순서에 해당하는 단어와 노래의 반복 횟수를 각 변수에 할당
		String word = lyrics[targetOrder % 14];
		int cycleCount = targetOrder / 14;
		
		// 입력 받은 순서에 해당하는 단어가 'tururu' 또는 'turu'인 경우
		if (word.equals("tururu") || word.equals("turu")) {
			
			// ru의 반복 횟수를 계산해 변수 count에 할당
			int count = (word.equals("tururu")) ? 2 + cycleCount : 1 + cycleCount;
			
			// 'ru'가 5번 이상 반복되는 경우 그 반복 횟수를 포함하여 출력
			if (count >= 5) {
				out.write("tu+ru*" + count);
				
			// 'ru'가 5번 미만 반복되는 경우
			} else {
				
				// write() 메서드를 사용해 'tu'를 출력
				out.write("tu");
				
				// while 반복문을 사용해 'ru'를 반복 횟수만큼 출력
				while (count-- > 0)
					out.write("ru");
			}
			
		// 입력 받은 순서에 해당하는 단어가 'tururu' 또는 'turu'가 아닌 경우 해당 단어를 출력
		} else {
			out.write(word);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}