package silver1.num27312;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 선정한 캐릭터의 수, 속성의 수를 각 변수에 할당
		int characterNum = Integer.parseInt(st.nextToken());
		int attributeNum = Integer.parseInt(st.nextToken());
		
		// 각 속성 값의 상한과 새 캐릭터의 속성을 저장할 배열 초기화
		int[] attributes = new int[attributeNum + 1];
		int[] newCharacter = new int[attributeNum + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 속성 값의 상한을 배열 attributes에 저장
		for (int idx = 1; idx < attributes.length; idx++)
			attributes[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 선정한 캐릭터 수 이하인 각 속성을 순회
		for (int idx = 1; idx <= characterNum; idx++) {
			
			// write() 및 flush() 메서드를 사용해 현재 캐릭터와 같은 번호의 속성 값을 질문
			out.write("? " + idx + " " + idx + "\n");
			out.flush();
			
			// readLine() 및 parseInt() 메서드를 사용해 질문의 답을 변수 answer에 할당
			int answer = Integer.parseInt(in.readLine());
			
			// 해당 캐릭터와 다른 새 캐릭터의 속성 값을 배열 newCharacters에 저장
			newCharacter[idx] = (answer == attributes[idx]) ? answer - 1 : answer + 1;
		}
		
		// fill() 메서드를 사용해 선정한 캐릭터 수를 넘어서는 새 캐릭터의 속성 값을 1로 설정
		Arrays.fill(newCharacter, characterNum + 1, attributeNum + 1, 1);
		
		// write() 메서드를 사용해 새로운 캐릭터의 속성을 제시하기 위한 기호를 출력
		out.write("! ");
		
		// for 반복문을 사용해 새로운 캐릭터의 속성을 출력
		for (int idx = 1; idx < newCharacter.length; idx++)
			out.write(newCharacter[idx] + " ");
		
		// newLine() 메서드를 사용해 줄바꿈을 출력
		out.newLine();
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}